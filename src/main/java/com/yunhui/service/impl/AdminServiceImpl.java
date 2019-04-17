package com.yunhui.service.impl;

import com.yunhui.bean.param.AdminAddParam;
import com.yunhui.bean.param.AdminQueryParam;
import com.yunhui.bean.param.AdminUpdateParam;
import com.yunhui.bean.po.Admin;
import com.yunhui.bean.po.AdminRole;
import com.yunhui.bean.vo.ManageAdminDetaiVO;
import com.yunhui.bean.vo.ManageAdminListVO;
import com.yunhui.bean.vo.ManagePermissionVO;
import com.yunhui.common.exception.CommonException;
import com.yunhui.common.page.PageResult;
import com.yunhui.common.result.ResultCode;
import com.yunhui.dao.AdminDAO;
import com.yunhui.dao.AdminRoleDAO;
import com.yunhui.service.AdminService;
import com.yunhui.service.PermissionService;
import com.yunhui.service.RoleService;
import com.yunhui.util.BeanCopy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Title: AdminServiceImpl.java <br>
 * Description: <br>
 * Copyright (c) 聚阿网络科技版权所有 2019 <br>
 * Create DateTime: 2019年03月13日 11:54 <br>
 *
 * @author yun
 */
@Service
@Slf4j
public class AdminServiceImpl implements AdminService {


    @Autowired
    AdminDAO adminDAO;

    @Autowired
    AdminRoleDAO adminRoleDAO;

    @Autowired
    PermissionService permissionService;

    @Autowired
    RoleService roleService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int add(Admin admin) {
        int addResult = adminDAO.addAdmin(admin);
        return addResult;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int add(AdminAddParam param) {
        Admin admin = BeanCopy.copyTo(param, Admin.class);
        int addResult = add(admin);
        if (!StringUtils.isEmpty(param.getRoleIds())) {
            batchAddAdminRole(admin.getId(),param.getRoleIds());
        }
        return addResult;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(Long adminId) {
        //删除管理员关联的角色记录
        adminRoleDAO.deleteByAdminId(adminId);
        return adminDAO.deleteAdmin(adminId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(Admin admin) {
        int updateResult = adminDAO.updateAdmin(admin);
        return updateResult;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(AdminUpdateParam param) {
        Admin admin = BeanCopy.copyTo(param, Admin.class);
        int updateResult = update(admin);
        if (!StringUtils.isEmpty(param.getRoleIds())) {
            adminRoleDAO.deleteByAdminId(param.getId());
            batchAddAdminRole(param.getId(),param.getRoleIds());
        }
        return updateResult;
    }

    @Override
    public int updatePass(Long adminId,String oldPass, String newPass){
        Admin admin = get(adminId);
        admin.setAdminPassword(newPass);
        return update(admin);
    }

    @Override
    public Admin get(Long adminId) {
        return adminDAO.getAdmin(adminId);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int batchAddAdminRole(Long adminId, String roleIds) {
        String[] roleIdss = roleIds.split(",");
        for (String roleId : roleIdss) {
            AdminRole adminRole = new AdminRole();
            adminRole.setAdminId(adminId);
            adminRole.setRoleId(Long.valueOf(roleId));
            adminRoleDAO.addAdminRole(adminRole);
        }
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String,Object> login(String account, String passwd, HttpServletRequest request) {
        Map<String,Object> map=new HashMap<>();
        Admin admin = adminDAO.findByAdminAccount(account);
        if(admin==null){
            throw  new CommonException(ResultCode.ADMIN_NOT_EXIST);
        }
        boolean flag=false;
        if(passwd.equals(admin.getAdminPassword())){
            flag=true;
        }
        if(!flag){
            throw  new CommonException(ResultCode.ADMIN_PASSWD_ERROR);
        }
        if(admin.getDeleted()){
            throw  new CommonException(ResultCode.ADMIN_DELETE);
        }
        //登陆成功
        HttpSession session = request.getSession();
        session.setAttribute("admin",admin);
        //非活动状态下session保存时间为60分钟
        session.setMaxInactiveInterval(60*60);
        List<Long> permisionIds = getPermisionIds(admin.getId());
        if(CollectionUtils.isEmpty(permisionIds)){
            return map;
        }
        String permisionIdStr = permisionIds.stream().map(String::valueOf).collect(Collectors.joining(","));
        List<ManagePermissionVO> managePermissionVOS = permissionService.listPermissionVO(permisionIdStr);
        session.setAttribute("menu", managePermissionVOS);
        map.put("menu", managePermissionVOS);
        List<String> permissionUrls = permissionService.listPermissionUrls(permisionIdStr);
        session.setAttribute("permissions",permissionUrls);
        map.put("permissions",permissionUrls);
        return map;

    }

    @Override
    public List<Long> getPermisionIds(Long adminId) {
        return adminRoleDAO.listPermissionIds(adminId);
    }

    @Override
    public PageResult<ManageAdminListVO> listAdminVO(AdminQueryParam param) {
        List<ManageAdminListVO> adminListVOS = adminDAO.listAdminVO(param);
        int count=0;
        if(param.getQueryCount()){
            count=adminDAO.countAdminVO(param);
        }
        return new PageResult<>(param.getPageNo(),param.getPageSize(),count,adminListVOS);
    }

    @Override
    public ManageAdminDetaiVO getAdminVO(Long id) {
        Admin admin = adminDAO.getAdmin(id);
        ManageAdminDetaiVO manageAdminDetaiVO = BeanCopy.copyTo(admin, ManageAdminDetaiVO.class);
        List<Long> roleIds = adminRoleDAO.listRoleIds(id);
        manageAdminDetaiVO.setRoleIds(roleIds);
        return manageAdminDetaiVO;
    }
}

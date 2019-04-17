package com.yunhui.service;
import com.yunhui.bean.param.AdminAddParam;
import com.yunhui.bean.param.AdminUpdateParam;
import com.yunhui.bean.po.Admin;
import com.yunhui.bean.param.AdminQueryParam;
import com.yunhui.bean.vo.ManageAdminDetaiVO;
import com.yunhui.bean.vo.ManageAdminListVO;
import com.yunhui.common.page.PageResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface AdminService {


    int add(Admin admin);

    int add(AdminAddParam param);

    int delete(Long adminId);

    int update(Admin admin);

    int update(AdminUpdateParam param);

    int updatePass(Long adminId, String oldPass, String newPass) throws Exception;

    Admin get(Long adminId);

    int batchAddAdminRole(Long adminId, String roleIds);

    Map<String,Object> login(String account, String passwd, HttpServletRequest request);

    List<Long> getPermisionIds(Long adminId);

    PageResult<ManageAdminListVO> listAdminVO(AdminQueryParam param);

    ManageAdminDetaiVO getAdminVO(Long id);

}

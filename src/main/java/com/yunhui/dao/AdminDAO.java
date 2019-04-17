package com.yunhui.dao;
import com.yunhui.bean.po.Admin;
import com.yunhui.bean.param.AdminQueryParam;
import com.yunhui.bean.vo.ManageAdminListVO;
import com.yunhui.common.exception.CommonException;
import com.yunhui.mapper.AdminMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.yunhui.common.result.ResultCode.DB_OPR_FAIL;

@Component
@Slf4j
public class AdminDAO {

    @Autowired
    AdminMapper adminMapper;

    public List<ManageAdminListVO> listAdminVO(AdminQueryParam param){
        try {
            return adminMapper.listAdminVO(param);
        }catch (Exception e){
            log.error("listAdminVO exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public int countAdminVO(AdminQueryParam param){
        try {
            return adminMapper.countAdminVO(param);
        }catch (Exception e){
            log.error("countAdminVO exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }


    public Admin findByAdminAccount(String account){
        try {
            return adminMapper.findByAdminAccount(account);
        }catch (Exception e){
            log.error("findByAdminAccount exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public int deleteAdmin(Long id){
        try {
            return adminMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            log.error("deleteAdmin exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public int addAdmin(Admin record){
        try {
            return adminMapper.insertSelective(record);
        }catch (Exception e){
            log.error("addAdmin exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public Admin getAdmin(Long id){
        try {
            return adminMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            log.error("getAdmin exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }

    public int updateAdmin(Admin record){
        try {
            return adminMapper.updateByPrimaryKeySelective(record);
        }catch (Exception e){
            log.error("updateAdmin exception", e);
            throw new CommonException(DB_OPR_FAIL);
        }
    }
}

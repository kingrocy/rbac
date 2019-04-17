package com.yunhui.web.controller;
import com.yunhui.bean.param.RoleAddParam;
import com.yunhui.bean.param.RoleQueryParam;
import com.yunhui.bean.param.RoleUpdateParam;
import com.yunhui.common.result.ResultJson;
import com.yunhui.service.RoleService;
import com.yunhui.web.aop.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("manage/role")
public class ManageRoleController  {

    @Autowired
    RoleService roleService;


    @PostMapping
    @Auth
    public String add(RoleAddParam param){
        int addResult = roleService.add(param);
        return ResultJson.success(addResult>0).toString();
    }

    @PutMapping
    @Auth
    public String update(RoleUpdateParam param){
        int updateResult = roleService.update(param);
        return ResultJson.success(updateResult>0).toString();
    }

    @GetMapping("{id}")
    @Auth
    public String get(@PathVariable("id")Long id){
        return ResultJson.success(roleService.getRoleVO(id)).toString();
    }

    @Auth
    @GetMapping
    public String list(RoleQueryParam param){
        return ResultJson.success(roleService.listRole(param)).toString();
    }

    @Auth
    @DeleteMapping("{id}")
    public String delete(@PathVariable("id")Long id){
        return ResultJson.success(roleService.delete(id)).toString();
    }

}

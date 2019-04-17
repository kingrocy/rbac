package com.yunhui.web.controller;
import com.yunhui.bean.param.PermissionAddParam;
import com.yunhui.bean.param.PermissionUpdateParam;
import com.yunhui.bean.po.Permission;
import com.yunhui.common.result.ResultJson;
import com.yunhui.service.PermissionService;
import com.yunhui.util.BeanCopy;
import com.yunhui.web.aop.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("manage/permission")
public class ManagePermissionController {

    @Autowired
    PermissionService permissionService;


    @Auth
    @PostMapping
    public String add(PermissionAddParam param){
        Permission permisson = BeanCopy.copyTo(param, Permission.class);
        permisson.setPermissionType(true);
        int result = permissionService.add(permisson);
        return ResultJson.success(result>0).toString();
    }

    @PutMapping
    @Auth
    public String update(PermissionUpdateParam param){
        int result = permissionService.update(param);
        return ResultJson.success(result>0).toString();
    }

    @DeleteMapping("{id}")
    @Auth
    public String delete(@PathVariable("id") Long id){
        return ResultJson.success(permissionService.delete(id)>0).toString();
    }

    @GetMapping("{id}")
    @Auth
    public String get(@PathVariable("id") Long id){
        return ResultJson.success(permissionService.get(id)).toString();
    }

    @GetMapping("list")
    @Auth
    public String list(){
        return ResultJson.success(permissionService.listPermissionVO(null)).toString();
    }


    @GetMapping("lv1")
    @Auth
    public String lv1(){
        return ResultJson.success(permissionService.listLv1Permission()).toString();
    }

}

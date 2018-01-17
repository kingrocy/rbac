package com.yunhui.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunhui.bean.po.Permisson;
import com.yunhui.service.interfaces.PermissionService;
import com.yunhui.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Yun
 * @Description:
 * @Date: Created in 2017-12-09 15:57
 */
@RestController
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @GetMapping("/permission")
    public ResponseEntity listPermissionWithParName(Permisson permisson, @RequestParam(value="pn",defaultValue = "1")Integer pn, @RequestParam(value="pageSize",defaultValue = "10")Integer pageSize){
        PageHelper.startPage(pn,pageSize);
        List<Permisson> list=permissionService.listPermissionWithParName(permisson);
        PageInfo<Permisson> pageInfo=new PageInfo<>(list,10);
        return  ResponseEntity.success().add("pageInfo",pageInfo);
    }

    @GetMapping("/listPermission")
    public ResponseEntity listPermission(Permisson permisson){
        List<Permisson> list=permissionService.listPermission(permisson);
        return  ResponseEntity.success().add("list",list);
    }

    @GetMapping("/permission-view")
    public ResponseEntity listPermissionView(){
        List<Permisson> list=permissionService.listPermissionView();
        return  ResponseEntity.success().add("list",list);
    }

    @PostMapping("/permission")
    public ResponseEntity addOrEditPermission(Permisson permission){
        if(permission==null){
            return ResponseEntity.error("参数错误");
        }
        if(permission.getPermissonId()==null){//新增
            Integer result=permissionService.add(permission);
            if(result>0){
                return ResponseEntity.success();
            }else{
                return ResponseEntity.error("新增失败");
            }
        }else{
            Integer result=permissionService.update(permission);
            if(result>0){
                return ResponseEntity.success();
            }else{
                return ResponseEntity.error("修改失败");
            }
        }
    }

    @DeleteMapping("/permission/{permissionId}")
    public ResponseEntity deletePermission(@PathVariable("permissionId")Integer permissionId){
        Integer result=permissionService.delete(permissionId);
        if(result>0){
            return ResponseEntity.success();
        }else{
            return ResponseEntity.error("删除失败");
        }
    }

    @GetMapping("/permission/{permissionId}")
    public ResponseEntity getPermission(@PathVariable("permissionId")Integer permissionId){
        Permisson permisson=permissionService.selectByPrimaryKey(permissionId);
        return ResponseEntity.success().add("permisson",permisson);
    }
}

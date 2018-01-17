package com.yunhui.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.SourceTree;
import com.yunhui.bean.po.Role;
import com.yunhui.bean.po.RolePermisson;
import com.yunhui.service.interfaces.RoleService;
import com.yunhui.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Yun
 * @Description:
 * @Date: Created in 2017-12-09 10:04
 */
@RestController
public class RoleController {

    @Autowired
    RoleService roleService;


    /**
     * 查询角色列表
     * @param role 查询参数
     * @param pn    页码
     * @param pageSize 每页显示数量
     * @param notAllowPage 不允许分页 参数大于0时生效
     * @return
     */
    @GetMapping("/role")
    public ResponseEntity listRole(Role role, @RequestParam(value="pn",defaultValue = "1")Integer pn, @RequestParam(value="pageSize",defaultValue = "10")Integer pageSize,@RequestParam(value="notAllowPage",defaultValue ="0") Integer notAllowPage){
        if(notAllowPage>0){
            List<Role> list=roleService.listRole(role);
            return ResponseEntity.success().add("list",list);
        }else{
            PageHelper.startPage(pn,pageSize);
            List<Role> list=roleService.listRole(role);
            PageInfo<Role> pageInfo=new PageInfo<>(list,10);
            return ResponseEntity.success().add("pageInfo",pageInfo);
        }
    }

    @PostMapping("/role")
    public ResponseEntity addOrEditRole(Role role){
        if(role==null){
            return ResponseEntity.error("参数错误");
        }
        if(role.getRoleId()==null){//新增
            Integer result=roleService.add(role);
            if(result>0){
                return ResponseEntity.success();
            }else{
                return ResponseEntity.error("新增失败");
            }
        }else{
            Integer result=roleService.update(role);
            if(result>0){
                return ResponseEntity.success();
            }else{
                return ResponseEntity.error("修改失败");
            }
        }
    }

    @DeleteMapping("/role/{roleId}")
    public ResponseEntity deleteRole(@PathVariable("roleId")Integer roleId){
        Integer result=roleService.delete(roleId);
        if(result>0){
            return ResponseEntity.success();
        }else{
            return ResponseEntity.error("删除失败");
        }
    }

    @GetMapping("/role/{roleId}")
    public ResponseEntity getRole(@PathVariable("roleId")Integer roleId){
        Role role=roleService.selectByPrimaryKey(roleId);
        return ResponseEntity.success().add("role",role);
    }


    /**
     * 根据角色ID获取此角色拥有的权限Id的集合
     * @param roleId
     * @return
     */
    @GetMapping("/role-permission/{roleId}")
    public ResponseEntity getRolePermission(@PathVariable("roleId")Integer roleId){
        List<RolePermisson> rolePermissons = roleService.listRolePermisson(roleId);
        List<Integer> permissonIds=rolePermissons.stream().map(RolePermisson::getPermissonId).collect(Collectors.toList());
        return ResponseEntity.success().add("permissonIds",permissonIds);
    }

    @PostMapping(value = "/role-authorization/{roleId}")
    public ResponseEntity RoleAuthorization(@PathVariable("roleId")Integer roleId,@RequestParam("permissonIds[]") Integer[] permissonIds){
        List<Integer> ids= Arrays.asList(permissonIds);
        List<RolePermisson> list=new ArrayList<>();
        RolePermisson rolePermisson=null;
        for(Integer id:ids){
            rolePermisson=new RolePermisson();
            rolePermisson.setRoleId(roleId);
            rolePermisson.setPermissonId(id);
            list.add(rolePermisson);
        }
        Integer result=roleService.batchInsert(list);
        if(result>0){
            return ResponseEntity.success();
        }else{
            return ResponseEntity.error("授权失败！");
        }
    }
}

package com.yunhui.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunhui.bean.po.Permisson;
import com.yunhui.bean.po.User;
import com.yunhui.bean.po.UserRole;
import com.yunhui.service.interfaces.PermissionService;
import com.yunhui.service.interfaces.UserService;
import com.yunhui.util.LogFactory;
import com.yunhui.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Yun
 * @Description:
 * @Date: Created in 2017-12-09 10:04
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PermissionService permissionService;

    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity login(User user){
        LogFactory.info("user-----"+user);
        List<User> list=userService.listUser(user);
        if(list!=null&&list.size()==1){
            User user1=list.get(0);
            String urls="";
            if(user1!=null){
                //查询用户的权限
                List<Permisson> permissions=permissionService.getUserPermissons(user1.getUserId());
                urls=permissions.stream().map(Permisson::getPermissonUrl).collect(Collectors.joining(","));
            }
            return ResponseEntity.success().add("urls",urls);
        }else{
            return ResponseEntity.error("登陆失败,账号或密码错误");
        }
    }


    @GetMapping("/user")
    public ResponseEntity listUser(User user, @RequestParam(value="pn",defaultValue = "1")Integer pn, @RequestParam(value="pageSize",defaultValue = "10")Integer pageSize){
        PageHelper.startPage(pn,pageSize);
        List<User> list=userService.listUser(user);
        PageInfo<User> pageInfo=new PageInfo<>(list,10);
        return ResponseEntity.success().add("pageInfo",pageInfo);
    }

    @PostMapping("/user")
    public ResponseEntity addOrEditUser(User user){
        if(user==null){
            return ResponseEntity.error("参数错误");
        }
        if(user.getUserId()==null){//新增
            Integer result=userService.add(user);
            if(result>0){
                return ResponseEntity.success();
            }else{
                return ResponseEntity.error("新增失败");
            }
        }else{
            Integer result=userService.update(user);
            if(result>0){
                return ResponseEntity.success();
            }else{
                return ResponseEntity.error("修改失败");
            }
        }
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId")Integer userId){
        Integer result=userService.delete(userId);
        if(result>0){
            return ResponseEntity.success();
        }else{
            return ResponseEntity.error("删除失败");
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity getUser(@PathVariable("userId")Integer userId){
        User user=userService.selectByPrimaryKey(userId);
        return ResponseEntity.success().add("user",user);
    }


    @PostMapping("/listUserRoles")
    public ResponseEntity listUserRoles(UserRole userRole){
        List<UserRole> userRoles = userService.listUserRoles(userRole);
        String ids="";
        for(UserRole userRole1:userRoles){
            ids+=userRole1.getRoleId()+",";
        }
        return ResponseEntity.success().add("roleIds",ids.substring(0,ids.length()-1));
    }

}

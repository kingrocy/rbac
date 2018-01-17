package com.yunhui.service.impl;

import com.yunhui.bean.po.User;
import com.yunhui.bean.po.UserRole;
import com.yunhui.dao.UserMapper;
import com.yunhui.dao.UserRoleMapper;
import com.yunhui.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Yun
 * @Description:
 * @Date: Created in 2017-12-08 17:00
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRoleMapper userRoleMapper;


    @Transactional
    @Override
    public Integer add(User user) {
        Integer result=userMapper.insertSelective(user);
        System.out.println("result============"+result);
        if(user.getUserRoles()!=null){
            String []strs=user.getUserRoles().split(",");
            List<UserRole> userRoles=new ArrayList<>();
            UserRole userRole=null;
            for(String str:strs){
                userRole=new UserRole();
                userRole.setUserId(user.getUserId());
                userRole.setRoleId(Integer.parseInt(str));
                userRoles.add(userRole);

            }
            Integer i=userRoleMapper.batchInsert(userRoles);
            System.out.println("i========="+i);
        }
        return result;
    }

    @Override
    public Integer delete(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public Integer update(User user) {
        Integer result= userMapper.updateByPrimaryKeySelective(user);
        userRoleMapper.deleteByUserId(user.getUserId());
        if(user.getUserRoles()!=null){
            String []strs=user.getUserRoles().split(",");
            List<UserRole> userRoles=new ArrayList<>();
            UserRole userRole=null;
            for(String str:strs){
                userRole=new UserRole();
                userRole.setUserId(user.getUserId());
                userRole.setRoleId(Integer.parseInt(str));
                userRoles.add(userRole);
            }
            Integer i=userRoleMapper.batchInsert(userRoles);
            System.out.println("i========="+i);
        }
        return result;
    }

    @Override
    public List<User> listUser(User user) {
        return userMapper.listUser(user);
    }

    @Override
    public User selectByPrimaryKey(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<UserRole> listUserRoles(UserRole userRole) {
        return userRoleMapper.listUserRoles(userRole);
    }
}

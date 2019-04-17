package com.yunhui.web.controller;
import com.yunhui.bean.param.AdminAddParam;
import com.yunhui.bean.param.AdminQueryParam;
import com.yunhui.bean.param.AdminUpdateParam;
import com.yunhui.common.result.ResultJson;
import com.yunhui.service.AdminService;
import com.yunhui.web.aop.annotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import static com.yunhui.common.result.ResultCode.PARAMS_EXCEPTION;


/**
 * Title: ManageAdminController.java <br>
 * Description: <br>
 * Copyright (c) 聚阿网络科技版权所有 2019 <br>
 * Create DateTime: 2019年03月13日 14:09 <br>
 *
 * @author yun
 */
@RestController
@RequestMapping("manage/admin")
@Slf4j
public class ManageAdminController{


    @Autowired
    AdminService adminService;

    @PostMapping("login")
    public String login(String account, String passwd, HttpServletRequest request) {
        Map<String, Object> map = adminService.login(account, passwd, request);
        return ResultJson.success(map).toString();
    }

    @PostMapping("logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return ResultJson.success().toString();
    }

    @Auth
    @PostMapping
    public String add(AdminAddParam param) {
        int addResult = adminService.add(param);
        return ResultJson.success(addResult > 0).toString();
    }

    @Auth
    @PutMapping
    public String update(AdminUpdateParam param) {
        int updateResult = adminService.update(param);
        return ResultJson.success(updateResult > 0).toString();
    }

    @GetMapping
    public String list(AdminQueryParam param) {
        return ResultJson.success(adminService.listAdminVO(param)).toString();
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Long id) {
        return ResultJson.success(adminService.delete(id) > 0).toString();
    }

    @GetMapping("{id}")
    public String get(@PathVariable("id") Long id) {
        return ResultJson.success(adminService.getAdminVO(id)).toString();
    }

}


package com.yunhui.web.controller;

import com.yunhui.bean.po.User;
import com.yunhui.util.LogFactory;
import com.yunhui.util.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Yun
 * @Description:
 * @Date: Created in 2017-12-08 15:23
 */
@Controller
public class CoreController {

    @GetMapping("/")
    public String index(){
        return "login";
    }


    @GetMapping("/page/{page}")
    public String jump(@PathVariable("page")String page) {
        return page;
    }
}

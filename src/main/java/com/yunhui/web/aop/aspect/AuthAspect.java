package com.yunhui.web.aop.aspect;
import com.yunhui.bean.po.Admin;
import com.yunhui.common.exception.CommonException;
import com.yunhui.common.result.ResultCode;
import com.yunhui.web.aop.annotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Aspect
@Component
@Slf4j
public class AuthAspect {

    @Autowired
    HttpServletRequest request;


    @Before("@annotation(auth)")
    public void before(Auth auth) {
        String url = auth.url();
        if (StringUtils.isEmpty(url)) {
            url = request.getRequestURI();
            String requestMethod = request.getMethod();
            url = url + "{" + requestMethod.toLowerCase() + "}";
        }
        log.info("access auth:" + url);
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        List<String> permissions = (List<String>) session.getAttribute("permissions");
        if (permissions == null || !permissions.contains(url)) {
            log.error("adminId:{},adminAccount:{},no auth access url:{}", admin.getId(), admin.getAdminAccount(), url);
            throw new CommonException(ResultCode.NO_AUTH);
        }
        log.info("adminId:{},adminAccount:{}, access url success:{}", admin.getId(), admin.getAdminAccount(), url);
    }

}

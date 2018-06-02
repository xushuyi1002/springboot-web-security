package com.sinosoft.controller;

import com.sinosoft.common.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xushuyi on 2018/4/6.
 */
@Slf4j
@Controller
@RequestMapping("/")
public class LoginController {

    /**
     * 执行登录
     *
     * @return page
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        log.info("Login...");
        // 获取安全认证后的用户信息
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!CommonUtil.isEmpty(principal)) {
            String username = (principal instanceof UserDetails)
                    ? ((UserDetails) principal).getUsername()
                    : principal.toString();
            log.info("Login Username：" + username);
            if (!CommonUtil.isEmpty(username)
                    && !"anonymousUser".equals(username)) {
                return "home"; // 跳转到登录成功界面
            }
        }
        return "login"; // 登录界面
    }

}

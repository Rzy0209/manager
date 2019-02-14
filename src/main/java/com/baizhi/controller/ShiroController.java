package com.baizhi.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/shiro")
public class ShiroController {

    @RequestMapping("login")
    public String login(String name, String password, String code, HttpSession session, HttpServletResponse response) {
        try {
            Subject subject = SecurityUtils.getSubject();
            AuthenticationToken token = new UsernamePasswordToken(name, password);

            String cd = (String) session.getAttribute("code");
            if (cd.equals(code)) {
                subject.login(token);
                return "redirect:/main/main.jsp";
            } else {
                System.out.println("验证码错误");
                return "redirect:/error.jsp";
            }

        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错");
            return "redirect:/error.jsp";
        } catch (UnknownAccountException e) {
            System.out.println("账号错");
            return "redirect:/error.jsp";
        }
    }

    @RequestMapping("logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login.jsp";
    }

}

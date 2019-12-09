package com.zking.p2p.controller;

import com.zking.p2p.model.UserInfo;
import com.zking.p2p.service.IUserInfoService;
import com.zking.p2p.util.PhoneZz;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
@RequestMapping(value = "/UserInfo")
@Controller
public class UserInfoController {
    @Autowired
    private IUserInfoService userInfoService;

    @RequestMapping(value = "/login")
    public String login(UserInfo userInfo){
        String uname=userInfo.getUname();
        String pwd=userInfo.getPwd();
        System.out.println(uname);
        System.out.println(pwd);
        UserInfo login = userInfoService.login(userInfo);
//        System.out.println(login);
        if (login!=null){
            return "index";
        }else {
            return "login";
        }


    }

    @RequestMapping(value = "/All")
    @ResponseBody
    public List<UserInfo> all(UserInfo userinfo) {
        List<UserInfo> userInfo = userInfoService.selectByPrimaryKey(userinfo);
        return userInfo;
    }
//注册（包括正则）
    @RequestMapping(value = "/zc")
    public String zc(UserInfo userInfo, HttpSession session){
        System.out.println(userInfo);
        if (userInfo.getPhone()==""||userInfo.getPhone()==null) {
            String q = "请验证手机号再操作";
            session.setAttribute("iphoneNull", q);
            System.out.println(session.getAttribute("iphoneNull"));
             userInfoService.insert(userInfo);
            return "login";
        } else if (userInfo.getPhone()!=null||userInfo.getPhone()!=""){
            PhoneZz.zz(userInfo.getPhone(), session);
            if (session.getAttribute("iphone1")!=null){
                System.out.println(session.getAttribute("iphone1"));
                return  "zc";
            }else if(session.getAttribute("iphone1")==null) {
                if (session.getAttribute("iphone")==null) {
                    userInfoService.insert2(userInfo);
                    return "login";
                } else {
                    System.out.println(session.getAttribute("iphone"));
                    return "zc";
                }
            }

            }
        return  "zc";


        }







}
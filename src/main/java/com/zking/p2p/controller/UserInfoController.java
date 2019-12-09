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
   /* @ModelAttribute
    public void init(Model model){
        UserInfo userInfos=new UserInfo();
        model.addAttribute("userInfos",userInfos);
        System.out.println("init...");

    }*/

    @RequestMapping(value = "/All")
    @ResponseBody
    public List<UserInfo> all(UserInfo userinfo) {
        List<UserInfo> userInfo = userInfoService.selectByPrimaryKey(userinfo);
        return userInfo;
    }

    @RequestMapping(value = "/zc")
    public String zc(UserInfo userInfo, HttpSession session){
        System.out.println(userInfo);
        if (userInfo.getPhone()==null) {
            String q = "请验证手机号再操作";
            session.setAttribute("iphoneNull", q);
            System.out.println(session.getAttribute("iphoneNull"));
             userInfoService.insert(userInfo);
            return "index";
        } else if (userInfo.getPhone()!=null){
          String iphone=userInfo.getPhone();
            PhoneZz.zz(iphone, session);
            if (session.getAttribute("iphone1")==null){
                System.out.println(userInfo.getPhone());
                return  "zc";
            }else if(session.getAttribute("iphone1")!=null) {
                if (session.getAttribute("iphone") == null) {
                    userInfoService.insert2(userInfo);
                    return "index";
                } else {
                    System.out.println(session.getAttribute("iphone"));
                    System.out.println(userInfo.getPhone());
                    return "zc";
                }
            }

            }
        return  "zc";


        }

        //既然登录成功了带一个他的级别id*/





}
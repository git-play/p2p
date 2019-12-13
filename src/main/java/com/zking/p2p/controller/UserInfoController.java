package com.zking.p2p.controller;

import com.zking.p2p.model.UserInfo;
import com.zking.p2p.service.IUserInfoService;
import com.zking.p2p.util.Email;
import com.zking.p2p.util.JsonData;
import com.zking.p2p.util.PhoneZz;
import com.zking.p2p.util.WriteJson;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
@RequestMapping(value = "/UserInfo")
@Controller
public class UserInfoController extends  BaseAction{
    @Autowired
    private IUserInfoService userInfoService;


    @RequestMapping(value = "/login")
    @ResponseBody
    public  UserInfo login(UserInfo userInfo){
        WriteJson writeJson=new WriteJson();
        String uname=userInfo.getUname();
        String pwd=userInfo.getPwd();
        JsonData jsonData = new JsonData();
        UserInfo login = userInfoService.login(userInfo);
        if (login!=null){
            jsonData.setCode(0);
//            this.writeJson(jsonData);
            return login;
        }else {
            jsonData.setCode(1);
//            this.writeJson(jsonData);
            return null;
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
        UserInfo u = userInfoService.byName(userInfo);
        if(u==null||u.equals("")){
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
       }
        return  "zc";


        }

    @RequestMapping(value = "/yx")
    public String yx() {
        String email="1933274533@qq.com";
        String vcode="324323";
        try {
            Email.sendMail(email,vcode);

        } catch (Exception e){
            e.printStackTrace();
        }
        return "index";
    }





}
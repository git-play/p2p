package com.zking.p2p.util;

import org.apache.shiro.web.session.HttpServletSession;

import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//手机号正则
public  class PhoneZz {
    public static void zz(String phone, HttpSession session) {
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0-9]|(19[1,8,9])))\\d{8}$";
        if(phone.length() != 11){
            session.setAttribute("iphone1","手机号要为11位");
        }else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
            if (isMatch) {

            } else {
                session.setAttribute("iphone","您的手机号" + phone + "是错误格式！！！");
            }
        }

    }

}

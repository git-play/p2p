package com.zking.p2p.controller;

import com.zking.p2p.model.UserInfo;
import com.zking.p2p.service.IUserInfoService;
import com.zking.p2p.util.PhoneZz;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*@RequestMapping(value = "/w")*/
@Controller
public class HelloController {

    @RequestMapping(value = "/hello/index.html")
    public String play(){
        return "zc";
    }





}
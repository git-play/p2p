package com.zking.p2p.model;

import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@ToString
public class UserInfo {
    private Integer uid;
    @NotNull(message = "价格不能为空")
    private String uname;
    @NotNull(message = "密码不能为空")
    @Range(min =6,max = 10,message ="密码不能大于10位小于6位" )
    private String pwd;

    private String usex;

    private Integer uage;

    private String cardid;

    private String phone;

    private String bankcard;

    private Integer userstate;

    private Integer creditscore;


    public UserInfo(Integer uid, String uname, String pwd, String usex, Integer uage, String cardid, String phone, String bankcard, Integer userstate, Integer creditscore) {
        this.uid = uid;
        this.uname = uname;
        this.pwd = pwd;
        this.usex = usex;
        this.uage = uage;
        this.cardid = cardid;
        this.phone = phone;
        this.bankcard = bankcard;
        this.userstate = userstate;
        this.creditscore = creditscore;
    }

    public UserInfo() {
        super();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public Integer getUage() {
        return uage;
    }

    public void setUage(Integer uage) {
        this.uage = uage;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public Integer getUserstate() {
        return userstate;
    }

    public void setUserstate(Integer userstate) {
        this.userstate = userstate;
    }

    public Integer getCreditscore() {
        return creditscore;
    }

    public void setCreditscore(Integer creditscore) {
        this.creditscore = creditscore;
    }
}
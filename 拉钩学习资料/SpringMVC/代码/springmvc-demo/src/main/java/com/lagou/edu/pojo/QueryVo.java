package com.lagou.edu.pojo;

/**
 * @author 应癫
 */
public class QueryVo {

    private String mail;
    private String phone;

    // 嵌套了另外的Pojo对象
    private User user;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

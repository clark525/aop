package com.hang.aopxml;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by clark on 17/8/14.
 */
public class Look {

    private Set<String> set;
    private LogAfter logAfter;
    private InnerBean innerBean;
    private List<User> users;
    private Map<String,String> map;

    private void createLook() {
        System.out.println("create look");
    }

    public void doLook() {
        System.out.println("look at me");

        logAfter.doIt();

        innerBean.create();
    }

    private void destoryLook() {
        System.out.println("destory look");
    }

    public LogAfter getLogAfter() {
        return logAfter;
    }

    public void setLogAfter(LogAfter logAfter) {
        this.logAfter = logAfter;
    }

    public void setInnerBean(InnerBean innerBean) {
        this.innerBean = innerBean;
    }

    public InnerBean getInnerBean() {
        return innerBean;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}

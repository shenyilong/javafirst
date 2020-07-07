package com.shen.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ConfigurationProperties(prefix = "person")
public class QuickController3 {

    private String name;
    private String addr;
    @RequestMapping("/quicke3")
    @ResponseBody

    public String quicke3(){

        return "name: "+name+"\naddr: asdsaasdasdasd"+addr;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

}

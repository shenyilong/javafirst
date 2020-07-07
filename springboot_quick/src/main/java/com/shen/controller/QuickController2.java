package com.shen.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuickController2 {
    @Value("${name}")
    private String name;
    @Value("${person.addr}")
    private String addr;
    @RequestMapping("/quicke2")
    @ResponseBody
    public String quicke2(){

        return "name: "+name+"\naddr: "+addr;

    }
}

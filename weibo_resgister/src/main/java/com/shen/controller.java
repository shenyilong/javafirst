package com.shen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/use")
public class controller {
    //
    @RequestMapping("/login")
    @ResponseBody
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/login");
        return mv;
    }
    //注册跳转使用跳转到zhuce.jsp，进行注册。
    @RequestMapping("/zhuce")
    public String szhuce(){
        return "zhuce";
    }
    //这个为登录的.jsp,在MySQL中查找该账号是否注册过，从而判定该登录情况是否成功。
    @RequestMapping("/authlogin")
    public ModelAndView authlogin(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        ModelAndView mv = new ModelAndView();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        UsersDAO userdao = new UsersDAO();
        if(userdao.trueFalse(username,password)){
            mv.setViewName("user/success");
        }else{
            mv.setViewName("user/failure");
        }
        return mv;
    }
    //注册信息，写入MySQL数据库中，为是否成功登录作为依据
    @RequestMapping("/authReg")
    public ModelAndView authReg(HttpServletRequest request, Users user, Model model)
    {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ModelAndView mv = new ModelAndView();
        UsersDAO usersdao = new UsersDAO();
        if(usersdao.saveUsers(user)!=0)
        {
            mv.setViewName("user/index");
        }
        else
        {
            mv.setViewName("user/failure");
        }
        return mv;
    }
}

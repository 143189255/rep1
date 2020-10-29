package com.bruceliu.controller;

import com.bruceliu.pojo.Emp;
import com.bruceliu.service.EmpService;
import com.bruceliu.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: bruceliu
 * @Date: 2019/12/9 11:06
 * @QQ:1241488705
 * @Description:
 */
@Controller
public class EmpController {

    @Autowired
    EmpService empService;

    @RequestMapping("/emp_login")
    @ResponseBody
    public ResultMessage login(Emp emp, HttpServletResponse response) throws Exception{
        ResultMessage message=null;
        response.setContentType("text/html;charset=utf-8");
        System.out.println("要登录的对象是:"+emp);
        Emp loginEmp = empService.login(emp);
        if(loginEmp!=null){
            if(loginEmp.getFlag()==1){
                //登录成功去重定向首页
               // response.sendRedirect("index.jsp");
               message = new ResultMessage(100,"登录成功");
            }else{
                //response.getWriter().write("<script>alert('账号已经被禁用，请联系管理员!');location.href='login.jsp';</script>");
                message = new ResultMessage(200,"账号已经被禁用，请联系管理员!");
            }
        }else{
           // response.getWriter().write("<script>alert('账号或密码错误!');location.href='login.jsp';</script>");
            message = new ResultMessage(300,"账号或密码错误");
        }
        return message;
    }
}

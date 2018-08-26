package com.neuedu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "/student")
public class studentcontroller {
    @RequestMapping(value = {"/hello", "/world"}, method = RequestMethod.GET)
    /* (@RequestParam("username") String  name   相同前面可以不写
     * HTTP直接写*/
    public String hello(@RequestParam("username") String name, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(name);
        session.setAttribute("username", name);
        //view --> 前缀+后缀  /WEB-INF/jsp/hello.jsp"
        return "hello";
    }

    @RequestMapping(value = "/hello2")
    public String hello2(@RequestParam("username") String name, Model model) {
        model.addAttribute("username", name);
        return "hello";
    }

    @RequestMapping(value = "/hello3")
    public String hello3(@RequestParam("username") String name, Map<String, String> map) {
        map.put("username", name);
        return "hello";
    }

    @RequestMapping(value = "/hello4")
    public ModelAndView hello4(@RequestParam("username") String name, ModelAndView modelAndView) {
        modelAndView.addObject("username", name);
        modelAndView.setViewName("hello");
        return modelAndView;
    }
//restful:以资源为导向的架构风格
    @RequestMapping(value="/hello5/{username}")
    public   String  hello5(@PathVariable("username") String  name,Model model){
        model.addAttribute("username", name);
        return "hello";
    }


}

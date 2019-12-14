package com.example.controller;/*
 * @Created by Administrator
 * @Created 2019/12/13
 * @Comment
 */

import com.example.pojo.BusinessServiceMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/diff")
public class DiffController {

    @RequestMapping
    public String diff(){
        return "/page/index.html";
    }

    public Map<String,Object> queryMethodByBS(BusinessServiceMethod method){
        return null;
    }


}

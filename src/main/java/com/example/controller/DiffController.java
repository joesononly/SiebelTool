package com.example.controller;/*
 * @Created by Administrator
 * @Created 2019/12/13
 * @Comment
 */

import com.example.diff.dao.Service.ObjectService;
import com.example.pojo.BusinessService;
import com.example.pojo.BusinessServiceMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/diff")
public class DiffController {

    @Autowired
    ObjectService objectService;

    @RequestMapping
    public String diff(){
        return "/page/diff/diff.html";
    }

    @RequestMapping("/index")
    public String index(){
        return "/page/index.html";
    }

    @RequestMapping("/method")
    public String method(){
        return "/page/method.html";
    }

    @RequestMapping("/queryMethodByBS")
    @ResponseBody
    public Map<String,Object> queryMethodByBS(BusinessServiceMethod method){
        Map<String,Object> result = new HashMap<>();
        try{
            List<BusinessServiceMethod> businessServiceMethods = objectService.queryMethodByBS(method);
            result.put("data",businessServiceMethods);
            result.put("status","success");
        }catch (Exception e){
            e.printStackTrace();
            result.put("status","error");
            result.put("message",e.getMessage());
        }
        return result;
    }

    @RequestMapping("/queryBsByName")
    @ResponseBody
    public Map<String,Object> queryBsByName(BusinessService bs){
        Map<String,Object> result = new HashMap<>();
        try{
            List<BusinessService> businessServices = objectService.queryBsByName(bs);
            result.put("data",businessServices);
            result.put("status","success");

        }catch (Exception e){
            e.printStackTrace();
            result.put("status","error");
            result.put("message",e.getMessage());
        }

        return result;
    }


}

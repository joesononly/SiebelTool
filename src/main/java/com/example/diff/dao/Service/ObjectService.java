package com.example.diff.dao.Service;/*
 * @Created by Administrator
 * @Created 2019/12/13
 * @Comment
 */

import com.example.diff.dao.mapper.BusinessServiceMapper;
import com.example.pojo.BusinessService;
import com.example.pojo.BusinessServiceMethod;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectService {

    @Autowired
    private BusinessServiceMapper bmMapper;

    /**
     * @Comment 通过Bs名称查询方法
     * @param businessServiceMethod
     * @return
     */
    public List<BusinessServiceMethod> queryMethodByBS(BusinessServiceMethod businessServiceMethod){
        PageHelper.startPage(1, 10);
        return bmMapper.queryMethodByBS(businessServiceMethod);
    }

    /**
     * @Comment 查询Bs
     * @param businessService
     * @return
     */
    public List<BusinessService> queryBsByName(BusinessService businessService){
        PageHelper.startPage(1, 10);
        return bmMapper.queryBsByName(businessService);
    }
}

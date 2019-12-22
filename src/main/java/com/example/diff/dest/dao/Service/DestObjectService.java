package com.example.diff.dest.dao.Service;/*
 * @Created by Administrator
 * @Created 2019/12/13
 * @Comment
 */

import com.example.diff.dest.dao.mapper.DestBusinessServiceMapper;
import com.example.pojo.BusinessService;
import com.example.pojo.BusinessServiceMethod;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestObjectService {

    @Autowired
    private DestBusinessServiceMapper bmMapper;

    /**
     * @Comment 通过Bs名称查询方法
     * @param businessServiceMethod
     * @return
     */
    public BusinessServiceMethod queryMethodByBS(BusinessServiceMethod businessServiceMethod){
        return bmMapper.queryMethodByBS(businessServiceMethod);
    }

    /**
     * @Comment 查询Bs
     * @param businessService
     * @return
     */
    public List<BusinessService> queryBsByName(BusinessService businessService){
        return bmMapper.queryBsByName(businessService);
    }
}

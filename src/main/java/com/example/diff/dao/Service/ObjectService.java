package com.example.diff.dao.Service;/*
 * @Created by Administrator
 * @Created 2019/12/13
 * @Comment
 */

import com.example.diff.dao.Mapper.BusinessServiceMapper;
import com.example.pojo.BusinessServiceMethod;
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
    private List<BusinessServiceMethod> queryMethodByBS(BusinessServiceMethod businessServiceMethod){
        return bmMapper.queryMethodByBS(businessServiceMethod);
    }
}

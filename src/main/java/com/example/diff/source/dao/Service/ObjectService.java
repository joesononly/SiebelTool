package com.example.diff.source.dao.Service;/*
 * @Created by Administrator
 * @Created 2019/12/13
 * @Comment
 */

import com.example.diff.source.dao.mapper.BusinessServiceMapper;
import com.example.pojo.BusinessService;
import com.example.pojo.BusinessServiceMethod;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.diff.dest.dao.Service.DestObjectService;

import java.util.List;

@Service
public class ObjectService {

    @Autowired
    private BusinessServiceMapper bmMapper;

    @Autowired
    private DestObjectService destObjectService;

    /**
     * @Comment 通过Bs名称查询方法
     * @param businessServiceMethod
     * @return
     */
    public List<BusinessServiceMethod> queryMethodByBS(BusinessServiceMethod businessServiceMethod){

        if(businessServiceMethod.getBusinessService() == null || "".equals(businessServiceMethod.getBusinessService()))
            throw new NullPointerException("业务服务名称不能为空");

        if("".equals(businessServiceMethod.getMethodName()))
            businessServiceMethod.setMethodName(null);

        PageHelper.startPage(businessServiceMethod.getPage(), businessServiceMethod.getRows());
        List<BusinessServiceMethod> ms = bmMapper.queryMethodByBS(businessServiceMethod);

        for(BusinessServiceMethod m:ms){
            BusinessServiceMethod destMethod = destObjectService.queryMethodByBS(m);
            m.setDestMethod(destMethod);
        }
        return ms;
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

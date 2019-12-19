package com.example.diff.dao.mapper;

import com.example.pojo.BusinessService;
import com.example.pojo.BusinessServiceMethod;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BusinessServiceMapper {

    public List<BusinessServiceMethod> queryMethodByBS(BusinessServiceMethod bm);

    public List<BusinessService> queryBsByName(BusinessService bs);
}

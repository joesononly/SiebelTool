package com.example.diff.dao.Mapper;

import com.example.pojo.BusinessServiceMethod;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BusinessServiceMapper {

    public List<BusinessServiceMethod> queryMethodByBS(BusinessServiceMethod bm);
}

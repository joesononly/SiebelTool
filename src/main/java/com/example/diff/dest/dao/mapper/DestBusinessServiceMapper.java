package com.example.diff.dest.dao.mapper;

import com.example.pojo.BusinessService;
import com.example.pojo.BusinessServiceMethod;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("DestSqlSessionTemplate")
public interface DestBusinessServiceMapper {

    public BusinessServiceMethod queryMethodByBS(BusinessServiceMethod bm);

    public List<BusinessService> queryBsByName(BusinessService bs);
}

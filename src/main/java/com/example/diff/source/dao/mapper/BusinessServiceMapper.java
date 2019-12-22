package com.example.diff.source.dao.mapper;

import com.example.pojo.BusinessService;
import com.example.pojo.BusinessServiceMethod;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("SourceSqlSessionTemplate")
public interface BusinessServiceMapper {

    public List<BusinessServiceMethod> queryMethodByBS(BusinessServiceMethod bm);

    public List<BusinessService> queryBsByName(BusinessService bs);
}

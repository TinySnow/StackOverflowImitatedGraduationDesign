package com.tinysnow.system;

import com.tinysnow.system.model.Test;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

    public Test test();
}

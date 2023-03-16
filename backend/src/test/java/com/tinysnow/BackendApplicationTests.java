package com.tinysnow;

import com.tinysnow.system.TestMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendApplicationTests {

    @Autowired
    TestMapper testMapper;

    @Test
    void contextLoads() {
        System.out.println(testMapper.test());
    }
}

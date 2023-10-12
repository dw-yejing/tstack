package edu.bjtu.kafka.controller;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class ConsumerControllerTest {

    @Test
    public void test1(){
        String snowflakeNextIdStr = IdUtil.getSnowflakeNextIdStr();
        String s1 = Long.toString(IdUtil.getSnowflakeNextId(), 2);


        String objectId = IdUtil.objectId();
        String s = IdUtil.fastSimpleUUID();

        System.out.println(snowflakeNextIdStr);
    }
}
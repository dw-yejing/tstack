package edu.bjtu.elasticsearch.service.province;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@MapperScan("edu.bjtu.elasticsearch.mapper")
public class ProvinceServiceTest {
    @Autowired
    private ProvinceService provinceService;

    @Test
    public void test2(){
        String queryString = "ti,abst=(无人机 or 潜艇)) not (ti=无人机";
        QueryParser queryParser = new QueryParser("", new StandardAnalyzer());
        Query query = queryParser.parse(queryString);

        SearchResponse response = client.prepareSearch("myindex")
                .setQuery(query)
                .execute()
                .actionGet();

    }

    @Test
    public void test1(){
        provinceService.generateExcel();
    }
}
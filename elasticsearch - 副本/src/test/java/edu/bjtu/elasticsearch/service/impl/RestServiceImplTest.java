package edu.bjtu.elasticsearch.service.impl;

import cn.easyes.core.conditions.LambdaEsQueryWrapper;
import cn.easyes.starter.register.EsMapperScan;
//import edu.bjtu.elasticsearch.entity.OrderSynWide;
import edu.bjtu.elasticsearch.entity.OrderSynWide2;
import edu.bjtu.elasticsearch.mapper.OrderSynWideESMapper;
//import edu.bjtu.elasticsearch.service.RestService;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Query;
import org.elasticsearch.action.search.SearchResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@EsMapperScan("edu.bjtu.elasticsearch.mapper")
@RunWith(SpringRunner.class)
public class RestServiceImplTest {
//    @Autowired
//    private RestService restService;
    @Autowired
    private OrderSynWideESMapper orderSynWideESMapper;
    @Autowired
    private ElasticsearchRestTemplate client;

    @Test
    public void test2() throws Exception{
        String queryString = "ti,abst=(无人机 or 潜艇)) not (ti=无人机";
        QueryParser queryParser = new QueryParser("", new StandardAnalyzer());
        Query query = queryParser.parse(queryString);

        SearchResponse response = client.prepareSearch("myindex")
                .setQuery(query)
                .execute()
                .actionGet();

    }

    @Test
    public void test1() {
        OrderSynWide2 orderSynWide = new OrderSynWide2();
        orderSynWide.setOrderNum("网络-202212120987");
        Integer insert = orderSynWideESMapper.insert(orderSynWide);
        LambdaEsQueryWrapper<OrderSynWide2> queryWrapper = new LambdaEsQueryWrapper<OrderSynWide2>().eq(OrderSynWide2::getOrderNum, "网络-202212120987");
        List<OrderSynWide2> orderSynWide2s = orderSynWideESMapper.selectList(queryWrapper);
        System.out.println(insert);
    }

//    @Test
//    public void search() {
//        restService.search();
//    }

    @Test
    public void aggregate() {
    }
//
//    @Test
//    void addDoc() {
//    }
//
//    @Test
//    void updateDoc() {
//    }
}
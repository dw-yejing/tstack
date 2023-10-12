//package edu.bjtu.elasticsearch.service.impl;
//
//import edu.bjtu.elasticsearch.entity.OrderSynWide;
//import edu.bjtu.elasticsearch.entity.StatisticsWide;
//import edu.bjtu.elasticsearch.service.RestService;
//import edu.bjtu.elasticsearch.vo.ResultVO;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.elasticsearch.action.search.SearchType;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.index.query.BoolQueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.aggregations.Aggregation;
//import org.elasticsearch.search.aggregations.AggregationBuilders;
//import org.elasticsearch.search.aggregations.Aggregations;
//import org.elasticsearch.search.aggregations.bucket.terms.Terms;
//import org.elasticsearch.search.builder.SearchSourceBuilder;
//import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
//import org.elasticsearch.search.sort.SortBuilder;
//import org.elasticsearch.search.sort.SortBuilders;
//import org.elasticsearch.search.sort.SortOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.core.AggregationsContainer;
//import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
//import org.springframework.data.elasticsearch.core.SearchHits;
//import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;
//import org.springframework.data.elasticsearch.core.query.FetchSourceFilterBuilder;
//import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
//import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
//import org.springframework.data.elasticsearch.core.query.SourceFilter;
//import org.springframework.data.elasticsearch.repository.query.ReactiveElasticsearchQueryExecution;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import javax.naming.directory.SearchResult;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class RestServiceImpl implements RestService {
//    private final ElasticsearchRestTemplate elasticsearchTemplate;
//    private final RestClient restClient;
//    private final ElasticsearchConverter elasticsearchConverter;
//
//    @Override
//    public ResultVO search() {
//        String fromDate = "2022-07-01 00:00:00";
//        String toDate = "2022-11-01 00:00:00";
//
//        BoolQueryBuilder queryBuilder = new BoolQueryBuilder();
//        queryBuilder.must(QueryBuilders.rangeQuery("createdTime").gte(fromDate).lte(toDate));
//        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
//        Pageable pageable = PageRequest.of(1, 50);
//        NativeSearchQuery nativeSearchQuery = nativeSearchQueryBuilder.withQuery(queryBuilder)
//                // 返回指定字段
//                .withSourceFilter(new FetchSourceFilterBuilder().withIncludes("orderId", "callerSex").build())
//                // 分页
//                .withPageable(pageable)
//                // 排序
//                .withSorts(SortBuilders.fieldSort("callerSex.keyword").order(SortOrder.DESC), SortBuilders.fieldSort("orderId.keyword").order(SortOrder.DESC), SortBuilders.scoreSort().order(SortOrder.DESC))
//                // 聚合
//                .withAggregations(AggregationBuilders.terms("popularBrand").field("callSubject.keyword"))
//                // 高亮
//                .withHighlightFields(new HighlightBuilder().highlighterType("plain").field("callerSex").field("orderId").fields())
//                .withSearchType(SearchType.DEFAULT).build();
//        SearchHits<OrderSynWide> search = elasticsearchTemplate.search(nativeSearchQuery, OrderSynWide.class);
//
//        Map<String, Aggregation> aggregationMap = ((Aggregations)search.getAggregations().aggregations()).asMap();
//        Aggregation brandNames = aggregationMap.get("popularBrand");
//        List<String> brandNameList = new ArrayList<>();
//        for(int i = 0; i<((Terms) brandNames).getBuckets().size(); i++){
//            Terms.Bucket bucket = ((Terms) brandNames).getBuckets().get(i);
//            String keyAsString = bucket.getKeyAsString();
//            long docCount = bucket.getDocCount();
//            System.out.println(String.format("key:%s;value:%d", keyAsString, docCount));
//        }
//        return null;
//    }
//
//    private String printQueryJson(NativeSearchQuery query) {
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(query.getQuery());
//        String queryPrint = searchSourceBuilder.toString();
//        return queryPrint;
//    }
//
//
//    @Override
//    public ResultVO aggregate() {
//        return null;
//    }
//
//    @Override
//    public ResultVO addDoc() {
//        return null;
//    }
//
//    @Override
//    public ResultVO updateDoc() {
//        return null;
//    }
//}

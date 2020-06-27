package com.seaboxdata.rop.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.api.input.InfoResApplicationInput;
import com.seaboxdata.rop.api.input.InfoResApplicationPageInput;
import com.seaboxdata.rop.api.vo.InfoResApplicationVo;
import com.seaboxdata.rop.service.IResourceEsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
public class IResourceEsServiceImpl implements IResourceEsService {

    private static String APP_ES_INDEX = "app_es_index";

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Override
    public boolean createMsg(InfoResApplicationVo infoResApplicationVo) {
        Assert.notNull(infoResApplicationVo.getAppName(), "应用名称不能为空");
        IndexRequest request = new IndexRequest(APP_ES_INDEX);
        request.id(String.valueOf(infoResApplicationVo.getAppId()));
        request.source(JSON.toJSONString(infoResApplicationVo), XContentType.JSON);
        try {
            request.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
            restHighLevelClient.index(request, RequestOptions.DEFAULT);
            log.info("es创建:{}", JSON.toJSONString(infoResApplicationVo));
        } catch (Exception e) {
            log.error("es创建失败,{}", e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean updateMsg(InfoResApplicationVo infoResApplicationVo) {
        Assert.notNull(infoResApplicationVo.getAppName(), "应用名称不能为空");
        UpdateRequest updateRequest = new UpdateRequest(APP_ES_INDEX, String.valueOf(infoResApplicationVo.getAppId()));
        updateRequest.doc(JSON.toJSONString(infoResApplicationVo), XContentType.JSON);

        try {
            updateRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
            restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
            log.info("es修改:{}", JSON.toJSONString(infoResApplicationVo));
        } catch (IOException e) {
            log.error("es修改失败,{}", e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteMsg(Integer id) {
        Assert.notNull(id, "ID不能为空");
        BulkRequest request = new BulkRequest();
        request.add(new DeleteRequest(APP_ES_INDEX, String.valueOf(id)));
        try {
            request.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
            restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
            log.info("es删除,{}", id);
        } catch (IOException e) {
            log.error("es删除失败,{}", e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public PaginationResult<InfoResApplicationVo> getMsg(InfoResApplicationPageInput infoResApplicationPageInput) {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        String keyword = infoResApplicationPageInput.getKeyword();
        //关键字 查询应用信息
        if (StringUtils.isNotBlank(keyword)) {
            String[] s = keyword.split(" ");
            BoolQueryBuilder tempQueryBuilder = QueryBuilders.boolQuery();
            for (String str : s) {
                tempQueryBuilder.should(QueryBuilders.multiMatchQuery(str, "appName", "appBrief", "appProvider"));
//                boolQueryBuilder.should(QueryBuilders.wildcardQuery("appName.keyword", "*" + str + "*"))
//                .should(QueryBuilders.wildcardQuery("appBrief.keyword", "*" + str + "*"))
//                .should(QueryBuilders.wildcardQuery("appProvider.keyword", "*" + str + "*"));
            }
            // 模糊查询
            boolQueryBuilder.must(tempQueryBuilder);
        }
        // 应用类型
        if (infoResApplicationPageInput.getAppType() != null) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("appType", infoResApplicationPageInput.getAppType()));
        }
        return listResourceUtil(boolQueryBuilder, infoResApplicationPageInput.getLimit(), infoResApplicationPageInput.getOffset());
    }


    private PaginationResult listResourceUtil(BoolQueryBuilder boolQueryBuilder, Integer size, Integer from) {
        log.info("查询的语句:" + boolQueryBuilder.toString());
		/*OauthOrganizationVO oauthOrganizationVO = new OauthOrganizationVO();
		oauthOrganizationVO.setOrganizationId(7L);*/
        // 只查询资源
        SearchResponse searchResponse = new SearchResponse();
        // 设置返回的字段
//        String[] fields = new String[17];
//        fields[0] = "id";
//        fields[1] = "isResource";
//        fields[2] = "parentId";
//        fields[3] = "isShowNum";
//        fields[4] = "numInfo";
//        fields[5] = "name";
//        fields[6] = "organizationId";
//        fields[7] = "accessStatus";
//        fields[8] = "shareType";
//        fields[9] = "shareAttr";
//        fields[10] = "renewCycle";
//        fields[11] = "infoSourceSort";
//        fields[12] = "shareSort";
//        fields[13] = "resourcesDesc";
//        fields[14] = "resourcesName";
//        fields[15] = "accessType";
//        fields[16] = "isTop";
//        String[] ex = new String[0];
        try {
            searchResponse = restHighLevelClient.search(new SearchRequest(APP_ES_INDEX)
                            .source(new SearchSourceBuilder()
                                    .size(size)
                                    .from(from)
                                    .query(boolQueryBuilder)
                                    .highlighter(getHighlightBuilder())
                                    .sort(SortBuilders.fieldSort("app_id").unmappedType("long").order(SortOrder.DESC))
//                                    .fetchSource(fields, ex)
                            ),
                    RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("es查询失败,{}" + e.getMessage());
        }
        SearchHits searchHits = searchResponse.getHits();
        Optional<List<InfoResApplicationVo>> collect = Optional.of(Arrays.stream(searchHits.getHits())
                .map(e -> processHighlight(e, InfoResApplicationVo.readValue(e.getSourceAsString())))
                .filter(Optional::isPresent).map(Optional::get).collect(toList()));
        PaginationResult<InfoResApplicationVo> result = new PaginationResult<>((int) searchHits.getTotalHits().value
                , size, from, collect.get());
        return result;
    }

    /**
     * @Author chaobin
     * @Description 搜索关键字加高亮
     * @Date 2019-06-17 14:34
     **/
    private Optional<InfoResApplicationVo> processHighlight(SearchHit e
            , Optional<InfoResApplicationVo> esScheduleOP) {
        if (!esScheduleOP.isPresent()) {
            return Optional.empty();
        }
        InfoResApplicationVo resApplication = esScheduleOP.get();
        Map<String, HighlightField> map = e.getHighlightFields();

        HighlightField descriptionHighlightField = map.get("appName");
        if (null != descriptionHighlightField) {
            Text[] descFragments = descriptionHighlightField.getFragments();
            if (descFragments.length > 0) {
                String name = descFragments[0].toString();
                resApplication.setAppName(name);
            }
        }
        return Optional.of(resApplication);
    }


    /***
     * 高亮
     * @return
     */
    private HighlightBuilder getHighlightBuilder() {
        return new HighlightBuilder()
                .field(new HighlightBuilder.Field("appName"));
    }
}

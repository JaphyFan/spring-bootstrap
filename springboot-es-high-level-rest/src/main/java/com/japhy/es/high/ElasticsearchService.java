package com.japhy.es.high;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.ElasticsearchParseException;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Service;

/**
 * @author Japhy
 * @since 2020/8/19 17:15
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ElasticsearchService {

    private final RestHighLevelClient restHighLevelClient;

    public void insertOrUpdate(User user) throws IOException {
        Gson gson = new Gson();

        String userJson = gson.toJson(user);
        IndexRequest request = new IndexRequest("users");
        request.id("1");
        request.source(userJson);
        //同步方式
        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        log.info(response.toString());
//        异步方式
//        restHighLevelClient.indexAsync(request, RequestOptions.DEFAULT, null);
    }

    public List<User> queryUsers() {
        return Lists.newArrayList();
    }

    public void deleteUser() {
        return;
    }

    public User getUser() throws ElasticsearchParseException, IOException {

        GetRequest getRequest = new GetRequest("users", "1");
        GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        if (getResponse.isExists()) {
            getResponse.getSourceAsMap();
        }
        return null;
    }

}

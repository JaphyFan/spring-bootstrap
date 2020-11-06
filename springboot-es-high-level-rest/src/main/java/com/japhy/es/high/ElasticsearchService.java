package com.japhy.es.high;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    public void insertOrUpdate() {
    }

}

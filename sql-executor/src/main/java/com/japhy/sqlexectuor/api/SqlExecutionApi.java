package com.japhy.sqlexectuor.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2022/4/7 11:21
 */
@RestController
@RequestMapping("/api/sql")
@RequiredArgsConstructor
public class SqlExecutionApi {

    private final EntityManager entityManager;

    private final ObjectMapper objectMapper;

    @PostMapping("/v1/admin/sql/execute")
    // @ApiOperation(value = "直接进行SQL查询接口", notes = "适用于指标少，逻辑全在sql的场景")
    public ResponseEntity<ArrayNode> executeSql(@RequestBody String sql) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        ArrayNode arrayNode = objectMapper.createArrayNode();
        JsonArray jsonElements = new JsonArray();
        List resultList = nativeQuery.getResultList();
        resultList.forEach(o -> {
            Object[] m = (Object[]) o;
            JsonObject jsonObject = new JsonObject();
            for (int i = 0; i < m.length; i++) {
                jsonObject.addProperty(String.valueOf(i), String.valueOf(m[i]));
                ObjectNode jsonNodes = arrayNode.addObject();
                jsonNodes.put(String.valueOf(i), String.valueOf(m[i]));
            }
            jsonElements.add(jsonObject);
        });
        return ResponseEntity.ok(arrayNode);
    }
}

package com.japhy.example.hbase;

import lombok.RequiredArgsConstructor;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Japhy
 * @since 2020/6/2 14:31
 */
@Service
@RequiredArgsConstructor
public class DemoService {

    private final HbaseTemplate hbaseTemplate;

    public void test() {
        hbaseTemplate.execute("Question", tableInterface -> {
            Put put = new Put(Bytes.toBytes("demo1"));
            put.addColumn(Bytes.toBytes("Info"), Bytes.toBytes("ConquerStatus"),
                Bytes.toBytes("fanjh"));
            tableInterface.put(put);
            return null;

        });
    }
}

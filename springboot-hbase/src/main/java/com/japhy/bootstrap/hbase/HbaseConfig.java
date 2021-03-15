package com.japhy.bootstrap.hbase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

/**
 * @author Japhy
 * @since 2020/5/28 22:56
 */
@Configuration
public class HbaseConfig {

    @Value("${hbase.rootDir}")
    private String rootDir;

    @Value("${hbase.zookeeper.quorum}")
    private String zookeeperQuorum;

    @Value("${hbase.zookeeper.property.clientPort}")
    private String clientPort;

    @Value("${zookeeper.znode.parent}")
    private String znodeParent;

    @Bean
    public HbaseTemplate hbaseTemplate() {
        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
        conf.set("hbase.rootdir", rootDir);
        conf.set("hbase.zookeeper.quorum", zookeeperQuorum);
        conf.set("hbase.zookeeper.property.clientPort", clientPort);
        conf.set("zookeeper.znode.parent", znodeParent);
        conf.set("hbase.client.retries.number", "3");
        conf.set("hbase.rpc.timeout", "2000");
        conf.set("hbase.client.operation.timeout", "3000");
        return new HbaseTemplate(conf);
    }
}


package com.japhy.example.solr.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.data.solr.server.support.HttpSolrClientFactory;
import org.springframework.data.solr.server.support.HttpSolrClientFactoryBean;

/**
 * @author Japhy
 * @since 2020/5/20 16:26
 */
@Configuration
@Profile("dev")
@EnableSolrRepositories
public class HttpSolrConfig {

    @Value("${spring.data.solr.host}")
    private String solrHost;

    @Bean
    public SolrClient solrClient() {
       return new HttpSolrClient.Builder().withBaseSolrUrl(solrHost).build();
    }

}

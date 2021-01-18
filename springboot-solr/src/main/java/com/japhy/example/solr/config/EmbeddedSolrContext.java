package com.japhy.example.solr.config;

import org.apache.solr.client.solrj.SolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.data.solr.server.support.EmbeddedSolrServerFactory;
import org.springframework.data.solr.server.support.EmbeddedSolrServerFactoryBean;

/**
 * @author Japhy
 * @since 2020/5/20 14:49
 */
@Configuration
@EnableSolrRepositories
@Profile("local")
class EmbeddedSolrContext {

    @Bean
    public SolrClient solrClient() {
//            EmbeddedSolrServerFactory factoryBean =
//            new EmbeddedSolrServerFactoryBean("classpath:com/japhy/example/solr");
        return null;
    }

    @Bean
    public SolrTemplate solrTemplate() {
//        return new SolrTemplate();
        return null;
    }
}

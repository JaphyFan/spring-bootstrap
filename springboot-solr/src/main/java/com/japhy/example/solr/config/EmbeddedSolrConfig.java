package com.japhy.example.solr.config;

import java.io.IOException;
import java.nio.file.Paths;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.core.CoreContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.data.solr.server.support.EmbeddedSolrServerFactory;
import org.xml.sax.SAXException;

/**
 * @author Japhy
 * @since 2021/5/18 15:51
 */
@Profile("local")
@Configuration
@EnableSolrRepositories(basePackages = "com.japhy.example.solr.repository")
public class EmbeddedSolrConfig {

    @Bean
    public SolrClient solrClient() throws IOException, SAXException, ParserConfigurationException {
        EmbeddedSolrServerFactory factory = new EmbeddedSolrServerFactory("classpath:solr-home");
        return factory.getSolrClient();
    }

    @Bean
    public SolrOperations solrTemplate()
            throws ParserConfigurationException, SAXException, IOException {
        return new SolrTemplate(solrClient());
    }
}

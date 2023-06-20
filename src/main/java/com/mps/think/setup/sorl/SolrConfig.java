package com.mps.think.setup.sorl;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages = "com.mps.think.setup.sorl", namedQueriesLocation = "classpath:solr-named-queries.properties")
@ComponentScan
public class SolrConfig {

    @Bean
    public SolrClient solrClient() {
        return new HttpSolrClient.Builder("http://104.232.26.45:8983/solr").build();
//        return new HttpSolrClient.Builder("http://127.0.0.1:8984/solr").build();
    }

    @Bean
    public SolrTemplate solrTemplate(SolrClient client) throws Exception {
        return new SolrTemplate(client);
    }
}
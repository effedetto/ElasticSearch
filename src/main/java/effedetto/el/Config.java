package effedetto.el;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

//@EnableElasticsearchRepositories(basePackages = "com.baeldung.spring.data.es.repository")
@Configuration
@ComponentScan
public class Config extends AbstractElasticsearchConfiguration {

    @Bean
	public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
            .connectedTo("https://search-prod-es-domain-5-o4ee3y3ccpdmihgvej2peb3e2m.eu-west-1.es.amazonaws.com")
            .build();

        return RestClients.create(clientConfiguration)
            .rest();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(elasticsearchClient());
    }

 
 
}
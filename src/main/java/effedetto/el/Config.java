package effedetto.el;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

//@EnableElasticsearchRepositories(basePackages = "com.baeldung.spring.data.es.repository")
//@ComponentScan
@EnableElasticsearchRepositories
@Configuration
 public class Config   {

	@Value("${elasticsearch.host}")
	private String elasticsearchHost;

	//    @Bean
	//	public RestHighLevelClient elasticsearchClient() {
	//        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
	//            .connectedTo("https://search-prod-es-domain-5-o4ee3y3ccpdmihgvej2peb3e2m.eu-west-1.es.amazonaws.com")
	//            .build();
	//
	//        return RestClients.create(clientConfiguration)
	//            .rest();
	//    }

	//    @Bean
	//    public ElasticsearchOperations elasticsearchTemplate() {
	//        return new ElasticsearchRestTemplate(elasticsearchClient());
	//    }

	@Bean(destroyMethod = "close")
	public RestHighLevelClient client() {

		RestHighLevelClient client = new RestHighLevelClient(
				RestClient.builder(new HttpHost(elasticsearchHost)));

		return client;

	}



}
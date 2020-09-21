package effedetto.el;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;

@Configuration
public class AWSStaticCredentialsConfiguration {

    @Value("${aws.es.accessKey}")
    private String esAccessKey = null;

    @Value("${aws.es.secretKey}")
    private String esSecretKey = null;
    
    @Autowired
    private RestHighLevelClient rest;

    @Bean
    public AWSStaticCredentialsProvider awsDynamoCredentialsProviderDevelopment() {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(
                esAccessKey, esSecretKey));
    }
    
    @Bean(
    	    name = {"elasticsearchOperations", "elasticsearchTemplate"}
    	)
    	public ElasticsearchOperations elasticsearchOperations() {
    	    return new ElasticsearchRestTemplate(rest, this.elasticsearchConverter(), this.resultsMapper());
    	}
}
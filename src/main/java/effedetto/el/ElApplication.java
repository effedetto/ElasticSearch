package effedetto.el;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class ElApplication implements CommandLineRunner {

	@Autowired
	private 	RestHighLevelClient client;
	
//	 RestClient lowLevelClient = client.getLowLevelClient(); 


	public static void main(String[] args) throws Exception {
		SpringApplication.run(ElApplication.class, args);
		 
	}

	@Override
	public void run(String... args) throws Exception {


		log.info("--Started--");
		
		Service service = new Service();
		service.find("5e394c2a-8049-4cd1-abfb-6d52af2ec841");
		
		SearchRequest searchRequest = new SearchRequest();
		
		SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
		SearchHit[] searchHits = response.getHits().getHits();
//		List<Object> results = 
//				Arrays.stream(searchHits)
//				.map(hit -> JSON.parseObject(hit.getSourceAsString(), Person.class))
//				.collect(Collectors.toList());

	}

 
 

}

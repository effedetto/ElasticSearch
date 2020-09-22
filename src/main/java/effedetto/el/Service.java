package effedetto.el;

import java.util.Map;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	private RestHighLevelClient client;
	
	public void find(String id) throws Exception {

        GetRequest getRequest = new GetRequest("cwl-*", "_doc", id);

    
		GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        Map<String, Object> resultMap = getResponse.getSource();

//        return objectMapper
//                .convertValue(resultMap, ProfileDocument.class);


    }

}

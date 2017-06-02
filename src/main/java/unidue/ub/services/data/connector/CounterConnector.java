package unidue.ub.services.data.connector;

import java.io.IOException;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import com.fasterxml.jackson.databind.ObjectMapper;

import unidue.ub.media.analysis.Counter;

public class CounterConnector {
	
	public static int register(Counter counter) throws HttpException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(counter);
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("https://localhost:11200/counter");
		RequestEntity entity = new StringRequestEntity(json,"application/json",null);
		post.setRequestEntity(entity);
		int response = client.executeMethod(post);
		return response;
	}
	
	public static int register(List<Counter> counters) throws HttpException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(counters);
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("https://localhost:11200/counter");
		RequestEntity entity = new StringRequestEntity(json,"application/json",null);
		post.setRequestEntity(entity);
		int response = client.executeMethod(post);
		return response;
	}
	
	public static int replace(Counter counter, String id) throws HttpException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(counter);
		HttpClient client = new HttpClient();
		PutMethod put = new PutMethod("https://localhost:11200/counter" + id);
		RequestEntity entity = new StringRequestEntity(json,"application/json",null);
		put.setRequestEntity(entity);
		int response = client.executeMethod(put);
		return response;
	}

}

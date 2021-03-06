package com.cfn.elastic.index;


import com.cfn.elastic.ElasticClient;
import com.cfn.elastic.request.index.CreateIndex;
import org.apache.http.HttpHost;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author caofengnian
 * @Date 2020-04-09
 */
public class CreatIndexTest {
	
	public static void main(String[] args) {
		RestHighLevelClient client = ElasticClient.getClient(new HttpHost("192.168.6.150", 9200));
		CreateIndexRequest request = CreateIndex.creatIndex("test");
		Map<String, Object> mapping = new HashMap<>();
		mapping.put("type", "text");
		Map<String, Object> properties = new HashMap<>();
		properties.put("message", mapping);
		properties.put("cc", mapping);
		request.mapping(CreateIndex.createMapping(properties));
		ActionListener<CreateIndexResponse> listener =
				new ActionListener<CreateIndexResponse>() {
					@Override
					public void onResponse(CreateIndexResponse createIndexResponse) {
					}
					@Override
					public void onFailure(Exception e) {
					}
				};
		client.indices().createAsync(request, RequestOptions.DEFAULT, listener);
	}
}
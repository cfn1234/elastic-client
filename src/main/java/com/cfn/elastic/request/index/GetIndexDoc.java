package com.cfn.elastic.request.index;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;

import java.io.IOException;

/**
 * com.cfn.elastic.request.index
 * 根据ID获取文档
 *
 * @author caofengnian
 * @date 2020-04-12
 */
@Slf4j
public class GetIndexDoc {
	
	private GetIndexDoc() {
	}
	
	/**
	 * 根据id获得信息
	 * todo fetch未封装
	 *
	 * @param indexName 索引名
	 * @param id        id
	 * @return
	 */
	public static GetRequest getIndex(String indexName, String id) {
		GetRequest request = new GetRequest(indexName, id);
		request.fetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE);
		return request;
	}
	
	/**
	 * @param client  连接
	 * @param request get请求
	 * @return
	 */
	public static Boolean existsIndex(RestHighLevelClient client, GetRequest request) {
		try {
			return client.exists(request, RequestOptions.DEFAULT);
		} catch (IOException e) {
			log.error("existsIndex#e:{}", e);
		}
		return false;
	}
	
	private static void existsIndex(RestHighLevelClient client, GetRequest request, ActionListener<Boolean> listener) {
		client.existsAsync(request, RequestOptions.DEFAULT, listener);
	}
}

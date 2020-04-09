package com.cfn.elastic.index.document;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;

import java.util.Map;

/**
 * com.cfn.elastic.index.document
 * 创建文档
 *
 * @author caofengnian
 * @Date 2020-04-09
 */
public class CreateIndexDoc {
	
	
	/**
	 * 新增文档
	 *
	 * @param indexName  索引名称
	 * @param id
	 * @param jsonString json格式文档
	 * @return
	 */
	public static IndexRequest installIndex(String indexName, String id, String jsonString) {
		IndexRequest request = new IndexRequest(indexName);
		request.id(id);
		request.source(jsonString, XContentType.JSON);
		return request;
	}
	
	/**
	 * 新增文档
	 *
	 * @param indexName 索引名称
	 * @param id
	 * @param map       json格式文档
	 * @return
	 */
	public static IndexRequest installIndex(String indexName, String id, Map<String, Object> map) {
		IndexRequest indexRequest = new IndexRequest(indexName)
				.id("id").source(map);
		return indexRequest;
	}
	
	/**
	 * 新增文档
	 *
	 * @param indexName 索引名称
	 * @param id
	 * @param builder   json格式文档
	 * @return
	 */
	public static IndexRequest installIndex(String indexName, String id, XContentBuilder builder) {
		IndexRequest indexRequest = new IndexRequest(indexName)
				.id(id).source(builder);
		return indexRequest;
	}
	
}

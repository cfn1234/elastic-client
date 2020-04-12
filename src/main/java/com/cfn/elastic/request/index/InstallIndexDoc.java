package com.cfn.elastic.request.index;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.common.xcontent.XContentBuilder;

import java.util.Map;

/**
 * com.cfn.elastic.index
 * 新增文档
 *
 * @author caofengnian
 * @date 2020-04-09
 */
public class InstallIndexDoc {
	
	/**
	 * 私有构造函数
	 */
	private InstallIndexDoc() {
	}
	
	private static IndexRequest install(String indexName, String id, Object object) {
		return new IndexRequest(indexName).id(id).source(object);
	}
	
	/**
	 * 新增文档
	 *
	 * @param indexName 索引名称
	 * @param id        id
	 * @param json      json格式文档
	 * @return IndexRequest
	 */
	public static IndexRequest installIndex(String indexName, String id, String json) {
		return install(indexName, id, json);
	}
	
	/**
	 * 新增文档
	 *
	 * @param indexName 索引名称
	 * @param id
	 * @param map       json格式文档
	 * @return IndexRequest
	 */
	public static IndexRequest installIndex(String indexName, String id, Map<String, Object> map) {
		return install(indexName, id, map);
	}
	
	/**
	 * 新增文档
	 *
	 * @param indexName 索引名称
	 * @param id
	 * @param builder   json格式文档
	 * @return IndexRequest
	 */
	public static IndexRequest installIndex(String indexName, String id, XContentBuilder builder) {
		return install(indexName, id, builder);
	}
	
}

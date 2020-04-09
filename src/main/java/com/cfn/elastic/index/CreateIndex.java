package com.cfn.elastic.index;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.settings.Settings;

import java.util.HashMap;
import java.util.Map;

/**
 * com.cfn.elastic.index
 * 创建index
 *
 * @author caofengnian
 * @Date 2020-04-09
 */
@Slf4j
public class CreateIndex {
	
	private static Integer shards = 3;
	
	private static Integer replicas = 1;
	
	/**
	 * 创建索引
	 *
	 * @param indexName 索引名称
	 * @return
	 */
	public static CreateIndexRequest creatIndex(String indexName) {
		return creatIndex(indexName, shards, replicas);
	}
	
	/**
	 * 创建索引
	 *
	 * @param indexName 索引名称
	 * @param shards    索引分片
	 * @param replicas  索引副本
	 * @return
	 */
	public static CreateIndexRequest creatIndex(String indexName, Integer shards, Integer replicas) {
		CreateIndexRequest request = new CreateIndexRequest(indexName);
		request.settings(Settings.builder()
				.put("index.number_of_shards", shards)
				.put("index.number_of_replicas", replicas)
		);
		return request;
	}
	
	/**
	 * 创建索引mapping
	 *
	 * @param properties
	 * @return
	 */
	public static Map<String, Object> createMapping(Map<String, Object> properties) {
		Map<String, Object> mapping = new HashMap<>();
		mapping.put("properties", properties);
		return mapping;
	}
}

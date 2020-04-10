package com.cfn.elastic;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * 连接els
 *
 * @author caofengnian
 * @Date 2020-04-09
 */
@Slf4j
public class ElasticClient {
	
	/**
	 * 连接属性
	 */
	private static RestHighLevelClient client;
	
	/**
	 * 私有构造函数
	 */
	private ElasticClient() {
	}
	
	/**
	 * 连接es
	 *
	 * @param host
	 * @return
	 */
	
	public static synchronized RestHighLevelClient getClient(HttpHost... host) {
		if (null == client) {
			client = new RestHighLevelClient(RestClient.builder(host));
		}
		return client;
	}
	
	/**
	 * 关闭es连接
	 */
	public static void closeClient() {
		try {
			if (null == client) {
				log.warn("is not client");
				return;
			}
			client.close();
		} catch (IOException e) {
			log.error("closeClient#e:{}", e);
		}
	}
}

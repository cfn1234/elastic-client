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
	 * 自己创建一个类的实例化
	 */
	private final static ElasticClient elasticClient = new ElasticClient();
	/**
	 * 连接属性
	 */
	private RestHighLevelClient client;
	
	/**
	 * 私有构造函数
	 */
	private ElasticClient() {
	}
	
	//创建一个get方法，返回一个实例
	public static ElasticClient getInstance() {
		return elasticClient;
	}
	
	
	/**
	 * 连接es
	 *
	 * @param host
	 * @return
	 */
	
	public synchronized RestHighLevelClient getClient(HttpHost... host) {
		if (null == client) {
			client = new RestHighLevelClient(RestClient.builder(host));
		}
		return client;
	}
	
	/**
	 * 关闭es连接
	 */
	public void closeClient() {
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

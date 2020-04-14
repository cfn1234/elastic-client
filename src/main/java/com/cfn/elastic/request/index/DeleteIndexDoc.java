package com.cfn.elastic.request.index;

import org.elasticsearch.action.delete.DeleteRequest;

/**
 * com.cfn.elastic.request.index
 * 删除索引文档
 *
 * @author caofengnian
 * @date 2020-04-13
 */
public class DeleteIndexDoc {
	
	private DeleteIndexDoc() {
	}
	
	/**
	 * 删除索引文档
	 *
	 * @param indexName 索引名称
	 * @param id        id
	 * @return
	 */
	public static DeleteRequest deleteIndex(String indexName, String id) {
		return new DeleteRequest(indexName, id);
	}
	
	/**
	 * 删除索引文档根据routing
	 *
	 * @param indexName 索引名称
	 * @param id        id
	 * @param routing   路由名称
	 * @return
	 */
	public static DeleteRequest deleteIndex(String indexName, String id, String routing) {
		return deleteIndex(indexName, id).routing(routing);
	}
	
}

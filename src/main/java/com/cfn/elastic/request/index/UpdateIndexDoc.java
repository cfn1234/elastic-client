package com.cfn.elastic.request.index;

import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.script.Script;

import java.util.Map;

/**
 * com.cfn.elastic.request.index
 * 更新索引文档
 *
 * @author caofengnian
 * @date 2020-04-14
 */
public class UpdateIndexDoc {
	
	private UpdateIndexDoc() {
	
	}
	
	/**
	 * 更新文档
	 *
	 * @param indexName
	 * @param id
	 * @return
	 */
	private static UpdateRequest updateIndex(String indexName, String id) {
		return new UpdateRequest(indexName, id);
	}
	
	/**
	 * @param indexName
	 * @param id
	 * @param script
	 * @return {@link #updateIndex(String, String)}
	 */
	public static UpdateRequest updateIndex(String indexName, String id, Script script) {
		return updateIndex(indexName, id).script(script);
	}
	
	/**
	 * @param indexName
	 * @param id
	 * @param json
	 * @return {@link #updateIndex(String, String)}
	 */
	public static UpdateRequest updateIndex(String indexName, String id, String json) {
		return updateIndex(indexName, id).doc(json, XContentType.JSON);
	}
	
	/**
	 * @param indexName
	 * @param id
	 * @param map
	 * @return {@link #updateIndex(String, String)}
	 */
	public static UpdateRequest updateIndex(String indexName, String id, Map<String, Object> map) {
		return updateIndex(indexName, id).doc(map);
	}
	
	/**
	 * @param indexName
	 * @param id
	 * @param builder
	 * @return {@link #updateIndex(String, String)}
	 */
	public static UpdateRequest updateIndex(String indexName, String id, XContentBuilder builder) {
		return updateIndex(indexName, id).doc(builder);
	}
	
	
	/**
	 * If the document does not already exist, it is possible to define some content that will
	 * be inserted as a new document using the upsert method
	 *
	 * @param indexName
	 * @param id
	 * @param json
	 * @return {@link #updateIndex(String, String)}
	 */
	public static UpdateRequest upsertIndex(String indexName, String id, String json) {
		return updateIndex(indexName, id).upsert(json);
	}
	
	/**
	 * @param indexName
	 * @param id
	 * @param map
	 * @return {@link #upsertIndex(String, String, String)}
	 */
	public static UpdateRequest upsertIndex(String indexName, String id, Map<String, Object> map) {
		return updateIndex(indexName, id).upsert(map);
	}
	
	/**
	 * @param indexName
	 * @param id
	 * @param builder
	 * @return {@link #upsertIndex(String, String, String)}
	 */
	public static UpdateRequest upsertIndex(String indexName, String id, XContentBuilder builder) {
		return updateIndex(indexName, id).upsert(builder);
	}
	
}

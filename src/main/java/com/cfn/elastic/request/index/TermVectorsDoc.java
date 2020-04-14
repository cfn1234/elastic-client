package com.cfn.elastic.request.index;

import org.elasticsearch.client.core.TermVectorsRequest;

/**
 * com.cfn.elastic.request.index
 *
 * @author caofengnian
 * @date 2020-04-14
 */
public class TermVectorsDoc {
	
	private TermVectorsDoc() {
	
	}
	
	public static TermVectorsRequest termVectors(String indexName, String id) {
		TermVectorsRequest request = new TermVectorsRequest(indexName, id);
		request.setFields("user");
		return request;
	}
}

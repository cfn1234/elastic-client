package com.cfn.elastic.request.index;

import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.bulk.BulkRequest;

import java.util.List;

/**
 * com.cfn.elastic.request.index
 * 批量操作
 *
 * @author caofengnian
 * @date 2020-04-14
 */
public class BulkIndexDoc {
	
	private BulkIndexDoc() {
	}
	
	public static BulkRequest bulkIndex(List<DocWriteRequest> list) {
		BulkRequest request = new BulkRequest();
		list.stream().forEach(x -> {
			request.add(x);
		});
		return request;
	}
}

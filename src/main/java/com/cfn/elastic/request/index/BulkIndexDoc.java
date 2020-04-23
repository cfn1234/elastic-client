package com.cfn.elastic.request.index;

import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.client.RequestOptions;

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
	
	/**
	 * 批量操作代码
	 *
	 * @param list request集合
	 * @return
	 */
	public static BulkRequest bulkIndex(List<DocWriteRequest> list) {
		BulkRequest request = new BulkRequest();
		list.stream().forEach(x -> {
			request.add(x);
		});
		request.pipeline("pipelineId");
		return request;
	}
}

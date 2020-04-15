package com.cfn.elastic.request.index;


import org.elasticsearch.action.DocWriteRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * com.cfn.elastic.request.index
 *
 * @author caofengnian
 * @date 2020-04-15
 */
public class BulkIndexDocTest {
	
	public static void main(String[] args) {
		List<DocWriteRequest> list = new ArrayList<>();
		list.add(InstallIndexDoc.installIndex("11", "11", ""));
		list.add(UpdateIndexDoc.updateIndex("11", "11", ""));
		BulkIndexDoc.bulkIndex(list);
	}
}
package com.cfn.elastic.request.index;

import com.cfn.elastic.dto.IndexDto;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.get.MultiGetRequest;

import java.util.List;

/**
 * com.cfn.elastic.request.index
 *
 * @author caofengnian
 * @date 2020-04-16
 */
@Slf4j
public class MultiGetIndexDoc {
	
	private MultiGetIndexDoc() {
	}
	1
	public MultiGetRequest multiGetIndex(List<IndexDto> list) {
		MultiGetRequest request = new MultiGetRequest();
		list.stream().forEach(x -> {
			request.add(new MultiGetRequest.Item(
					x.getIndexName(),
					x.getId()));
		});
		
		return request;
	}
}

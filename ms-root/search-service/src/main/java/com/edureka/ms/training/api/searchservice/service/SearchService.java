package com.edureka.ms.training.api.searchservice.service;

import java.util.List;
import java.util.stream.Stream;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.MoreLikeThisQueryBuilder.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import com.edureka.ms.training.api.searchservice.repository.SearchRepository;
import com.edureka.ms.training.api.searchservice.model.Players;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SearchService {

	SearchRepository searchRepository;
	ElasticsearchTemplate elasticsearchTemplate;

	public Stream<Players> serachByName(String name) {
		NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withFilter(QueryBuilders.matchQuery("name", name)).build();
		return elasticsearchTemplate.queryForList(searchQuery, Players.class).stream();
	}

	public Stream<Players> serach(String word) {
		String[] fieldNames= {"name","place","aka"};
		NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withFilter(QueryBuilders.multiMatchQuery(word, fieldNames))
				.build();
		return elasticsearchTemplate.queryForList(searchQuery, Players.class).stream();
	}
	
	@SuppressWarnings("unchecked")
	public Page<Players> serachAll() {
		return (Page<Players>) searchRepository.findAll();
	}

}

package com.edureka.ms.training.api.searchservice.repository;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.edureka.ms.training.api.searchservice.model.Players;

public interface SearchRepository extends ElasticsearchRepository<Players, Long> {

}

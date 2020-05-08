package com.edureka.ms.training.api.searchservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "person", type="person", shards=1, replicas = 0, refreshInterval = "-1")
public class Players {
	@Id
	private Long id;
	private String name;
	private String place;
	private String aka;

}

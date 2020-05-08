package com.edureka.ms.training.api.searchservice.controller;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edureka.ms.training.api.searchservice.model.Players;
import com.edureka.ms.training.api.searchservice.service.SearchService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/search")
public class SearchController {
	SearchService searchService;
	
	@GetMapping("/name/{name}")
	public Stream<Players> searchByName(@PathVariable String name)
	{
		return searchService.serachByName(name);
	}
	
	@GetMapping("/{word}")
	public Stream<Players> searchEverything(@PathVariable String word)
	{
		return searchService.serach(word);
	}
	
	@GetMapping("/")
	public Page<Players> searchAll()
	{
		return searchService.serachAll();
	}
	
}

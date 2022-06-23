package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.Serializable;
import java.util.List;

public class IceCreamPagedList extends PageImpl<IceCreamDto> implements Serializable {
	
	private static final long serialVersionUID = -6231947339718175934L;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	    public IceCreamPagedList(@JsonProperty("content") List<IceCreamDto> content,
	                         @JsonProperty("number") int number,
	                         @JsonProperty("size") int size,
	                         @JsonProperty("totalElements") Long totalElements,
	                         @JsonProperty("pageable") JsonNode pageable,
	                         @JsonProperty("last") boolean last,
	                         @JsonProperty("totalPages") int totalPages,
	                         @JsonProperty("sort") JsonNode sort,
	                         @JsonProperty("first") boolean first,
	                         @JsonProperty("numberOfElements") int numberOfElements) {

	        super(content, PageRequest.of(number, size), totalElements);
	    }
	
	  public IceCreamPagedList(List<IceCreamDto> content, Pageable pageable, long total) {
	        super(content, pageable, total);
	    }

	    public IceCreamPagedList(List<IceCreamDto> content) {
	        super(content);
	    }

}
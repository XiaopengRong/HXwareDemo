package com.example.demo.dto;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class IceCreamOrderPagedList extends PageImpl<IceCreamOrderDto>{
	public IceCreamOrderPagedList(List<IceCreamOrderDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public IceCreamOrderPagedList(List<IceCreamOrderDto> content) {
        super(content);
    }

}

package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;


@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
public class IceCreamOrderLine extends BaseEntity{
	
	   @Builder
	    public IceCreamOrderLine(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate,
	    		IceCreamOrder iceCreamOrder, UUID iceCreamId, String upc, Integer orderQuantity,
	                         Integer quantityAllocated) {
	        super(id, version, createdDate, lastModifiedDate);
	        this.iceCreamOrder = iceCreamOrder;
	        this.iceCreamId = iceCreamId;
	        this.upc = upc;
	        this.orderQuantity = orderQuantity;
	        this.quantityAllocated = quantityAllocated;
	    }
		@ManyToOne
	    private IceCreamOrder iceCreamOrder;

	    private UUID iceCreamId;
	    private String upc;
	    private Integer orderQuantity = 0;
	    private Integer quantityAllocated = 0;
	

}

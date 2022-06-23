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
import java.util.Set;
import java.util.UUID;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Customer extends BaseEntity{
	
	
	 @Builder
	    public Customer(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, String customerName,
	                    UUID apiKey, Set<IceCreamOrder> iceCreamOrders) {
	        super(id, version, createdDate, lastModifiedDate);
	        this.customerName = customerName;
	        this.apiKey = apiKey;
	        this.iceCreamOrders = iceCreamOrders;
	    }
	
	
	   private String customerName;

	   @Type(type="org.hibernate.type.UUIDCharType")
	   @Column(length = 36, columnDefinition = "varchar(36)")
	   private UUID apiKey;

	   @OneToMany(mappedBy = "customer")
       private Set<IceCreamOrder> iceCreamOrders;

}

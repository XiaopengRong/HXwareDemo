package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
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
public class IceCreamOrder extends BaseEntity{
	
    @Builder
    public IceCreamOrder(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, String customerRef, Customer customer,
                     Set<IceCreamOrderLine> iceCreamOrderLines, IceCreamOrderStatusEnum orderStatus,
                     String orderStatusCallbackUrl) {
        super(id, version, createdDate, lastModifiedDate);
        this.customerRef = customerRef;
        this.customer = customer;
        this.iceCreamOrderLines = iceCreamOrderLines;
        this.orderStatus = orderStatus;
        this.orderStatusCallbackUrl = orderStatusCallbackUrl;
    }	
  
    private String customerRef;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "IceCreamOrder", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private Set<IceCreamOrderLine> iceCreamOrderLines;

    private IceCreamOrderStatusEnum orderStatus = IceCreamOrderStatusEnum.NEW;
    private String orderStatusCallbackUrl;

}

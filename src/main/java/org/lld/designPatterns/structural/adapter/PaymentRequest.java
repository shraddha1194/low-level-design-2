package org.lld.designPatterns.structural.adapter;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PaymentRequest {
    private Long id;
    private String name;
    private String email;
    private Double amount;
}

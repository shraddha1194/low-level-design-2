package org.lld.designPatterns.structural.adapter.external;

// SDK
// Step 0 - Incompatible interfaces
public class PayUPayApi {

    public void makePayment(Long id, Double amount) {
        System.out.println("PayU pay payment.");
    }

    public PayUStatus getStatus(Long id) {
        return PayUStatus.SUCCESS;
    }
}

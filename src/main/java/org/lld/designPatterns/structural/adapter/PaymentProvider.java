package org.lld.designPatterns.structural.adapter;

// Step 1 - Adapter interface

public interface PaymentProvider {
    // to avoid too many parameters create DTO/request object
    void createPayment(PaymentRequest request);
    PaymentStatus verifyStatus(Long id);
}

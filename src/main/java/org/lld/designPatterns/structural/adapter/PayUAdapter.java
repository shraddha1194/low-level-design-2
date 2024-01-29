package org.lld.designPatterns.structural.adapter;

import org.lld.designPatterns.structural.adapter.external.PayUPayApi;
import org.lld.designPatterns.structural.adapter.external.PayUStatus;

// Step 2 - Concrete adapter implementation

public class PayUAdapter implements PaymentProvider {
    private PayUPayApi payUPayApi = new PayUPayApi();
    @Override
    public void createPayment(PaymentRequest request) {
        payUPayApi.makePayment(request.getId(), request.getAmount());
    }

    @Override
    public PaymentStatus verifyStatus(Long id) {
        PayUStatus status = payUPayApi.getStatus(id);
        return to(status);
    }

    private PaymentStatus to(PayUStatus status) {
        switch (status) {
            case SUCCESS: return PaymentStatus.DONE;
            case FAILURE: return PaymentStatus.FAILED;
        }
        throw new IllegalArgumentException("Invalid status: " + status);
    }
}

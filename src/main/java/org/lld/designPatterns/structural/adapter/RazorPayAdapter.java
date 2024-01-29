package org.lld.designPatterns.structural.adapter;

import org.lld.designPatterns.structural.adapter.external.RazorPayApi;
import org.lld.designPatterns.structural.adapter.external.RazorPayStatus;

// Step 2 - Concrete adapter implementation

public class RazorPayAdapter implements PaymentProvider {
    private RazorPayApi razorPayApi = new RazorPayApi();
    @Override
    public void createPayment(PaymentRequest request) {
        razorPayApi.prePay(request.getId(), request.getName(), request.getEmail(), request.getAmount());
        razorPayApi.pay(request.getId(), request.getName(), request.getEmail(), request.getAmount());
    }

    @Override
    public PaymentStatus verifyStatus(Long id) {
        RazorPayStatus status = razorPayApi.checkStatus(id);
        return to(status);
    }

    private PaymentStatus to(RazorPayStatus status) {
        switch (status) {
            case OK: return PaymentStatus.DONE;
            case ERROR: return PaymentStatus.FAILED;
        }
        throw new IllegalArgumentException("Invalid status + " + status);
    }
}

package org.lld.adapter;

import org.junit.Test;
import org.lld.designPatterns.structural.adapter.*;

import static org.junit.Assert.assertEquals;

public class PaymentProviderTest {
    PaymentProvider adapter = new RazorPayAdapter();
    @Test
    public void testPayMethod() {
        PaymentRequest request = PaymentRequest.builder()
                .id(12L)
                .name("Test User")
                .email("testuser123@gmail.com")
                .amount(100.00).build();
        adapter.createPayment(request);
    }

    @Test
    public void testStatus() {
        PaymentStatus status = adapter.verifyStatus(123L);
        assertEquals("Payment status should be successful", PaymentStatus.DONE, status);
    }
}

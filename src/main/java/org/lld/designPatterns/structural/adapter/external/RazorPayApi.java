package org.lld.designPatterns.structural.adapter.external;

// SDK
// Step 0 - Incompatible interfaces
public class RazorPayApi {

    public void prePay(Long id, String name, String email, Double amount) {
        System.out.println("RazorPay prePay.");
    }

    public void pay(Long id, String name, String email, Double amount) {
        System.out.println("Razor pay payment.");
    }

    public RazorPayStatus checkStatus(Long id) {
        return RazorPayStatus.OK;
    }
}

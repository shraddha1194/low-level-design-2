package org.lld.designPatterns.structural.facade;

// This version does not use facade
public class OrderManagerImplV1 implements OrderManager {
    // All the services in reality should be interfaces
    private InventoryService inventoryService = new InventoryService();
    private PaymentService paymentService = new PaymentService();
    private InvoiceService invoiceService = new InvoiceService();
    @Override
    public void checkout(Long orderId) {
        // check for Inventory
        if (!inventoryService.isPresent(orderId)) {
            throw new RuntimeException("Stock not present");
        }
        // payment gateway
        paymentService.processPayment(orderId);
        // create a bill
        invoiceService.generateInvoice(orderId);
        // send email
    }
}

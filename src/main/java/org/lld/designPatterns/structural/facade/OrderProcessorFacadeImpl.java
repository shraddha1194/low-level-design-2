package org.lld.designPatterns.structural.facade;

public class OrderProcessorFacadeImpl implements OrderProcessorFacade {
    private InventoryService inventoryService = new InventoryService();
    private PaymentService paymentService = new PaymentService();
    private InvoiceService invoiceService = new InvoiceService();
    @Override
    public void process(Long orderId) {
        if (!inventoryService.isPresent(orderId)) {
            throw new RuntimeException("Stock not present");
        }
        paymentService.processPayment(orderId);
        invoiceService.generateInvoice(orderId);
    }
}

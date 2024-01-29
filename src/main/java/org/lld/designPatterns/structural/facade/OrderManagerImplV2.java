package org.lld.designPatterns.structural.facade;

public class OrderManagerImplV2 {
    private OrderProcessorFacade orderProcessor = new OrderProcessorFacadeImpl();

    public void checkout(Long orderId, String source) {
        // we can have additional logic which is not related to processing of order
        if (source.equals("flipkart")) {
            //Give discount
        }
        // frontend validations
        // transformations
        orderProcessor.process(orderId);
    }
}

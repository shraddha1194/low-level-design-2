package org.lld.designPatterns.behavioral.observer;

public class BitcoinTracker extends Observable implements BitcoinManager {

    Bitcoin bitcoin = new Bitcoin();


    @Override
    public Bitcoin getBitcoin() {
        return this.bitcoin;
    }

    @Override
    public void setPrice(Double price) {
        bitcoin.setPrice(price);
        notifyChange();
    }
}

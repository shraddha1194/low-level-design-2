package org.lld.behavioral.observer;

import org.junit.Before;
import org.junit.Test;
import org.lld.designPatterns.behavioral.observer.Bitcoin;
import org.lld.designPatterns.behavioral.observer.BitcoinTracker;
import org.lld.designPatterns.behavioral.observer.EmailNotifier;
import org.lld.designPatterns.behavioral.observer.TweetService;

import static org.junit.Assert.assertEquals;

public class BitcoinTrackerTest {
    private BitcoinTracker tracker;

    @Before
    public void setUp() {
        tracker = new BitcoinTracker();

        EmailNotifier emailNotifier = new EmailNotifier();
        tracker.register(emailNotifier);
        tracker.register(new TweetService());
    }

    @Test
    public void testPrice() {
        tracker.setPrice(100.0);
        Bitcoin bitcoin = tracker.getBitcoin();
        assertEquals(100.00, bitcoin.getPrice(), 00.0);
    }
}

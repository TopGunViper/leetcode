package edu.ouc.concurrency;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class BooleanLatch {

    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
    }

    public void signal() {

    }

    private final Sync sync = new Sync();

    private static class Sync extends AbstractQueuedSynchronizer {

    }
}

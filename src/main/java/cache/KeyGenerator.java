package cache;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Dominik_Janiga
 */
class KeyGenerator {

    private final AtomicInteger key = new AtomicInteger(0);

    int generateKey() {
       return this.key.incrementAndGet();
    }
}

package cache;

import org.apache.commons.lang3.time.StopWatch;

class Timer {

    private static final StopWatch STOP_WATCH = new StopWatch();

    static long measureTime(Runnable action) {

        STOP_WATCH.reset();
        STOP_WATCH.start();
        action.run();
        STOP_WATCH.stop();

        return STOP_WATCH.getTime();
    }
}

package internet_code;

/**
 * @author Dominik_Janiga
 */
public class Main {

    public static void main(String[] args) {

        LFUCache lfuCache = new LFUCache(10);

        lfuCache.put(1, 2);
        lfuCache.get(1);
        lfuCache.get(1);
        lfuCache.get(1);
        lfuCache.get(1);
        lfuCache.get(1);
    }

}

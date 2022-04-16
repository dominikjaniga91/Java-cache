package cache;

/**
 * @author Dominik_Janiga
 */
interface Counter {

    void increaseExistingKeyNumber();

    void increaseEvictedEntriesNumber();

}

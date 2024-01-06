package org.lrucache;

import org.jetbrains.annotations.NotNull;

public class LRUImplementation {
    public static void main(String @NotNull [] args) {
        LRUCache<String> lruCache = new LRUCache<>(1);
        lruCache.put("key1", "val1");
        lruCache.put("key1", "changeVal1");
        lruCache.print();
        lruCache.put("key2", "val2");
        lruCache.put("key3", "val3");
        lruCache.print();
        System.out.println(lruCache.get("key2"));
        lruCache.print();
        lruCache.put("key3", "val32");
        lruCache.print();
        lruCache.put("key4", "val4");
        lruCache.put("key5", "val5");
        lruCache.print();
    }
}

package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    Storage storage;
    private OriginalRetriever orr;
    private LRUCache cache;

    public CachingProxyRetriever(Storage storage) {
        orr = new OriginalRetriever(storage);
        cache = new LRUCache<>(16);
    }
    @Override
    public Object retrieve(long id) {
        Object result = cache.find(id);
        if(result==null) {
            Object o = orr.retrieve(id);
            cache.set(id, o);
            return o;
        }
       else return result;
    }
}
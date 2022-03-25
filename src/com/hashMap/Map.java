package com.hashMap;

public interface Map<E, V> {

    void put(E key, V value);

    V get(E key);

    void remove(E key);
}

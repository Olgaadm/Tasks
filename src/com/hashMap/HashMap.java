package com.hashMap;

import java.util.NoSuchElementException;

public class HashMap<E, V> implements Map<E, V> {

    private Entry<E, V>[] slots;

    private int itemsInSlots;
    private int deletedItems;
    private int rehashedItems;
    private static final int INIT_CAPACITY = 11;
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = INIT_CAPACITY;

    static class Entry<E, V> {
        private final E key;
        private final V value;
        private boolean deleted;

        private Entry(E key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashMap() {
        slots = (Entry<E, V>[]) new Entry[INIT_CAPACITY];
    }

    @Override
    public void put(E key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("This hash map could not contain null values");
        }
        resize();
        Entry<E, V> entry = new Entry<>(key, value);
        int i = searchSlot(key);
        if (slots[i].key != entry.key) {
            itemsInSlots++;
        }
        slots[i] = entry;
    }

    @Override
    public V get(E key) {
        assertParameters(key);
        int i = searchSlot(key);
        assertFoundSlot(i);
        return slots[i].value;
    }


    @Override
    public void remove(E key) {
        assertParameters(key);
        int i = searchSlot(key);
        assertFoundSlot(i);
        slots[i].deleted = true;
        deletedItems++;
        itemsInSlots--;
    }

    private int searchSlot(E key) {
        int i = hashFunction(key);
        int k = capacity;
        for (; k > 0 && slots[i] != null && !(slots[i].key.equals(key)); k--) {
            i = (i + 1) % capacity;
        }
        if (k != 0) {
            return i;
        } else
            return -1;
    }

    private void resize() {
        if ((float) (itemsInSlots) / capacity > LOAD_FACTOR) {
            capacity = capacity * 2;
            rehash(capacity);
        } else if (((float) (itemsInSlots + deletedItems) / capacity > LOAD_FACTOR)) {
            rehash(capacity);
        }

    }

    private void rehash(int capacity) {
        itemsInSlots = 0;
        deletedItems = 0;
        var old = slots;
        slots = (Entry<E, V>[]) new Entry[capacity];
        for (Entry<E, V> evEntry : old) {
            if (evEntry != null && !evEntry.deleted)
                put(evEntry.key, evEntry.value);
        }
    }

    private void assertParameters(E key) {
        if (slots == null || key == null) {
            throw new IllegalArgumentException("Either passed parameter is null or hashMap is empty");
        }
    }

    private void assertFoundSlot(int i) {
        if (i == -1 || slots[i] == null || slots[i].deleted) {
            throw new NoSuchElementException("Item does not exist or is deleted already");
        }
    }

    public Entry<E, V>[] getSlots() {
        Entry<E, V>[] copy = (Entry<E, V>[]) new Entry[capacity];
        for (int i = 0; i < slots.length; i++) {
            copy[i] = slots[i];
        }
        return copy;
    }

    private int hashFunction(E key) {
        return key.hashCode() % capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getItemsInSlots() {
        return itemsInSlots;
    }
}

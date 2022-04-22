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

    private void put(E key, V value, boolean resize) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("This hash map could not contain null values");
        }
        if (resize) {
            resize();
        }
        Entry<E, V> entry = new Entry<>(key, value);
        int i = searchSlot(key, true);
        if (slots[i] == null || !slots[i].key.equals(key) || slots[i].deleted) {
            itemsInSlots++;
        }
        slots[i] = entry;
    }

    @Override
    public void put(E key, V value) {
        put(key, value, true);
    }

    @Override
    public V get(E key) {
        assertParameters(key);
        int i = searchSlot(key, false);
        assertFoundSlot(i);
        return slots[i].value;
    }


    @Override
    public void remove(E key) {
        assertParameters(key);
        int i = searchSlot(key, false);
        assertFoundSlot(i);
        slots[i].deleted = true;
        deletedItems++;
        itemsInSlots--;
    }

    private int searchSlot(E key, boolean searchDeletedItems) {
        int i = hashFunction(key);
        int k = capacity;
        for (; slots[i] != null && !(slots[i].key.equals(key)); k--) {
            if (searchDeletedItems && slots[i].deleted) {
                return i;
            }
            i = (i + 1) % capacity;
        }
        if (k != 0) {
            return i;
        } else
            return -1;
    }

    private void resize() {
        final int TRESHOLD = Math.round(LOAD_FACTOR * capacity);
        if (itemsInSlots > TRESHOLD) {
            capacity = capacity * 2;
            rehash(capacity);
        } else if ((itemsInSlots + deletedItems) > TRESHOLD) {
            rehash(capacity);
        } else {
            if ((itemsInSlots > TRESHOLD/ 8) && (itemsInSlots < TRESHOLD / 2)) {
                capacity = TRESHOLD / 2;
                rehash(capacity);
            }
        }
    }

    private void rehash(int capacity) {
        itemsInSlots = 0;
        deletedItems = 0;
        var old = slots;
        slots = (Entry<E, V>[]) new Entry[capacity];
        for (Entry<E, V> evEntry : old) {
            if (evEntry != null && !evEntry.deleted)
                put(evEntry.key, evEntry.value, false);
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

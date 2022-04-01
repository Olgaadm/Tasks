package com.hashMap;

import java.util.NoSuchElementException;

public class HashMap<E, V> implements Map<E, V> {

    private Entry<E, V>[] slots;

    private int itemsInSlots;
    private int deletedItems;
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
        } else {
            resize();
            Entry<E, V> entry = new Entry<>(key, value);
            int hashValue = hashFunction(key);
            if (slots[hashValue] == null) {
                slots[hashValue] = entry;
            } else {
                int i = hashValue;
                while (!(slots[i] == null || slots[i].key.equals(key) || slots[i].deleted)) {
                    i = (i + 1) % capacity;
                }
                slots[i] = entry;
            }
            itemsInSlots++;
        }
    }

    @Override
    public V get(E key) {
        assertParameters(key);
        int hashValue = hashFunction(key);
        var entry = slots[hashValue];
        if (entry != null && entry.key.equals(key) && !entry.deleted)
            return entry.value;
        else {
            int foundSlotIndex = searchSlot(key);
            if (foundSlotIndex != -1)
                return slots[foundSlotIndex].value;
        }
        return null;
    }


    @Override
    public void remove(E key) {
        assertParameters(key);
        int hashValue = hashFunction(key);
        var entry = slots[hashValue];
        if (entry == null || (entry.key.equals(key) && entry.deleted)) {
            throw new NoSuchElementException("Item does not exist or is deleted already");
        } else {
            if (entry.key.equals(key)) {
                slots[hashValue].deleted = true;
            } else {
                int foundSlotIndex = searchSlot(key);
                if (foundSlotIndex != -1) {
                    slots[foundSlotIndex].deleted = true;
                }
            }
            deletedItems++;
            resize();
        }
    }

    private void resize() {
        if ((float) (itemsInSlots) / capacity > LOAD_FACTOR) {
            capacity = capacity * 2;
            rehash(capacity);
        } else {
            if (((float) (itemsInSlots + deletedItems) / capacity > LOAD_FACTOR)) {
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
                put(evEntry.key, evEntry.value);
        }
    }

    private int searchSlot(E key) {
        for (int i = 0; i < capacity; i++) {
            if (slots[i] != null && slots[i].key.equals(key) && !slots[i].deleted) {
                return i;
            }
        }
        return -1;
    }

    private void assertParameters(E key) {
        if (slots == null || key == null) {
            throw new IllegalArgumentException("Either passed parameter is null or hashMap is empty");
        }
    }

    private int hashFunction(E key) {
        return key.hashCode() % capacity;
    }

    public Entry<E, V>[] getSlots() {
        return slots.clone();
    }

    public int getCapacity() {
        return capacity;
    }


    public int getItemsInSlots() {
        return itemsInSlots;
    }
}

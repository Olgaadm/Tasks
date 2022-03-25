package com.hashMap;

public class HashMap<E, V> implements Map<E, V> {

    private Entry<E, V>[] slots;

    private int itemsInSlots;
    private static final int INIT_CAPACITY = 11;
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = INIT_CAPACITY;

    static class Entry<E, V> {
        private E key;
        private V value;
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
        if (key != null && value != null) {
            if ((float) itemsInSlots / capacity > LOAD_FACTOR) resize();
            Entry<E, V> entry = new Entry<>(key, value);
            int hashValue = hashFunction(key);
            if (slots[hashValue] == null) {
                slots[hashValue] = entry;
                itemsInSlots++;
            } else {
                int i = 0;
                int skip = 0;
                do {
                    if (slots[i] != null) {
                        if (slots[i].key == key && !slots[i].deleted) {
                            slots[i].value = value;
                            return;
                        }
                    }
                    i = (hashValue + skip) % capacity;
                    skip++;
                }
                while (slots[i] != null);

                if (slots[i] == null) {
                    slots[i] = entry;
                    itemsInSlots++;
                }
            }
        } else System.out.println("This hash map could not contain null values");
    }

    @Override
    public V get(E key) {
        V returnValue = null;
        if (slots != null && key != null) {
            int hashValue = hashFunction(key);
            Entry<E, V> entry = slots[hashValue];
            if (entry != null) {
                if (entry.key == key && !entry.deleted)
                    returnValue = entry.value;
                else {
                    for (int i = 0; i < capacity; i++) {
                        if (slots[i] != null)
                            if (slots[i].key == key && !slots[i].deleted)
                                returnValue = slots[i].value;
                    }
                }
            }
        }
        return returnValue;
    }

    @Override
    public void remove(E key) {
        if (slots != null && key != null) {
            int hashValue = hashFunction(key);
            Entry<E, V> entry = slots[hashValue];
            if (entry != null && !entry.deleted) {
                if (entry.key == key) slots[hashValue].deleted = true;
                else {
                    for (int i = 0; i < capacity; i++) {
                        if (slots[i] != null)
                            if (slots[i].key == key)
                                slots[i].deleted = true;
                    }
                }
            } else System.out.println("Item does not exist or is deleted already");
        }
    }

    // BUG What to do with "deleted" items?
    private void resize() {
        Entry<E, V>[] temp = slots;
        itemsInSlots = 0;
        capacity = capacity * 2;
        slots = (Entry<E, V>[]) new Entry[capacity];
        for (Entry<E, V> evEntry : temp) {
            if (evEntry != null)
                put(evEntry.key, evEntry.value);
        }
    }

    private int hashFunction(E key) {
        int sum = 0;
        int hash = 0;
        if (key instanceof String) {
            for (int i = 1; i <= ((String) key).length(); i++) {
                sum = sum + i * (int) ((String) key).charAt(i);
            }
            hash = sum % capacity;
        } else if (key instanceof Integer) {
            hash = ((int) key * (int) key) % capacity;
        }
        return hash;
    }


    public Entry<E, V>[] getSlots() {
        return slots;
    }

    public int getCapacity() {
        return capacity;
    }


    public int getItemsInSlots() {
        return itemsInSlots;
    }
}

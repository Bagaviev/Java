package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;
import java.util.Objects;

public class Entry implements Serializable {
    Long key;
    String value;
    int hash;
    Entry next;

    public Entry(int hash, Long key, String value, Entry next) {
        this.key = key;
        this.value = value;
        this.hash = hash;
        this.next = next;
    }

    public final Long getKey() {
        return key;
    }

    public final String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(key, entry.key) &&
                Objects.equals(value, entry.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    public final String toString() {
        return key + "=" + value;
    }
}

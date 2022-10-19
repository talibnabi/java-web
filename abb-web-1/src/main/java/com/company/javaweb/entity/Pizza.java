package com.company.javaweb.entity;

import com.company.javaweb.dao.Identifiable;

import java.io.Serializable;

public class Pizza implements Serializable, Identifiable {
    private final int id;
    private final int size;

    public Pizza(int id, int size) {
        this.id = id;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", size=" + size +
                '}';
    }

    @Override
    public int id() {
        return this.id;
    }
}

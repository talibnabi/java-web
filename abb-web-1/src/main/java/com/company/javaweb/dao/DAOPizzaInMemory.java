package com.company.javaweb.dao;

import com.company.javaweb.entity.Pizza;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DAOPizzaInMemory implements DAOPizza {
    private final Map<Integer, Pizza> data = new HashMap<>();

    @Override
    public void save(Pizza p) {
        data.put(0, p); //wrong
    }

    @Override
    public Optional<Pizza> load(int id) {
        throw new IllegalArgumentException("not implemented");

    }
}

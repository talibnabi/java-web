package com.company.javaweb.dao;

import java.util.Optional;

public interface DAO<A extends Identifiable> {
    void save(A p);

    Optional<A> load(int id);
}

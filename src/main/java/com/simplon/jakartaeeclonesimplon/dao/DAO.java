package com.simplon.jakartaeeclonesimplon.dao;

import java.util.ArrayList;
import java.util.List;

public interface DAO <T>{
    T getById(int id);

    List<T> getAll();

    void saveItem(T t);

    void updateItem(T t, String[] params);

    void delete(T t);
}

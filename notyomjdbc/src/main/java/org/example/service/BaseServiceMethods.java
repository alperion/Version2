package org.example.service;

import org.example.entity.Category;

import java.util.List;

public interface BaseServiceMethods <T>{


    public boolean save(T t);
    public List<T> getAll();

}

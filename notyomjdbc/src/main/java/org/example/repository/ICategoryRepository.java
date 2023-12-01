package org.example.repository;

import org.example.entity.Category;

import java.util.List;

public interface ICategoryRepository {
    public void save(String categoryName);
    public Category getByName(String name);
    public void delete(String categoryName);
    public List<Category> getAll();
}

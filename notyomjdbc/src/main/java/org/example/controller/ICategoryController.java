package org.example.controller;

import org.example.entity.Category;

import java.util.List;

public interface ICategoryController {
    public boolean save(String categoryName);
    public boolean delete(String categoryName);
    public Category getCategoryName(String categoryName);
    public List<Category> getCategory();
}

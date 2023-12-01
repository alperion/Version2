package org.example.service;

import org.example.entity.Category;

public interface ICategoryService extends BaseServiceMethods<Category>{
    public boolean delete(String categoryName);
    public Category getCategoryName(String categoryName);

}

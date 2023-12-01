package org.example.controller;

import org.example.entity.Category;
import org.example.service.CategoryService;
import org.example.service.ICategoryService;
import org.example.utility.Singleton;

import java.util.List;

public class CategoryController implements ICategoryController {

            ICategoryService categoryService;

    public CategoryController() {
        categoryService=Singleton.getCategoryService();
    }

    public boolean save(String categoryName){
        Category category=new Category();
        category.setName(categoryName);
        categoryService.save(category);
        return true;
    }
    public boolean delete(String categoryName){
        categoryService.delete(categoryName);
        return true;
    }
    public Category getCategoryName(String categoryName){
        return categoryService.getCategoryName(categoryName);
    }
    public List<Category> getCategory() {
        return categoryService.getAll();
    }


   /*     CategoryService categoryService=new CategoryService();
        public void createCategory(String categoryname){
            Category category=new Category();
            category.setName(categoryname);
            categoryService.saveCategory(category);
            }

         public void deleteCategory(String name){
        Category category=new Category();
        category.setName(name);
        categoryService.deleteCategory(category);
    }


    public void gelAllCategori(){
            categoryService.getAllCategory();
    }

*/





}

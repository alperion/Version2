package org.example.service;

import org.example.entity.Category;
import org.example.repository.CategoryRepository;
import org.example.repository.ICategoryRepository;

import java.util.List;


public class CategoryService implements ICategoryService{

        ICategoryRepository categoryRepository;
        //CONSTRUCTUREDAN ALMA
        public  CategoryService(){

            categoryRepository=new CategoryRepository();
        }


    public boolean save(Category category){
        if (categoryRepository.getByName(category.getName()).getId()==0){
            categoryRepository.save(category.getName());
            System.err.println("Kategori eklendi");
            return true;
        }
        else {
            System.err.println("kategori zaten var");
        }
        return false;
    }
    public Category getCategoryName(String categoryName){
        if (categoryRepository.getByName(categoryName).getId()==0){
            System.out.println("Bu kategori mevcut değil");
            return null;
        }
        else {
            return categoryRepository.getByName(categoryName);
        }

    }
    public boolean delete(String categoryName){

        if (categoryRepository.getByName(categoryName).getId()==0){
            System.out.println("Bu kategori mevcut değildir");
            return false;
        }
        else {
            categoryRepository.delete(categoryName);
            return true;
        }
    }



    public List<Category> getAll(){
           return categoryRepository.getAll();
    }



}

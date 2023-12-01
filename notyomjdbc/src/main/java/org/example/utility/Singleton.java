package org.example.utility;

import org.example.repository.CategoryRepository;
import org.example.repository.UserRepository;
import org.example.service.CategoryService;
import org.example.service.UserService;

public class Singleton {

        private static  DbConnection dbConnection=null;

        private static CategoryRepository categoryRepository=null;

        private  static UserRepository userRepository=null;

        private static UserService userService=null;
        private static CategoryService categoryService=null;

        public static DbConnection getDbConnection(){
            if(dbConnection==null){
                    dbConnection=new DbConnection();
                        return dbConnection;
            }
            return dbConnection;
        }
        public static CategoryRepository getCategoryRepository(){
            if(categoryRepository==null){
                    categoryRepository=new CategoryRepository();
            }
            return categoryRepository;
        }
        public static  UserRepository getUserRepository(){
            if(userRepository==null){
                    userRepository=new UserRepository();
                    return userRepository;
            }
            return userRepository;
        }
        public static UserService getUserService(){
            if(userService==null){
                    userService=new UserService();
                    return userService;
            }
            return userService;
        }

        public static CategoryService getCategoryService(){
            if(categoryService==null){
                    categoryService=new CategoryService();
                    return categoryService;
            }
            return categoryService;
        }


}

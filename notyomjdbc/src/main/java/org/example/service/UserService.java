package org.example.service;

import org.example.entity.Users;
import org.example.repository.IUserRepository;
import org.example.repository.UserRepository;

import java.util.List;

public class UserService implements IUserService{

    //DOĞRUDAN ALMA
    IUserRepository userRepository;

    public UserService() {
        userRepository =new UserRepository();
    }

    public boolean save(Users users){

        users.setEmail(users.getEmail());
        users.setPassword(users.getPassword());
        if (userRepository.isExist(users.getEmail(),users.getPassword()).getId()!=0){
            System.out.println("Böyle bir kullanıcı mevcut");
            return false;
        }
        else {
            userRepository.save(users);
            return true;
        }

    }

    public boolean isExist(String email,String password){
                    Users usercontroller=userRepository.isExist(email,password);
                    if(usercontroller.getId()!=0){
                            return true;
                    }
                    return false;
    }
    public boolean updateMail(String updateMail,String email,String password){
        Users users=new Users();
        users.setEmail(email);
        users.setPassword(password);
        return userRepository.updateMail(users, updateMail);
    }
    public boolean updateName(String updateName,String email){
        Users users=new Users();
        users.setName(updateName);
        users.setEmail(email);

        return userRepository.updateName(users);
    }
    public boolean updateSurname(String lastname,String email){
        Users users=new Users();
        users.setLastname(lastname);
        users.setEmail(email);
        return userRepository.updateSurname(users);
    }
    public boolean updatePassword(String password,String email){
        Users users=new Users();
        users.setPassword(password);
        users.setEmail(email);

        return userRepository.updatePassword(users);
    }

    public List<Users> getAll(){
        return userRepository.getUsers();
    }


/*
    public void userVarMi(User user){

            if (userRepostory.kullaniciDogrulama(user.getAd(),user.getSoyad()).getId()==0){
                           System.out.println(user.getAd()+" Kaydınız bulunmamaktadır.");

            }else{
                System.out.println(user.getAd()+" giriş başarılı bir şekilde gerçekleşmiştir.");
                Scanner scn=new Scanner(System.in);
                Scanner src=new Scanner(System.in);
                CategoryController categoryController=new CategoryController();
                UserController userController=new UserController();


                boolean customergiris=true;
                while (customergiris==true) {
                System.out.println("\n----->>>>>1_Category ekle \n----->>>>>2_Category sil  \n----->>>>>3_Kullanıcı Ekle \n----->>>>>4_Çıkış");
                int secim = scn.nextInt();
                    switch (secim) {
                        case 1:
                            System.out.println("kategori adını giriniz: ");
                            String categoryAd = src.nextLine();
                            categoryController.createCategory(categoryAd);
                            break;
                        case 2:
                            categoryController.gelAllCategori();
                            System.out.println("\nSilmek istediğmiz kategori adını giriniz: ");
                            String sil = src.nextLine();
                            categoryController.deleteCategory(sil);
                            break;
                        case 3:
                           Main.kullaniciGiris();
                        case 4:
                            customergiris=false;
                            break;
                        default:
                            System.out.println("Yanlış seçim yaptınız...");
                    }
                }
            }
    }*/
}
package prj3v2.csc214.prj3v2;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.Log;

import database.Favorites;
import database.FavoritesDAO;
import database.User;
import database.UserDAO;
import database.UserDatabase;
import database.UserInfo;
import database.UserInfoDAO;

/**
 * Created by Mike on 4/26/2018.
 */

public class LoginPageModel {
    public UserDatabase userDatabase;
    LoginPageController theController;

    public LoginPageModel(){

    }

    public void buildDB(Context context){
        userDatabase = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "userDatabase").allowMainThreadQueries().build();
        UserDAO userDao = userDatabase.userDao();
        UserInfoDAO userInfoDao = userDatabase.userInfoDao();
        FavoritesDAO favoritesDao = userDatabase.favoritesDao();

//        if(userDao.checkLogin("mike", "password")==0) {
//            User usert = new User("mike", "password");
//            UserInfo userinfot = new UserInfo("mike", "ny", "roc", "person");
//            Favorites favoritet = new Favorites(1,2);
//            userDao.insert(usert);
//            userInfoDao.insert(userinfot);
//            favoritesDao.insert(favoritet);
//            Log.i("MikeLoginActivity", Integer.toString(usert.getUid()));
//            usert = new User("tim", "1234");
//            userinfot = new UserInfo("tim", "roc", "roc?", "person");
//            favoritet = new Favorites(2,1);
//            userDao.insert(usert);
//            userInfoDao.insert(userinfot);
//            favoritesDao.insert(favoritet);
//            Log.i("TimLoginActivity", Integer.toString(usert.getUid()));
//            usert = new User("ahmed", "password1");
//            userinfot = new UserInfo("ahmed", "tunisia", "canada", "there's no bears in the jungle");
//            userDao.insert(usert);
//            userInfoDao.insert(userinfot);
//            Log.i("AhmedLoginActivity", Integer.toString(usert.getUid()));
//        }
    }

    public int checkLogin(String email, String password){
        UserDAO userDao = userDatabase.userDao();

        int valid = userDao.checkLogin(email, password);

        return valid;
    }

    public int getUid(String email, String password){
        UserDAO userDao = userDatabase.userDao();
        return userDao.getuid(email, password);
    }
}

package prj3v2.csc214.prj3v2;

import android.arch.persistence.room.Room;
import android.content.Context;

import database.Favorites;
import database.FavoritesDAO;
import database.UserDAO;
import database.UserDatabase;
import database.UserInfoDAO;

/**
 * Created by Mike on 4/29/2018.
 */

public class UserProfileModel {
    UserDatabase userDatabase;
    public UserProfileModel(){

    }

    public void buildDB(Context context) {
        userDatabase = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "userDatabase").allowMainThreadQueries().build();
        UserDAO userDao = userDatabase.userDao();
        UserInfoDAO userInfoDao = userDatabase.userInfoDao();
        FavoritesDAO favoritesDao = userDatabase.favoritesDao();

    }

    public int getFavorite(int uid, int targetid){
        FavoritesDAO favoritesDao = userDatabase.favoritesDao();
        return favoritesDao.getFavoriteUsers(uid, targetid);
    }

    public String getName(int targetid){
        UserInfoDAO userInfoDao = userDatabase.userInfoDao();
        return userInfoDao.getName(targetid);
    }

    public String getEmail(int targetid){
        UserDAO userDao = userDatabase.userDao();
        return userDao.getEmail(targetid);
    }

    public String getHome(int targetid){
        UserInfoDAO userInfoDao = userDatabase.userInfoDao();
        return userInfoDao.getHome(targetid);
    }

    public String getBirth(int targetid){
        UserInfoDAO userInfoDao = userDatabase.userInfoDao();
        return userInfoDao.getBirth(targetid);
    }

    public String getBio(int targetid){
        UserInfoDAO userInfoDao = userDatabase.userInfoDao();
        return userInfoDao.getBio(targetid);
    }

    public String getPath(int targetid){
        UserInfoDAO userInfoDao = userDatabase.userInfoDao();
        return userInfoDao.getPath(targetid);
    }

    public void deleteFavorite(int uid, int targetid){
        FavoritesDAO favoritesDao = userDatabase.favoritesDao();
        favoritesDao.delete(uid, targetid);
    }

    public void insertFavorite(int uid, int targetid){
        FavoritesDAO favoritesDao = userDatabase.favoritesDao();
        Favorites favoritet = new Favorites(uid, targetid);
        favoritesDao.insert(favoritet);
    }
}

package prj3v2.csc214.prj3v2;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.Log;

import java.util.List;

import database.FavoritesDAO;
import database.UserDAO;
import database.UserDatabase;
import database.UserInfo;
import database.UserInfoDAO;

/**
 * Created by Mike on 4/27/2018.
 */

public class ListUsersModel {
    UserDatabase userDatabase;

    public ListUsersModel(){

    }

    public void buildDB(Context context) {
        userDatabase = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "userDatabase").allowMainThreadQueries().build();
        UserDAO userDao = userDatabase.userDao();
        UserInfoDAO userInfoDao = userDatabase.userInfoDao();
    }

    public List<UserInfo> getUsers(int uid){
        UserDAO userDao = userDatabase.userDao();
        UserInfoDAO userInfoDao = userDatabase.userInfoDao();

        return userInfoDao.getUsers();
    }

    public int isFavorite(int uid, int targetid){
        FavoritesDAO favoritesDao = userDatabase.favoritesDao();
        UserInfoDAO userInfoDao = userDatabase.userInfoDao();

        UserInfo user = userInfoDao.getUser(uid);
        UserInfo target = userInfoDao.getUser(targetid);

        Log.i("favoriteModel", Integer.toString(user.getUid()));
        Log.i("favoriteModel", Integer.toString(target.getUid()));
        Log.i("favorite", Integer.toString(targetid));
        return favoritesDao.getFavoriteUsers(uid, targetid);
    }
}

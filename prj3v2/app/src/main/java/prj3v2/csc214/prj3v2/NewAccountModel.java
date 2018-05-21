package prj3v2.csc214.prj3v2;

import android.arch.persistence.room.Room;
import android.content.Context;

import database.User;
import database.UserDAO;
import database.UserDatabase;
import database.UserInfo;
import database.UserInfoDAO;
import database.UserInfoDatabase;

/**
 * Created by Mike on 4/26/2018.
 */

public class NewAccountModel {
    public UserDatabase userDatabase;
    public UserInfoDatabase userInfoDatabase;
    public NewAccountModel(){

    }

    public void buildDB(Context context){
        userDatabase = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "userDatabase").allowMainThreadQueries().build();
        //userInfoDatabase = Room.databaseBuilder(context.getApplicationContext(), UserInfoDatabase.class, "userDatabase").allowMainThreadQueries().build();
        UserDAO userDao = userDatabase.userDao();
        UserInfoDAO userInfoDAO = userDatabase.userInfoDao();
    }

    public void createNewUser(String path, String name, String email, String password, String home, String birth, String bio){
        UserDAO userDao = userDatabase.userDao();
        UserInfoDAO userInfoDao = userDatabase.userInfoDao();

        User usert = new User(email, password);
        UserInfo userinfot = new UserInfo(path, name, home, birth, bio);

        userDao.insert(usert);
        userInfoDao.insert(userinfot);
    }

    public int getuid(String email, String password){
        UserDAO userDao = userDatabase.userDao();
        UserInfoDAO userInfoDao = userDatabase.userInfoDao();

        return userDao.getuid(email, password);
    }
}

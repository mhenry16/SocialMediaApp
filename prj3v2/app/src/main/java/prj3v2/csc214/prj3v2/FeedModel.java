package prj3v2.csc214.prj3v2;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.List;

import database.FavoritesDAO;
import database.Post;
import database.PostDAO;
import database.UserDAO;
import database.UserDatabase;
import database.UserInfoDAO;

/**
 * Created by Mike on 4/29/2018.
 */

public class FeedModel {
    UserDatabase userDatabase;

    public FeedModel(){

    }

    public void buildDB(Context context) {
        userDatabase = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "userDatabase").allowMainThreadQueries().build();
        UserDAO userDao = userDatabase.userDao();
        UserInfoDAO userInfoDao = userDatabase.userInfoDao();
        FavoritesDAO favoritesDao = userDatabase.favoritesDao();
    }

    public int[] getFavorites(int uid) {
        FavoritesDAO favoritesDao = userDatabase.favoritesDao();
        return favoritesDao.getFavorites(uid);
    }

    public List<Post> getPosts(int[] favoriteids) {
        PostDAO postDao = userDatabase.postDao();
        return postDao.getPosts(favoriteids);
    }

    public void newPost(int uid, String text, String path){
        PostDAO postDao = userDatabase.postDao();
        Post temp = new Post(uid, text, path);
        postDao.insert(temp);
    }

    public String getName(int uid){
        UserInfoDAO userInfoDao = userDatabase.userInfoDao();
        return userInfoDao.getName(uid);
    }
}

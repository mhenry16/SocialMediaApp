package database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Mike on 4/26/2018.
 */

@Database(entities = {User.class, UserInfo.class, Favorites.class, Post.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDAO userDao();
    public abstract UserInfoDAO userInfoDao();
    public abstract FavoritesDAO favoritesDao();
    public abstract PostDAO postDao();
}

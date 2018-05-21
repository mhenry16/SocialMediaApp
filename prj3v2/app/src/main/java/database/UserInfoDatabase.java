package database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Mike on 4/26/2018.
 */

@Database(entities = {UserInfo.class}, version = 1)
public abstract class UserInfoDatabase extends RoomDatabase {
    public abstract UserInfoDAO userInfoDao();
}

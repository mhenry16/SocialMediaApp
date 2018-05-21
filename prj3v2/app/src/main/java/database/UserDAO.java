package database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

/**
 * Created by Mike on 4/26/2018.
 */

@Dao
public interface UserDAO {
    @Query("SELECT count(*) FROM user WHERE email=:email AND password=:password")
    int checkLogin(String email, String password);

    @Query("SELECT uid FROM user WHERE email=:email AND password=:password")
    int getuid(String email, String password);

    @Query("SELECT email FROM user WHERE uid=:uid")
    String getEmail(int uid);

    @Insert
    void insert(User user);
}

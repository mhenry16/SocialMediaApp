package database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Mike on 4/26/2018.
 */

@Dao
public interface UserInfoDAO {

    @Query("SELECT * FROM userinfo")
    List<UserInfo> getUsers();

    @Query("SELECT * FROM userinfo WHERE uid=:uid")
    UserInfo getUser(int uid);

    @Query("SELECT name FROM userinfo WHERE uid=:uid")
    String getName(int uid);

    @Query("SELECT birth FROM userinfo WHERE uid=:uid")
    String getBirth(int uid);

    @Query("SELECT home FROM userinfo WHERE uid=:uid")
    String getHome(int uid);

    @Query("SELECT bio FROM userinfo WHERE uid=:uid")
    String getBio(int uid);

    @Query("SELECT photoPath FROM userinfo WHERE uid=:uid")
    String getPath(int uid);

    @Insert
    void insert(UserInfo userInfo);
}

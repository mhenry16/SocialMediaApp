package database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Mike on 4/28/2018.
 */

@Dao
public interface FavoritesDAO {

    @Query("SELECT count(*) FROM favorites WHERE userID=:uid AND targetID=:targetid")
    int getFavoriteUsers(int uid, int targetid);

    @Insert
    void insert(Favorites favorites);

    @Query("DELETE FROM favorites WHERE userID=:uid AND targetID=:targetid")
    void delete(int uid, int targetid);

    @Query("SELECT targetID FROM favorites WHERE userID=:uid")
    int[] getFavorites(int uid);
}

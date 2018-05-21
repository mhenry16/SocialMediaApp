package database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Mike on 4/29/2018.
 */

@Dao
public interface PostDAO {
    @Insert
    void insert(Post post);

    @Query("SELECT * FROM post WHERE uid IN (:targetid)")
    public List<Post> getPosts(int[] targetid);
}

package database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Mike on 4/28/2018.
 */

@Entity (tableName = "favorites")
public class Favorites {
    @PrimaryKey(autoGenerate = true)
    private int favoriteid;

    @ColumnInfo (name = "userID")
    private int userID;

    @ColumnInfo (name = "targetID")
    private int targetID;

    public Favorites(int userID, int targetID) {
        this.userID = userID;
        this.targetID = targetID;
    }

    public int getFavoriteid() {
        return favoriteid;
    }

    public void setFavoriteid(int favoriteid) {
        this.favoriteid = favoriteid;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTargetID() {
        return targetID;
    }

    public void setTargetID(int targetID) {
        this.targetID = targetID;
    }
}

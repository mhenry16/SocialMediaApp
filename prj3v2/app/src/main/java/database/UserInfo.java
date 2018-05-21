package database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Mike on 4/26/2018.
 */

@Entity (tableName = "userinfo")
public class UserInfo {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo (name = "name")
    String name;

    @ColumnInfo (name = "home")
    String home;

    @ColumnInfo (name = "birth")
    String birth;

    @ColumnInfo (name = "bio")
    String bio;

    @ColumnInfo (name = "photoPath")
    String photoPath;

    public UserInfo(String photoPath, String name, String home, String birth, String bio) {
        this.photoPath = photoPath;
        this.name = name;
        this.home = home;
        this.birth = birth;
        this.bio = bio;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String toString(){
        return getName();
    }
}

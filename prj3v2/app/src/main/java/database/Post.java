package database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Mike on 4/29/2018.
 */

@Entity (tableName = "post")
public class Post {
    @PrimaryKey (autoGenerate = true)
    private int postid;

    @ColumnInfo (name = "uid")
    private int uid;

    @ColumnInfo (name = "postInfo")
    private String postinfo;

    @ColumnInfo (name = "path")
    private String path;

    public Post(int uid, String postinfo, String path) {
        this.uid = uid;
        this.postinfo = postinfo;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //    public Post(int uid, String path) {
//        this.uid = uid;
//        this.pathToPhoto = path;
//    }


    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getPostinfo() {
        return postinfo;
    }

    public void setPostinfo(String postinfo) {
        this.postinfo = postinfo;
    }

    public String toString(){ return getPostinfo();}
}

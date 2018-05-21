package prj3v2.csc214.prj3v2;

import android.content.Context;

import java.util.Collections;
import java.util.List;

import database.Post;

/**
 * Created by Mike on 4/29/2018.
 */

public class FeedController {
    FeedModel theModel;

    public FeedController(Context context){
        theModel = new FeedModel();
        theModel.buildDB(context);
    }

    public List<Post> getPosts(int uid){
        int[] favoriteids = theModel.getFavorites(uid);
        int [] favoriteAndMe = new int[favoriteids.length+1];

        for(int i=0;i<favoriteids.length;i++){
            favoriteAndMe[i]=favoriteids[i];
        }
        favoriteAndMe[favoriteAndMe.length-1] = uid;

        List<Post> onlyFavorites = theModel.getPosts(favoriteAndMe);
        return onlyFavorites;
//        if (onlyFavorites.isEmpty()){
//            return onlyFavorites;
//        }
//        else {
//            return Collections.reverse(onlyFavorites);
//        }
    }

    public void newPost(int uid, String text, String path){
        theModel.newPost(uid, text, path);
    }

    public String getName(int uid){
        return theModel.getName(uid);
    }
}

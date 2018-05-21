package prj3v2.csc214.prj3v2;

import android.content.Context;
import android.util.Log;

/**
 * Created by Mike on 4/29/2018.
 */

public class UserProfileController {
    UserProfileModel theModel;

    public UserProfileController(Context context){
        theModel = new UserProfileModel();
        theModel.buildDB(context);
    }

    public String setFavorite(int uid, int targetid) {
        int favorite = theModel.getFavorite(uid, targetid);

        if(favorite==1){
            return "Change to no";
        }
        else{
            return "Change to yes";
        }
    }

    public String getName(int targetid) {
        return theModel.getName(targetid);
    }

    public String getEmail(int targetid) {
        return theModel.getEmail(targetid);
    }

    public String getHome(int targetid) {
        return theModel.getHome(targetid);
    }

    public String getBirth(int targetid) {
        return theModel.getBirth(targetid);
    }

    public String getBio(int targetid) {
        return theModel.getBio(targetid);
    }

    public String getPath(int targetid) { return theModel.getPath(targetid);}

    public void changeFavorite(int uid, int targetid){
        int favorite = theModel.getFavorite(uid, targetid);

        Log.i("userProfileFavorite", Integer.toString(favorite));
        if(favorite==1){
            theModel.deleteFavorite(uid, targetid);
        }
        else{
            theModel.insertFavorite(uid, targetid);
        }
    }
}

package prj3v2.csc214.prj3v2;

import android.content.Context;

import java.util.List;

import database.UserInfo;

/**
 * Created by Mike on 4/27/2018.
 */

public class ListUsersController {
    ListUsersModel theModel;

    public ListUsersController(Context context) {
        theModel = new ListUsersModel();
        theModel.buildDB(context);
    }

    public List<UserInfo> getUsers(int uid){
        return theModel.getUsers(uid);
    }

    public int isFavorite(int uid, int targetid){
        return theModel.isFavorite(uid, targetid);
    }
}

package prj3v2.csc214.prj3v2;

import android.content.Context;

/**
 * Created by Mike on 4/26/2018.
 */

public class LoginPageController {
    LoginPageModel theModel;

    public LoginPageController(Context context){
        theModel = new LoginPageModel();
        theModel.buildDB(context);
    }

    public int checkLogin(String email, String password){
        return theModel.checkLogin(email, password);
    }

    public int getUid(String email, String password){
        return theModel.getUid(email, password);
    }
}

package prj3v2.csc214.prj3v2;

import android.content.Context;

/**
 * Created by Mike on 4/26/2018.
 */

public class NewAccountController {
    NewAccountModel theModel;

    public NewAccountController(Context context){
        theModel = new NewAccountModel();
        theModel.buildDB(context);

    }


    public void createNewUser(String path, String name, String email, String password, String home, String birth, String bio){
        theModel.createNewUser(path, name, email, password, home, birth, bio);
    }

    public int getuid(String email, String password){
        return theModel.getuid(email, password);
    }
}

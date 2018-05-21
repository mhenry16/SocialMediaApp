package prj3v2.csc214.prj3v2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPageActivity extends AppCompatActivity {
    LoginPageController theController;
    public int uid;
    EditText email;
    EditText password;

    public static final String KEY_UID = "mobappdev.prj3v2.UID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        theController = new LoginPageController(getApplicationContext());

        email = findViewById(R.id.emailEditTextLogin);
        password = findViewById(R.id.passwordEditTextLogin);
    }

    public void submitButtonClick(View view) {
        int valid = theController.checkLogin(email.getText().toString(), password.getText().toString());
        Log.i("TAG", Integer.toString(valid));

        if(valid==1){
            Intent intent = new Intent(LoginPageActivity.this, ListUsersActivity.class);
            uid = theController.getUid(email.getText().toString(), password.getText().toString());
            intent.putExtra(KEY_UID, uid);
            startActivity(intent);
        }
        else{
            Toast.makeText(LoginPageActivity.this, "invalid login", Toast.LENGTH_LONG).show();
        }
    }

    public void newAccountButtonClick(View view) {
        Intent intent = new Intent(LoginPageActivity.this, NewAccountActivity.class);
        startActivity(intent);
    }
}

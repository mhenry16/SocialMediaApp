package prj3v2.csc214.prj3v2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static prj3v2.csc214.prj3v2.LoginPageActivity.KEY_UID;

public class UserProfileActivity extends AppCompatActivity {
    public static final String KEY_TARGETID = "mobappdev.prj3v2.TARGETID";
    TextView nameProfile, emailProfile, homeProfile, birthProfile, bioProfile, favoriteText;
    Button favoriteProfile;
    ImageView imageUser;
    int uid;
    int targetid;
    String path;
    UserProfileController theController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        theController = new UserProfileController(getApplicationContext());
        nameProfile = findViewById(R.id.nameTextViewProfile);
        emailProfile = findViewById(R.id.emailTextViewProfile);
        homeProfile = findViewById(R.id.homeTextViewProfile);
        birthProfile = findViewById(R.id.birthTextViewProfile);
        bioProfile = findViewById(R.id.bioTextViewProfile);
        favoriteProfile = findViewById(R.id.favoriteButtonProfile);
        favoriteText =  findViewById(R.id.favoriteTextViewProfile);
        imageUser = findViewById(R.id.imageUser);

        Intent intent = getIntent();
        uid = intent.getIntExtra(KEY_UID, 0);
        targetid = intent.getIntExtra(KEY_TARGETID, 0);

        imageUser.setImageURI(Uri.parse(theController.getPath(targetid)));

        if(uid!=targetid) {
            favoriteProfile.setText(theController.setFavorite(uid, targetid));
        }
        else{
            favoriteText.setVisibility(View.GONE);
            favoriteProfile.setVisibility(View.GONE);
        }
        nameProfile.setText(theController.getName(targetid));
        emailProfile.setText(theController.getEmail(targetid));
        homeProfile.setText(theController.getHome(targetid));
        birthProfile.setText(theController.getBirth(targetid));
        bioProfile.setText(theController.getBio(targetid));
    }

    public void favoriteButtonClick(View view) {
        Log.i("favoriteClick", "click");
        theController.changeFavorite(uid, targetid);
        favoriteProfile.setText(theController.setFavorite(uid, targetid));
    }

    public void logoutButtonClick(View view) {
        Intent intent = new Intent(UserProfileActivity.this, LoginPageActivity.class);
        startActivity(intent);
    }

    public void usersPageButtonClick(View view) {
        Intent intent = new Intent(UserProfileActivity.this, ListUsersActivity.class);
        intent.putExtra(KEY_UID, uid);
        startActivity(intent);
    }

    public void feedButtonClick(View view) {
        Intent intent = new Intent(UserProfileActivity.this, FeedActivity.class);
        intent.putExtra(KEY_UID, uid);
        startActivity(intent);
    }
}

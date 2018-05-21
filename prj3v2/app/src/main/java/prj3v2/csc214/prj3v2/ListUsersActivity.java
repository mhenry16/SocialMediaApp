package prj3v2.csc214.prj3v2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import database.Favorites;
import database.UserInfo;

import static prj3v2.csc214.prj3v2.LoginPageActivity.KEY_UID;
import static prj3v2.csc214.prj3v2.UserProfileActivity.KEY_TARGETID;

public class ListUsersActivity extends AppCompatActivity {
    ListView mListView;
    ListUsersController theController;

    public int uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        theController = new ListUsersController(getApplicationContext());
        mListView = findViewById(R.id.listOfUsers);

        Intent intent = getIntent();
        uid = intent.getIntExtra(KEY_UID, 0);

        final List<UserInfo> fullListOfUsers = theController.getUsers(uid);

        UserInfo[] userList = new UserInfo[fullListOfUsers.size()];

        for(int i = 0; i < fullListOfUsers.size(); i++){
            UserInfo user = fullListOfUsers.get(i);
            userList[i] = user;
        }

        Favorites[] favoriteList =  new Favorites[fullListOfUsers.size()];
        String[] userListString = new String[fullListOfUsers.size()];

        for(int i=0; i<fullListOfUsers.size(); i++){
            userListString[i] = userList[i].toString();
        }

        //Log.i("TAG", Integer.toString(uid));
        for(int i = 1; i <= fullListOfUsers.size(); i++){
            //Log.i("isFavorite", Integer.toString(theController.isFavorite(uid, i)));
            if(uid==i){
                //userListString[i-1] += " -- Self";
                userList[i-1].setName(userList[i-1].getName()+" -- Self");
            }
            else if(theController.isFavorite(uid, i)==1){
                userList[i-1].setName(userList[i-1].getName()+" -- Favorite");            }
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_activated_1, userList);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = mListView.getItemAtPosition(position);
                UserInfo user = (UserInfo) o; //As you are using Default String Adapter
//                String Iid = Integer.toString(item.getUid());
//                Toast.makeText(getBaseContext(),Iid,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListUsersActivity.this, UserProfileActivity.class);
                intent.putExtra(KEY_UID, uid);
                intent.putExtra(KEY_TARGETID, user.getUid());
                startActivityForResult(intent, 1);
            }
        });
    }

    public void logoutButtonClick(View view) {
        Intent intent = new Intent(ListUsersActivity.this, LoginPageActivity.class);
        startActivity(intent);
    }

    public void usersPageButtonClick(View view) {
        Intent intent = new Intent(ListUsersActivity.this, ListUsersActivity.class);
        intent.putExtra(KEY_UID, uid);
        startActivity(intent);
    }

    public void feedButtonClick(View view) {
        Intent intent = new Intent(ListUsersActivity.this, FeedActivity.class);
        intent.putExtra(KEY_UID, uid);
        startActivity(intent);
    }
}

package prj3v2.csc214.prj3v2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import database.Post;
import database.UserInfo;

import static prj3v2.csc214.prj3v2.LoginPageActivity.KEY_UID;

public class FeedActivity extends AppCompatActivity {
    ListView mListView;
    EditText newPostText;
    String mPhotoPath;
    FeedController theController;

    Post[] postList;
    int uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        theController = new FeedController(getApplicationContext());

        //mListView = findViewById(R.id.listViewPosts);
        newPostText = findViewById(R.id.newPostTextField);

        Intent intent = getIntent();
        uid = intent.getIntExtra(KEY_UID, 0);

        final List<Post> fullListOfPosts = theController.getPosts(uid);

        postList = new Post[fullListOfPosts.size()];
        Log.i("Posts", String.valueOf(postList.length));

        for(int i = 0; i < fullListOfPosts.size(); i++){
            Post post = fullListOfPosts.get(i);
            postList[i] = post;
        }

        for(int i = 0; i<fullListOfPosts.size();  i++){
            Post temp = postList[postList.length-i-1];
            postList[postList.length-i-1] = postList[i];
            postList[i] = temp;
        }

        for(int i = 1; i <= fullListOfPosts.size(); i++) {
            postList[i - 1].setPostinfo(postList[i - 1].getPostinfo() + " -- " + theController.getName(postList[i-1].getUid()));
        }

        List<Post> postsFinal = new ArrayList<Post>();

        for(int i = 1; i <= fullListOfPosts.size(); i++) {
            postsFinal.add(postList[i-1]);
        }


        ListView yourListView = (ListView) findViewById(R.id.listViewPosts);
        ListAdapter customAdapter = new ListAdapter(this, R.layout.custom_post_view, postsFinal);
        yourListView.setAdapter(customAdapter);
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_activated_1, postList);
//        mListView.setAdapter(adapter);
    }

    public void logoutButtonClick(View view) {
        Intent intent = new Intent(FeedActivity.this, LoginPageActivity.class);
        startActivity(intent);
    }

    public void newPostButtonClick(View view) {
        String path;
        if(photoURI!=null){
            path = String.valueOf(photoURI);
        }
        else{
            path = " ";
        }
        Log.i("TAG", path);

        theController.newPost(uid, newPostText.getText().toString(), path);
        newPostText.setText("");
    }

    public void postPictureClick(View view) {
        dispatchTakePictureIntent();
    }

    private File createImageFile() throws IOException {
        String imageFileName = "jpg_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, ".jpg", storageDir);
        mPhotoPath = image.getAbsolutePath();
        //File image = File.createTempFile(imageFileName, ".jpg", getExternalFilesDir(Environment.DIRECTORY_PICTURES));
        return image;
    }

    Intent takePictureIntent;
    int REQUEST_TAKE_PHOTO = 1;
    Uri photoURI;

    private void dispatchTakePictureIntent() {
        takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            }
            catch (IOException e) {}
            Log.i("TAG", String.valueOf(photoFile));
            if (photoFile != null) {
                photoURI = FileProvider.getUriForFile(this, "com.example.android.fileprovider", photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                Log.i("Image file path", String.valueOf(photoURI));
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }
    //
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == 0) {
            mPhotoPath = "";
            //mImageView.setImageURI(photoURI);
            Log.i("AFTER EVERYTHING", "stuff");
        }
        else if(requestCode == REQUEST_TAKE_PHOTO) {
            //mImageView.setImageURI(photoURI);
            Log.i("AFTER EVERYTHING", "stuff");
        }
    }

    public void feedButtonClick(View view) {
        Intent intent = new Intent(FeedActivity.this, FeedActivity.class);
        intent.putExtra(KEY_UID, uid);
        startActivity(intent);
    }

    public void usersPageButtonClick(View view) {
        Intent intent = new Intent(FeedActivity.this, ListUsersActivity.class);
        intent.putExtra(KEY_UID, uid);
        startActivity(intent);
    }
//    private static class PostHolder {
//        public ImageView postedImage;
//        public TextView postedText;
//    }
//
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View v = convertView;
//
//        PostHolder holder = new PostHolder();
//
//        // First let's verify the convertView is not null
//        if (convertView == null) {
//            // This a new view we inflate the new layout
//            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            v = inflater.inflate(android.R.layout.simple_list_item_activated_1, null);
//            // Now we can fill the layout with the right values
//            TextView tv = (TextView) v.findViewById(R.id.userPostedText);
//            ImageView img = (ImageView) v.findViewById(R.id.userPostedImage);
//
//            holder.postedText = tv;
//            holder.postedImage = img;
//
//            v.setTag(holder);
//        }
//        else
//            holder = (PostHolder) v.getTag();
//
//        System.out.println("Position ["+position+"]");
//        Post p = postList[position];
//        holder.postedText.setText(p.getPostinfo());
//        holder.postedImage.setImageURI(Uri.parse(p.getPathToPhoto()));
//
//        return v;
//    }
}

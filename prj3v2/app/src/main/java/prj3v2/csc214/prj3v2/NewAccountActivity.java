package prj3v2.csc214.prj3v2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static prj3v2.csc214.prj3v2.LoginPageActivity.KEY_UID;

public class NewAccountActivity extends AppCompatActivity {
    NewAccountController theController;
    ImageView mImageView;
    EditText emailCreation;
    EditText nameCreation;
    EditText passwordCreation;
    EditText homeCreation;
    EditText birthCreation;
    EditText bioCreation;
    String mPhotoPath;
    int uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);

        theController = new NewAccountController(getApplicationContext());

        emailCreation = findViewById(R.id.emailEditTextCreation);
        nameCreation = findViewById(R.id.nameEditTextCreation);
        passwordCreation = findViewById(R.id.passwordEditTextCreation);
        homeCreation = findViewById(R.id.homeEditTextCreation);
        birthCreation = findViewById(R.id.birthEditTextCreation);
        bioCreation = findViewById(R.id.bioEditTextCreation);
        mImageView = findViewById(R.id.imageUserCreation);
    }

    public void finishButtonClick(View view) {
        String name = nameCreation.getText().toString();
        String email = emailCreation.getText().toString();
        String password = passwordCreation.getText().toString();
        String home = homeCreation.getText().toString();
        String birth = birthCreation.getText().toString();
        String bio = bioCreation.getText().toString();
        String path = String.valueOf(photoURI);

        theController.createNewUser(path, name, email, password, home, birth, bio);
        uid = theController.getuid(email, password);

        Intent intent = new Intent(NewAccountActivity.this, ListUsersActivity.class);
        intent.putExtra(KEY_UID, uid);
        startActivity(intent);
    }

    public void takeAPhoto(View view) {
        dispatchTakePictureIntent();

        Log.i("AFTER", String.valueOf(photoURI));
//        mImageView.setImageURI(null);
//        mImageView.setImageURI(photoURI);
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            File mPhotoFile = null;
//            try {
//                mPhotoFile = createImageFile();
//            } catch (IOException e) {
//                Toast.makeText(NewAccountActivity.this, "Error creating file for picture",
//                        Toast.LENGTH_LONG).show();
//            }
//            if (mPhotoFile != null) {
//                Uri photoURI = FileProvider.getUriForFile(NewAccountActivity.this,
//                        "com.example.mike.fileprovider", mPhotoFile);
//                mPhotoPath = mPhotoFile.getPath();
//                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
//                startActivityForResult(intent, 0);
//            }
//        } else {
//            Toast.makeText(NewAccountActivity.this, "No camera app available to take photo!",
//                    Toast.LENGTH_LONG).show();
//        }
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
            mImageView.setImageURI(photoURI);
            Log.i("AFTER EVERYTHING", "stuff");
        }
        else if(requestCode == REQUEST_TAKE_PHOTO) {
            mImageView.setImageURI(photoURI);
            Log.i("AFTER EVERYTHING", "stuff");
        }
    }

//    static final int REQUEST_IMAGE_CAPTURE = 1;
//
//    private void dispatchTakePictureIntent() {
//        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
//        }
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
//            Bundle extras = data.getExtras();
//            Bitmap imageBitmap = (Bitmap) extras.get("data");
//            mImageView.setImageBitmap(imageBitmap);
//        }
//    }
//
//    String mCurrentPhotoPath;
//
//    private File createImageFile() throws IOException {
//        // Create an image file name
//        String imageFileName = "JPEG_";
//        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
//        File image = File.createTempFile(
//                imageFileName,  /* prefix */
//                ".jpg",         /* suffix */
//                storageDir      /* directory */
//        );
//
//        // Save a file: path for use with ACTION_VIEW intents
//        mCurrentPhotoPath = image.getAbsolutePath();
//        return image;
//    }

//    static final int REQUEST_TAKE_PHOTO = 1;
//
//    private void dispatchTakePictureIntent() {
//        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        // Ensure that there's a camera activity to handle the intent
//        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//            // Create the File where the photo should go
//            File photoFile = null;
//            try {
//                photoFile = createImageFile();
//            } catch (IOException ex) {
//                // Error occurred while creating the File
//
//            }
//            // Continue only if the File was successfully created
//            if (photoFile != null) {
//                Uri photoURI = FileProvider.getUriForFile(this,
//                        "com.example.mike.fileprovider",
//                        photoFile);
//                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
//                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
//            }
//        }
//    }
}

package com.example.allascopertadibomarzo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;
import androidx.annotation.NonNull;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActivityCamera extends AppCompatActivity {
    private static final int PERMISSION_CODE = 1000 ;
    private static final int IMAGE_CAPTURE_CODE =1001 ;
    ImageView cattura;
    ImageView Visualizzatore;
    Uri image_uri;
    ImageView share;
    TextView descrizione;
    //String messaggio="ciao sono un tirannosauro laser e mi piacciono i treni laser";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        //back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String messaggio=getIntent().getExtras().getString("descrizione");


        Visualizzatore=(ImageView) findViewById(R.id.img);
        //cattura=  findViewById(R.id.cambtn);
        share=(ImageView) findViewById(R.id.share_img);
        descrizione=findViewById(R.id.descrizione_txt);
        descrizione.setText(messaggio);

        if (Build.VERSION.SDK_INT >= VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA)== PackageManager.PERMISSION_DENIED ||
                    checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED) {
                //permission not enabled
                String[] permission={Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                //permission request
                requestPermissions(permission, PERMISSION_CODE);
            }
            else {openCamera();}
        }
        else {openCamera();}


    //button click
        /*cattura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

     //share click
        share.setOnClickListener(v -> {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    // Creates a new text clip to put on the clipboard
            ClipData clip = ClipData.newPlainText("", messaggio);
            clipboard.setPrimaryClip(clip);
            Toast.makeText(this, "Descrizione Copiata negli appunti. \nAdesso puoi incollarla in un Post", Toast.LENGTH_LONG).show();
            //Toast.makeText(this, messaggio, Toast.LENGTH_SHORT).show();
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_STREAM, image_uri);
            shareIntent.putExtra(Intent.EXTRA_TEXT, messaggio);
            shareIntent.setType("image/*");
            startActivity(Intent.createChooser(shareIntent, "Share to.."));

        });
    }

    public void openCamera() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "New Picture");
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the camera");
        image_uri= getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        //Camera intent
        Intent cameraIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri);
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE);
    }
    //handling permission result

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISSION_CODE:{
                if (grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    openCamera();
                }
                else {
                    Toast.makeText(this, "permission denied... retry", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Visualizzatore.setImageURI(image_uri);
            //Intent intent2= new Intent(this, ActivityViewImage.class);
            //intent2.putExtra("image", image_uri);
            //startActivity(intent2);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }



}




//Intent shareIntent = new Intent(); shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE); shareIntent.putExtra(Intent.EXTRA_STREAM, image_uri); sendIntent.putExtra(Intent.EXTRA_TEXT, messaggio.toString()); sendIntent.setType("/"); startActivity(Intent.createChooser(shareIntent, "Share to.."));
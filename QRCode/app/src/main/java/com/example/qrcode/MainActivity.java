package com.example.qrcode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button sc,gen;

    int CAMERA_PER_CODE = 233;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){

        }
        else {
            requestpermission();

        }

        sc= (Button) findViewById(R.id.sc);
        sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenScanner();
            }
        });

        gen= (Button) findViewById(R.id.gen);

        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenGenerator();
            }
        });
    }



    private void OpenScanner() {

        Intent intent = new Intent(this,Scnr.class);
        startActivity(intent);
    }
    private void OpenGenerator() {

        Intent intent = new Intent(this,Genarator.class);
        startActivity(intent);
    }





    private void requestpermission() {

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},CAMERA_PER_CODE);

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==CAMERA_PER_CODE)
        {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

                Toast.makeText(MainActivity.this,"Given",Toast.LENGTH_LONG).show();


            }
            else{
                Toast.makeText(MainActivity.this,"Denied",Toast.LENGTH_LONG).show();
            }
        }

    }
}

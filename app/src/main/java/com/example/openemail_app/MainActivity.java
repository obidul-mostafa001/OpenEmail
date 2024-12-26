package com.example.openemail_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.openemail_app.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mVB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        mVB = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mVB.getRoot());

        //hi





        mVB.btnNext.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String name = mVB.NameEt.getText().toString();
                String msg;
                if (name.isEmpty()){
                    msg= "please Enter your name";
                    Snackbar.make(mVB.getRoot(),msg,Snackbar.LENGTH_SHORT).show();
                }else {
                    msg = "Your name is " + name;

                }
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });
    }

}
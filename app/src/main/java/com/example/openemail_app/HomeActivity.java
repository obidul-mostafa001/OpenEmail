package com.example.openemail_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.openemail_app.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding mVB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        mVB = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(mVB.getRoot());
        //setContentView(R.layout.activity_home);
        String name = getIntent().getStringExtra("name");
        mVB.tvGreet.setText("Welcome "+name);
        String msg="Welcome "+name;
        mVB.tvGreet.setText(msg);


        mVB.btnSend.setOnClickListener(v -> {

            if (!valiDate()){
                return;
            }
            String email = mVB.emailEt.getText().toString();
            String subject = mVB.subjectEt.getText().toString();
            String message = mVB.messageEt.getText().toString();

            sendEmail(email,subject,message);
        });

    }

    private void sendEmail(String email, String subject, String message) {
        Intent emailintent = new Intent(Intent.ACTION_SEND);
        emailintent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        emailintent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailintent.putExtra(Intent.EXTRA_TEXT, message);
        emailintent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailintent,"Choose an email client"));
        
    }

    public boolean valiDate(){
        String email = mVB.emailEt.getText().toString();
        String subject = mVB.subjectEt.getText().toString();
        String message = mVB.messageEt.getText().toString();
        if (email.isEmpty()){
            mVB.emailEt.setError("Email is required");
            return false;
        }
        if (subject.isEmpty()){
            mVB.subjectEt.setError("Subject is required");
        }
        if (message.isEmpty()){
            mVB.messageEt.setError("Message is required");
        }
        return true;
    }
}
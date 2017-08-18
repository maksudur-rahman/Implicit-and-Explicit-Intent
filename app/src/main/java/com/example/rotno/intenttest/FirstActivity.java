package com.example.rotno.intenttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private EditText smsET;
    private EditText emailET;
    private EditText phoneET;
    private EditText urlET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        smsET= (EditText) findViewById(R.id.smsHint);
        emailET= (EditText) findViewById(R.id.emailHint);
        phoneET= (EditText) findViewById(R.id.phoneHint);
        urlET= (EditText) findViewById(R.id.urlHint);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    public void toSecondActivity(View view) {
        Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
        String sms=smsET.getText().toString();
        if(sms.isEmpty())
        {
            smsET.setError("Invalid");
        }
        String email=emailET.getText().toString();
        if(email.isEmpty())
        {
            emailET.setError("Invalid");
        }
        String phone=phoneET.getText().toString();
        if(phone.isEmpty())
        {
            phoneET.setError("Invalid");
        }
        String web=urlET.getText().toString();
        if(web.isEmpty())
        {
            urlET.setError("Invalid");
        }
        intent.putExtra("sms",sms);
        intent.putExtra("email",email);
        intent.putExtra("phone",phone);
        intent.putExtra("url",web);
        startActivity(intent);
    }
}

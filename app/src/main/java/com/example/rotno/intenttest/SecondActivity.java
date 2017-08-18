package com.example.rotno.intenttest;

import android.Manifest;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private TextView resultTV;
    private String retsms;
    private  String retphone;
    private String retEmail;
    private String retUrl;
    private String name;
    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        retsms=getIntent().getStringExtra("sms");
        retEmail=getIntent().getStringExtra("email");
        retphone=getIntent().getStringExtra("phone");
        retUrl=getIntent().getStringExtra("url");

        if(!retUrl.contains("http://"))
            retUrl = "http://"+retUrl;
        if(!retUrl.contains("."))
            retUrl = retUrl+".com";

        resultTV= (TextView) findViewById(R.id.resultTV);
        resultTV.setText("Message \t\t: \t\t" + retsms + "\nEmail \t\t: \t\t" + retEmail + "\nPhone \t\t: \t\t" + retphone + "\nURL \t\t: \t\t" + retUrl);

    }

    public void toText(View view) {
        Intent sms = new Intent(Intent.ACTION_SENDTO);
        sms.setData(Uri.parse("smsto:"+retsms));
        sms.putExtra("sms_body","Tore Laiththamu ami");
        startActivity(sms);
    }

    public void toMail(View view) {
        String body="Emni test kortesi";
        String subject="Your subject here";
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , retEmail);
        i.putExtra(Intent.EXTRA_SUBJECT, subject);
        i.putExtra(Intent.EXTRA_TEXT   , body);
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(SecondActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }


    public void toCall(View view) {
        Intent intent=new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+retphone));
        Intent chooser=Intent.createChooser(intent,"select App");
        startActivity(chooser);
    }

    public void toWeb(View view) {
        Intent site = new Intent(Intent.ACTION_VIEW, Uri.parse(retUrl));
        startActivity(site);
    }
}

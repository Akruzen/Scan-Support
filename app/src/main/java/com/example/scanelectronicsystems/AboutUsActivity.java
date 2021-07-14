package com.example.scanelectronicsystems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AboutUsActivity extends AppCompatActivity {

    TextView emailUsTextView;
    TextView callUsTextView;

    public void callUs(View view)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:9372273302"));
        startActivity(intent);
    }

    public void emailUs(View view)
    {
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("plain/text");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] {"support@scanelectronicsystems.com"});
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Troubleshooting Support");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,"");
        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
    }

    public void goToWebsite(View view)
    {
        Uri uri = Uri.parse("http://www.scanelectronicsystems.com/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();

        emailUsTextView = findViewById(R.id.emailUsTextView);
        callUsTextView = findViewById(R.id.callUsTextView);

    }
}
package com.example.scanelectronicsystems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OtherComplaints extends AppCompatActivity {

    EditText otherComplaintsEditText;
    TextView productNameTextView3;
    String productID;
    String productDetails;
    String productName;
    String allComplaintsString = "";
    String userName = "";
    int complaintType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_complaints);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();

        otherComplaintsEditText = findViewById(R.id.otherComplaintsEditText);
        productNameTextView3 = findViewById(R.id.productNameTextView3);

        Intent intent = getIntent();
        productID = intent.getStringExtra("productID");
        productDetails = intent.getStringExtra("productDetails");
        productName = intent.getStringExtra("productName");
        allComplaintsString = intent.getStringExtra("allComplaintsString");
        userName = intent.getStringExtra("userName");
        complaintType = intent.getIntExtra("complaintType", 1);

        productNameTextView3.setText(productName);

    }

    public void nextButton(View view)
    {
        if (otherComplaintsEditText.getText().toString().matches(""))
        {
            Toast.makeText(this, "Please enter some details.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            allComplaintsString = allComplaintsString + otherComplaintsEditText.getText().toString();
            Intent intent;
            intent = new Intent(getApplicationContext(), SolutionsActivity.class);
            intent.putExtra("productID", productID);
            intent.putExtra("productDetails", productDetails);
            intent.putExtra("productName", productName);
            intent.putExtra("allComplaintsString", allComplaintsString);
            intent.putExtra("userName", userName);
            intent.putExtra("complaintType", complaintType);
            startActivity(intent);
        }
    }

}
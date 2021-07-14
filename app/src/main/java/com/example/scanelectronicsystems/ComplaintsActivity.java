package com.example.scanelectronicsystems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class ComplaintsActivity extends AppCompatActivity {

    TextView productNameTextView2;
    String userName;
    String productID;
    String productDetails;
    String productName;
    String allComplaintsString = "";
    int complaintType;

    CheckBox checkbox1;
    CheckBox checkbox2;
    CheckBox checkbox3;
    CheckBox checkbox4;
    CheckBox checkbox5;
    CheckBox checkbox6;
    CheckBox checkbox7;
    CheckBox checkbox8;
    CheckBox checkbox9;
    CheckBox checkbox10;
    CheckBox checkbox11;
    CheckBox checkbox12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaints);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();

        productNameTextView2 = findViewById(R.id.productNameTextView2);

        checkbox1 = findViewById(R.id.checkBox1);
        checkbox2 = findViewById(R.id.checkBox2);
        checkbox3 = findViewById(R.id.checkBox3);
        checkbox4 = findViewById(R.id.checkBox4);
        checkbox5 = findViewById(R.id.checkBox5);
        checkbox6 = findViewById(R.id.checkBox6);
        checkbox7 = findViewById(R.id.checkBox7);
        checkbox8 = findViewById(R.id.checkBox8);
        checkbox9 = findViewById(R.id.checkBox9);
        checkbox10 = findViewById(R.id.checkBox10);
        checkbox11 = findViewById(R.id.checkBox11);
        checkbox12 = findViewById(R.id.checkBox12);

        Intent intent = getIntent();
        productID = intent.getStringExtra("productID");
        productDetails = intent.getStringExtra("productDetails");
        productName = intent.getStringExtra("productName");
        complaintType = intent.getIntExtra("complaintType", 0);
        userName = intent.getStringExtra("userName");

        if (complaintType == 1)
        {
            checkbox1.setText("Installation problem");
            checkbox2.setText("Key or Hardware lock not found");
            checkbox3.setText("RUN problem from Icon");
            checkbox4.setText("Communication error");
            checkbox5.setText("Runtime Error");
            checkbox6.setText("Report error");
            checkbox7.setText("Blank Graph");
            checkbox8.setText("Does not show History");
            checkbox9.setText("Tag value not displayed or incorrect");
            checkbox10.setText("Other");

            checkbox11.setVisibility(View.GONE);
            checkbox12.setVisibility(View.GONE);

        }

        productNameTextView2.setText(productName);

    }

    public void nextButton(View view)
    {
        allComplaintsString = "";

        if (checkbox1.isChecked())
            allComplaintsString = allComplaintsString + checkbox1.getText().toString() + "\n";
        if (checkbox2.isChecked())
            allComplaintsString = allComplaintsString + checkbox2.getText().toString() + "\n";
        if (checkbox3.isChecked())
            allComplaintsString = allComplaintsString + checkbox3.getText().toString() + "\n";
        if (checkbox4.isChecked())
            allComplaintsString = allComplaintsString + checkbox4.getText().toString() + "\n";
        if (checkbox5.isChecked())
            allComplaintsString = allComplaintsString + checkbox5.getText().toString() + "\n";
        if (checkbox6.isChecked())
            allComplaintsString = allComplaintsString + checkbox6.getText().toString() + "\n";
        if (checkbox7.isChecked())
            allComplaintsString = allComplaintsString + checkbox7.getText().toString() + "\n";
        if (checkbox8.isChecked())
            allComplaintsString = allComplaintsString + checkbox8.getText().toString() + "\n";
        if (checkbox9.isChecked())
            allComplaintsString = allComplaintsString + checkbox9.getText().toString() + "\n";

        if (complaintType == 0)
        {
            if (checkbox10.isChecked())
                allComplaintsString = allComplaintsString + checkbox10.getText().toString() + "\n";
            if (checkbox12.isChecked())
            {
                allComplaintsString = allComplaintsString + checkbox12.getText().toString() + ": ";
                Intent intent;
                intent = new Intent(getApplicationContext(), OtherComplaints.class);
                intent.putExtra("productID", productID);
                intent.putExtra("productDetails", productDetails);
                intent.putExtra("productName", productName);
                intent.putExtra("allComplaintsString", allComplaintsString);
                intent.putExtra("complaintType", complaintType);
                intent.putExtra("userName", userName);
                startActivity(intent);
            }
            else
            {
                Intent intent;
                intent = new Intent(getApplicationContext(), SolutionsActivity.class);
                intent.putExtra("productID", productID);
                intent.putExtra("productDetails", productDetails);
                intent.putExtra("productName", productName);
                intent.putExtra("allComplaintsString", allComplaintsString);
                intent.putExtra("complaintType", complaintType);
                intent.putExtra("userName", userName);
                startActivity(intent);
            }
        }
        else // if complaintType == 1
        {
            if (checkbox10.isChecked())
            {
                allComplaintsString = allComplaintsString + checkbox10.getText().toString() + ": ";
                Intent intent;
                intent = new Intent(getApplicationContext(), OtherComplaints.class);
                intent.putExtra("productID", productID);
                intent.putExtra("productDetails", productDetails);
                intent.putExtra("productName", productName);
                intent.putExtra("allComplaintsString", allComplaintsString);
                intent.putExtra("complaintType", complaintType);
                intent.putExtra("userName", userName);
                startActivity(intent);
            }
            else
            {
                Intent intent;
                intent = new Intent(getApplicationContext(), SolutionsActivity.class);
                intent.putExtra("productID", productID);
                intent.putExtra("productDetails", productDetails);
                intent.putExtra("productName", productName);
                intent.putExtra("allComplaintsString", allComplaintsString);
                intent.putExtra("complaintType", complaintType);
                intent.putExtra("userName", userName);
                startActivity(intent);
            }
        }
    }
}
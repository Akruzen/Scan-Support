package com.example.scanelectronicsystems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;

public class ComplaintTypeActivity extends AppCompatActivity {

    ListView complaintListView;
    TextView productNameTextView;
    ArrayList<String> complaintArrayList = new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    String productID = "";
    String productDetails = "";
    String productName = "";
    String userName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_type);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();

        complaintListView = findViewById(R.id.complaintTypeListView);
        productNameTextView = findViewById(R.id.productNameTextView);

        Intent intent = getIntent();
        productID = intent.getStringExtra("productID");
        productDetails = intent.getStringExtra("productDetails");
        productName = intent.getStringExtra("productName");
        userName = intent.getStringExtra("userName");
        productNameTextView.setText(productName);

        if (!productID.equals("50") && !productID.equals("51")) {
            complaintArrayList.add("Hardware Complaint");
        }
        complaintArrayList.add("Software Complaint");

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, complaintArrayList);
        complaintListView.setAdapter(arrayAdapter);

        complaintListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent;
                intent = new Intent(getApplicationContext(), ComplaintsActivity.class);
                intent.putExtra("productID", productID);
                intent.putExtra("productDetails", productDetails);
                intent.putExtra("productName", productName);
                intent.putExtra("userName", userName);
                if (productID.equals("50") || productID.equals("51"))
                {
                    intent.putExtra("complaintType", 1);
                }
                else
                {
                    intent.putExtra("complaintType", i);
                }
                startActivity(intent);
            }
        });

    }
}
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

import java.util.ArrayList;

public class ProductSub2MenuActivity extends AppCompatActivity {

    TextView productSub2HeadTextView;
    ListView productSub2MenuListView;
    ArrayList<String> productSub2MenuArrayList = new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    String userName;

    public void aboutUs(View view)
    {
        Intent intent = new Intent(getApplicationContext(), AboutUsActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_sub2_menu);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();

        productSub2HeadTextView = findViewById(R.id.productSub2HeadTextView);
        productSub2MenuListView = findViewById(R.id.productListView);

        Intent intent = getIntent();
        int item = intent.getIntExtra("item", 0);
        userName = intent.getStringExtra("userName");
        if (item == 0)
        {
            productSub2HeadTextView.setText("Digital Process Indicator Controller");
            productSub2MenuArrayList.add("1. DPC965M - 96x96mm Front Bezel");
            productSub2MenuArrayList.add("2. DPC9648 - 48x96mm Front Bezel");
        }
        else if (item == 1)
        {
            productSub2HeadTextView.setText("Flow rate Indicator Totalizer");
            productSub2MenuArrayList.add("1. FIT - 96x96mm Front Bezel with mA input");
            productSub2MenuArrayList.add("2. FIT - 96x96mm Front Bezel with pulse input");
            productSub2MenuArrayList.add("3. FIT - 48x96mm Front Bezel with mA input");
            productSub2MenuArrayList.add("4. MFM 393 - Mass Flow Computer");
            productSub2MenuArrayList.add("5. NHM 393 - Net Heat Meter");
        }

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, productSub2MenuArrayList);
        productSub2MenuListView.setAdapter(arrayAdapter);

        productSub2MenuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent;
                String title = productSub2HeadTextView.getText().toString();

                switch (title)
                {
                    case "Digital Process Indicator Controller":
                        {
                            switch (i)
                            {
                                case 0:
                                    intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                    intent.putExtra("productID", "100");    // Digits represent 1st item of 1st Menu and 0th item of 2nd Menu and 0th item of third Menu
                                    intent.putExtra("userName", userName);
                                    startActivity(intent);
                                    break;
                                case 1:
                                    intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                    intent.putExtra("productID", "101");
                                    intent.putExtra("userName", userName);
                                    startActivity(intent);
                                    break;
                            }
                        }
                    break;
                    case "Flow rate Indicator Totalizer":
                    {
                        switch (i)
                        {
                            case 0:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "110");    // Digits represent 1st item of 1st Menu and 0th item of 2nd Menu and 0th item of third Menu
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 1:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "111");    // Digits represent 1st item of 1st Menu and 0th item of 2nd Menu and 0th item of third Menu
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 2:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "112");    // Digits represent 1st item of 1st Menu and 0th item of 2nd Menu and 0th item of third Menu
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 3:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "113");    // Digits represent 1st item of 1st Menu and 0th item of 2nd Menu and 0th item of third Menu
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 4:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "114");    // Digits represent 1st item of 1st Menu and 0th item of 2nd Menu and 0th item of third Menu
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                        }
                    }
                    break;
                }

            }
        });

    }
}
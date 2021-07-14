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

public class ProductSub1MenuActivity extends AppCompatActivity {

    TextView productSub1HeadTextView;
    ListView productSub1MenuListView;
    ArrayList<String> productSub1MenuArrayList = new ArrayList<String>();
    ArrayAdapter arrayAdapter;

    public void aboutUs(View view)
    {
        Intent intent = new Intent(getApplicationContext(), AboutUsActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_sub1_menu);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();

        productSub1HeadTextView = findViewById(R.id.productSub1HeadTextView);
        productSub1MenuListView = findViewById(R.id.productListView);

        Intent intent = getIntent();
        int item = intent.getIntExtra("item", 0);
        String userName = intent.getStringExtra("userName");
        switch (item)
        {
            case 0:
                productSub1HeadTextView.setText("Data Loggers");
                productSub1MenuArrayList.add("1. Uniscan3200 - 32 channel Universal Input Datalogger");
                productSub1MenuArrayList.add("2. F1600DL - 4 to 16 channel Datalogger");
                productSub1MenuArrayList.add("3. DL001 - Single Channel Datalogger");
                productSub1MenuArrayList.add("4. FIT DL - Flow rate Indicator Totaliser (Totalizer) datalogger");
                productSub1MenuArrayList.add("5. DLP200 - 2 channel dl - Flow rate + Line Pressure + Totaliser (Totalizer)");
                productSub1MenuArrayList.add("6. Battery operated - button loggers, USB logger");
                break;
            case 1:
                productSub1HeadTextView.setText("Indicator Controller");
                productSub1MenuArrayList.add("1. Digital Process Indicator Controller");
                productSub1MenuArrayList.add("2. Flow rate Indicator Totalizer (Totalizer)");
                break;
            case 2:
                productSub1HeadTextView.setText("Multi Channel Scanner");
                productSub1MenuArrayList.add("1. Falcon 1600 - 4 to 16 channel process scanner");
                productSub1MenuArrayList.add("2. Falcon 444 - 4 channel scanner with 4 digital inputs and 4 digital outputs");
                break;
            case 3:
                productSub1HeadTextView.setText("Serial Communication Product");
                productSub1MenuArrayList.add("1. RS232-RS485 converter");
                productSub1MenuArrayList.add("2. RS485/RS485 repeater");
                productSub1MenuArrayList.add("3. RS232 Isolator");
                productSub1MenuArrayList.add("4. RS232/RS485 - Ethernet converter");
                productSub1MenuArrayList.add("5. HART - RS232/RS485 converter");
                productSub1MenuArrayList.add("6. HART - RS232/485 Gateway");
                productSub1MenuArrayList.add("7. Gateway - MODBUS RTU to MODBUS TCPIP");
                break;
            case 4:
                productSub1HeadTextView.setText("SCADA Modules");
                productSub1MenuArrayList.add("1. Falcon Mini");
                productSub1MenuArrayList.add("2. Falcon 100");
                productSub1MenuArrayList.add("3. Falcon DIDO24");
                productSub1MenuArrayList.add("4. Falcon 1600");
                productSub1MenuArrayList.add("5. Falcon 444");
                productSub1MenuArrayList.add("6. Falcon 148");
                productSub1MenuArrayList.add("7. SDC 9648");
                break;
            case 5:
                productSub1HeadTextView.setText("SCADA Softwares");
                productSub1MenuArrayList.add("1. Falcon");
                productSub1MenuArrayList.add("2. Proficy iFix SCADA");
                break;
            case 6:
                productSub1HeadTextView.setText("Analog Isolators and Transmitters");
                productSub1MenuArrayList.add("1. Analog Isolators and Transmitters");
                productSub1MenuArrayList.add("2. Auto / Manual Station");
                productSub1MenuArrayList.add("3. Loadcell Amplifier");
                break;
            case 7:
                productSub1HeadTextView.setText("Sensors");
                productSub1MenuArrayList.add("1. Temperature-Humidity-Pressure sensors");
                break;
            case 8:
                productSub1HeadTextView.setText("Calibrator");
                productSub1MenuArrayList.add("1. Battery operated with indication");
                productSub1MenuArrayList.add("2. Mains Operated with indication");
                break;

        }

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, productSub1MenuArrayList);
        productSub1MenuListView.setAdapter(arrayAdapter);

        productSub1MenuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent;
                String title = productSub1HeadTextView.getText().toString();

                switch (title)
                {
                    case "Data Loggers":    // 0*
                    {
                        switch (i)
                        {
                            case 0:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "00");    // Digits represent 0th item of 1st Menu and 0th item of 2nd Menu
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 1:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "01");    // Digits represent 0th item of 1st Menu and 1st item of 2nd Menu
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 2:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "02");
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 3:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "03");    // Digits represent 0th item of 1st Menu and 1st item of 2nd Menu
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 4:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "04");    // Digits represent 0th item of 1st Menu and 1st item of 2nd Menu
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 5:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "05");    // Digits represent 0th item of 1st Menu and 1st item of 2nd Menu
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;

                        }
                    }
                    break;

                    case "Indicator Controller":    // 1*
                    {
                        switch (i)
                        {
                            case 0:
                                intent = new Intent(getApplicationContext(), ProductSub2MenuActivity.class);
                                intent.putExtra("item", 0);
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 1:
                                intent = new Intent(getApplicationContext(), ProductSub2MenuActivity.class);
                                intent.putExtra("item", 1);
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                        }
                    }
                    break;

                    case "Multi Channel Scanner":   // 2*
                    {
                        switch (i)
                        {
                            case 0:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "20");
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 1:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "21");    // Digits represent 0th item of 1st Menu and 0th item of 2nd Menu
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                        }
                    }
                    break;

                    case "Serial Communication Product":    // 3*
                    {
                        switch (i)
                        {
                            case 0:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "30");
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 1:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "31");
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 2:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "32");
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 3:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "33");
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 4:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "34");
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 5:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "35");
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 6:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "36");
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                        }
                    }
                    break;

                    case "SCADA Modules":   // 4*
                    {
                        switch(i)
                        {
                            case 0:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "40");
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 1:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "41");
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 2:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "42");
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 3:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "43");
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 4:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "44");
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 5:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "45");
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 6:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "46");
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                        }
                    }
                    break;

                    case "SCADA Softwares": // 5*
                    {
                        switch (i)
                        {
                            case 0:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "50");
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 1:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "51");    // Digits represent 0th item of 1st Menu and 0th item of 2nd Menu
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                        }
                    }
                    break;

                    case "Analog Isolators and Transmitters":   // 6*
                    {
                        switch (i)
                        {
                            case 0:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "60");
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 1:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "61");
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 2:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "62");
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                        }
                    }
                    break;

                    case "Sensors":     // 7*
                    {
                        switch (i)
                        {
                            case 0:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "70");
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                        }
                    }
                    break;

                    case "Calibrator":  // 8*
                    {
                        switch (i)
                        {
                            case 0:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "80");
                                intent.putExtra("userName", userName);
                                startActivity(intent);
                                break;
                            case 1:
                                intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("productID", "81");    // Digits represent 0th item of 1st Menu and 0th item of 2nd Menu
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
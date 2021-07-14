package com.example.scanelectronicsystems;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

public class MainActivity extends AppCompatActivity {

    ListView productListView;
    TextView welcomeTextView;
    ArrayList<String> productArrayList = new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    FloatingActionButton settingsActionButton;
    FloatingActionButton aboutUsButton;
    SharedPreferences sharedPreferences;
    String userName;
    private static final String SHOWCASE_ID = "Sequence Showcase";

    private void showTutorSequence(int millis) {

        ShowcaseConfig config = new ShowcaseConfig(); //create the showcase config
        config.setDelay(millis); //set the delay of each sequence using millis variable

        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(this, SHOWCASE_ID); // create the material showcase sequence

        sequence.setOnItemShownListener(new MaterialShowcaseSequence.OnSequenceItemShownListener() {
            @Override
            public void onShow(MaterialShowcaseView itemView, int position) {
                Log.i("introStatus", "Item #" + position);
            }
        }); // set the listener of the sequence order to know we are in which position

        sequence.setConfig(config); //set the showcase config to the sequence.

        sequence.addSequenceItem(settingsActionButton, "You can adjust the settings from here.", "OK"); // add view for the first sequence, in this case it is a button.

        sequence.addSequenceItem(
                new MaterialShowcaseView.Builder(this)
                        .setTarget(aboutUsButton)
                        .setDismissText("OK")
                        .setContentText("Know more about the company by tapping here.")
                        .build()
        ); // add view for the second sequence, in this case it is a textview.

        sequence.start(); //start the sequence showcase

    }


    public void aboutUs(View view)
    {
        Intent intent = new Intent(getApplicationContext(), AboutUsActivity.class);
        startActivity(intent);
    }

    public void settingsButton(View view) { alertDialog(MainActivity.this); }

    private void alertDialog(Context context)
    {
        final EditText nameEditText = new EditText(context);
        nameEditText.setHint("Type here...");
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle("Settings")
                .setMessage("Update your name: ")
                .setView(nameEditText)
                .setPositiveButton("SET", null)
                .setNegativeButton("CANCEL", null)
                .create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (nameEditText.getText().toString().matches(""))
                        {
                            Toast.makeText(context, "This field cannot be left blank.", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            userName = nameEditText.getText().toString();
                            welcomeTextView.setText("Welcome " + userName);
                            sharedPreferences.edit().putString("userName", userName).apply();
                            Toast.makeText(context, "Name updated to " + userName, Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }
                });
            }
        });
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();

        sharedPreferences = this.getSharedPreferences("com.example.scanelectronicsystems", Context.MODE_PRIVATE);
        userName = sharedPreferences.getString("userName", "Default User");

        productListView = findViewById(R.id.productListView);
        settingsActionButton = findViewById(R.id.floatingActionButton5);
        welcomeTextView = findViewById(R.id.welcomeTextView);
        aboutUsButton = findViewById(R.id.floatingActionButton);

        welcomeTextView.setText("Welcome " + userName);

        productArrayList.add("1. Data Loggers");
        productArrayList.add("2. Indicator Controller");
        productArrayList.add("3. Multi Channel Scanner");
        productArrayList.add("4. Serial Communication Product");
        productArrayList.add("5. SCADA Modules");
        productArrayList.add("6. SCADA Softwares");
        productArrayList.add("7. Analog Isolators / Transmitters");
        productArrayList.add("8. Sensors");
        productArrayList.add("9. Calibrator");

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, productArrayList);
        productListView.setAdapter(arrayAdapter);


        showTutorSequence(500);

        productListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;

                intent = new Intent(getApplicationContext(), ProductSub1MenuActivity.class);
                intent.putExtra("item", i);
                intent.putExtra("userName", userName);
                startActivity(intent);

            }
        });

    }
}
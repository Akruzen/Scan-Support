package com.example.scanelectronicsystems;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SolutionsActivity extends AppCompatActivity {

    String userName;
    String productID;
    String productDetails;
    String productName;
    String allComplaintsString = "";
    int complaintType;
    TextView productNameTextView;
    boolean fieldsAreEmpty;

    String buttonID;
    String videoURLClicked;
    String videoURL1 = "", videoURL2 = "", videoURL3 = "", videoURL4 = "", videoURL5 = "", videoURL6 = "", videoURL7 = "", videoURL8 = "",
            videoURL9 = "", videoURL10 = "", videoURL11 = "http://www.google.co.in";
    TextView complaint1, complaint2, complaint3, complaint4, complaint5, complaint6, complaint7, complaint8, complaint9, complaint10, complaint11;
    Button videoButton1, videoButton2, videoButton3, videoButton4, videoButton5, videoButton6, videoButton7, videoButton8, videoButton9, videoButton10, videoButton11;
    TextView solution1, solution2, solution3, solution4, solution5, solution6, solution7, solution8, solution9, solution10, solution11;
    ImageView seperator1, seperator2, seperator3, seperator4, seperator5, seperator6, seperator7, seperator8, seperator9, seperator10, seperator11;

    /* INFORMATION REGARDING PRODUCT ID AND COMPLAINTS */
    /*
    i) Product IDs:
        0) Data Loggers
            00: Uniscan 3200
            01: Falcon 1600 DL - 4 to 16 Channel Data Logger
            02: Data Logger 001 - Single Channel Data Logger
            03: FIT DL - Flow rate indicator totalizer Data Logger
            04: DLP 200 - 2 Channel Data Logger - Flow rate + Line Pressure + Totalizer
            05: Battery Operated Loggers

        1) Indicator Controller
            0) Digital Process Indicator Controller
                100: DPC965M - 96 x 96 mm front Bezel
                101: DPC9648 - 48 x 96 mm Front Bezel
            1) Flow rate indicator totalizer
                110: FIT - 96 x 96 mm Front Bezel with mA input
                111: FIT - 96 x 96 mm Front Bezel with pulse input
                112: FIT - 48 x 96 mm Front Bezel with mA input
                113: MFM 393 - Mass flow computer
                114: NHM 393 - Net heat meter

        2) Multichannel Scanner
            20: Falcon 1600 - 4 to 16 channel process scanner
            21: Falcon 444 - 4 channel scanner with 4 digital inputs and 4 digital outputs

        3) Serial communication product
            30: RS232 to RS485 converter
            31: RS485/RS485 Repeater
            32: RS232 Isolator
            33: RS232/RS485 - Ethernet Converter
            34: HART - RS232/RS485 Converter
            35: HART - RS232/485 Gateway
            36: Gateway - MODBUS RTU to MODBUS TCPIP

        4) SCADA Modules
            40: Falcon Mini
            41: Falcon 100
            42: Falcon DIDO24
            43: Falcon 1600
            44: Falcon 444
            45: Falcon 148
            46: SDC 9648

        5) SCADA Softwares
            50: Falcon
            51: Proficy iFix SCADA

        6) Analog Isolators / Transmitters
            60: Analog Isolators and Transmitters
            61: Auto / Manual Station
            62: Loadcell Amplifier

        7) Sensors
            70: Temperature-Humidity-Pressure Sensors

        8) Calibrator
            80: Battery Operated with Indication
            81: Mains operated with indication

    ii) Complaints:
        0) Hardware Complaints:
            0: No powerOn
     */

    // Method for opening a URL
    public void openWebURL (String inURL)
    {
        if (inURL != null)
        {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(inURL));
            startActivity(browserIntent);
        }
        else
        {
            Toast.makeText(this, "The URL string is null.", Toast.LENGTH_SHORT).show();
        }

    }

    // Method that determines which button is clicked
    public void videoButtonClicked (View view)
    {
        try
        {
            int buttonIDint = view.getId();    // Gets the button's ID which is integer
            buttonID = view.getResources().getResourceEntryName(buttonIDint);  // Converts that integer id into actual ID you have given viz. a string
            switch (buttonID) {
                case "videoButton1":
                    videoURLClicked = videoURL1;
                    break;
                case "videoButton2":
                    videoURLClicked = videoURL2;
                    break;
                case "videoButton3":
                    videoURLClicked = videoURL3;
                    break;
                case "videoButton4":
                    videoURLClicked = videoURL4;
                    break;
                case "videoButton5":
                    videoURLClicked = videoURL5;
                    break;
                case "videoButton6":
                    videoURLClicked = videoURL6;
                    break;
                case "videoButton7":
                    videoURLClicked = videoURL7;
                    break;
                case "videoButton8":
                    videoURLClicked = videoURL8;
                    break;
                case "videoButton9":
                    videoURLClicked = videoURL9;
                    break;
                case "videoButton10":
                    videoURLClicked = videoURL10;
                    break;
                case "videoButton11":
                    videoURLClicked = videoURL11;
                    break;

            }
            openWebURL(videoURLClicked);
        }
        catch (Exception e)
        {
            Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
        }

    }

    // Method in which all the findViewByIDs are written
    public void declaration() {
        complaint1 = findViewById(R.id.complaint1);
        solution1 = findViewById(R.id.solution1);
        videoButton1 = findViewById(R.id.videoButton1);
        seperator1 = findViewById(R.id.seperator1);

        complaint2 = findViewById(R.id.complaint2);
        solution2 = findViewById(R.id.solution2);
        videoButton2 = findViewById(R.id.videoButton2);
        seperator2 = findViewById(R.id.seperator2);

        complaint3 = findViewById(R.id.complaint3);
        solution3 = findViewById(R.id.solution3);
        videoButton3 = findViewById(R.id.videoButton3);
        seperator3 = findViewById(R.id.seperator3);

        complaint4 = findViewById(R.id.complaint4);
        solution4 = findViewById(R.id.solution4);
        videoButton4 = findViewById(R.id.videoButton4);
        seperator4 = findViewById(R.id.seperator4);

        complaint5 = findViewById(R.id.complaint5);
        solution5 = findViewById(R.id.solution5);
        videoButton5 = findViewById(R.id.videoButton5);
        seperator5 = findViewById(R.id.seperator5);

        complaint6 = findViewById(R.id.complaint6);
        solution6 = findViewById(R.id.solution6);
        videoButton6 = findViewById(R.id.videoButton6);
        seperator6 = findViewById(R.id.seperator6);

        complaint7 = findViewById(R.id.complaint7);
        solution7 = findViewById(R.id.solution7);
        videoButton7 = findViewById(R.id.videoButton7);
        seperator7 = findViewById(R.id.seperator7);

        complaint8 = findViewById(R.id.complaint8);
        solution8 = findViewById(R.id.solution8);
        videoButton8 = findViewById(R.id.videoButton8);
        seperator8 = findViewById(R.id.seperator8);

        complaint9 = findViewById(R.id.complaint9);
        solution9 = findViewById(R.id.solution9);
        videoButton9 = findViewById(R.id.videoButton9);
        seperator9 = findViewById(R.id.seperator9);

        complaint10 = findViewById(R.id.complaint10);
        solution10 = findViewById(R.id.solution10);
        videoButton10 = findViewById(R.id.videoButton10);
        seperator10 = findViewById(R.id.seperator10);

        complaint11 = findViewById(R.id.complaint11);
        solution11 = findViewById(R.id.solution11);
        videoButton11 = findViewById(R.id.videoButton11);
        seperator11 = findViewById(R.id.seperator11);
    }

    // Sets the solution texts to the appropriate text boxes
    @SuppressLint("SetTextI18n")
    public void setSolutions()
    {
        // Hardware Solutions
        if (complaintType == 0)
        {
            switch (productID)
            {
                case "01": // Falcon 1600 DL
                    solution1.setText("A) Check the supply at source. It must be 220VAC ± 10% or if you have ordered for 110VAC supply then 110VAC ±10%.\n\n" +
                            "B) Replace fuse and check continuity between Live-Neutral. If it is less than 10ohm then input section of power supply is short. Send unit for repairs.\n\n" +
                            "C) Confirm whether fuse is of proper rating.");
                    videoURL1 = "http://youtu.be/grPzhqakNho"; // Set video URL for this particular problem here

                    solution2.setText("A) Check the supply at source. It must be 220VAC ± 10% or if you have ordered for 110VAC supply then 110VAC ±10%.\n\n" +
                            "B) Replace fuse and check continuity between Live-Neutral. If it is less than 10ohm then input section of power supply is short. Send unit for repairs.\n\n" +
                            "C) Confirm if fuse rating is ok. Else send unit for repairs.");
                    videoURL2 = "http://youtu.be/grPzhqakNho";
                    break;

                case "43": // Falcon 1600
                    solution1.setText("A) Check the supply at source. It must be 220VAC ± 10% or if you have ordered for 110VAC supply then 110VAC ±10%.\n\n" +
                            "B) Replace fuse and check continuity between Live-Neutral. If it is less than 10ohm then input section of power supply is short. Send unit for repairs.\n\n" +
                            "C) Confirm whether fuse is of proper rating.");

            }
        }
        // Software Complaints
        else
        {
            // Switch case will go here.
        }

    }

    // This method shows the otherwise hidden text views according to product selected
    public void showTexts() {
        if (complaintType == 1) {
            String complaint = "";
            if (allComplaintsString.contains("Installation problem")) {
                complaint = "Installation problem";
                complaint1.setVisibility(View.VISIBLE);
                complaint1.setText(complaint);
                solution1.setVisibility(View.VISIBLE);
                videoButton1.setVisibility(View.VISIBLE);
                seperator1.setVisibility(View.VISIBLE);
            }
            if (allComplaintsString.contains("Key or Hardware lock not found")) {
                complaint = "Key or Hardware lock not found";
                complaint2.setVisibility(View.VISIBLE);
                complaint2.setText(complaint);
                solution2.setVisibility(View.VISIBLE);
                videoButton2.setVisibility(View.VISIBLE);
                seperator2.setVisibility(View.VISIBLE);
            }
            if (allComplaintsString.contains("RUN problem from Icon")) {
                complaint = "RUN problem from Icon";
                complaint3.setVisibility(View.VISIBLE);
                complaint3.setText(complaint);
                solution3.setVisibility(View.VISIBLE);
                videoButton3.setVisibility(View.VISIBLE);
                seperator3.setVisibility(View.VISIBLE);
            }
            if (allComplaintsString.contains("Communication error")) {
                complaint = "Communication error";
                complaint4.setVisibility(View.VISIBLE);
                complaint4.setText(complaint);
                solution4.setVisibility(View.VISIBLE);
                videoButton4.setVisibility(View.VISIBLE);
                seperator4.setVisibility(View.VISIBLE);
            }
            if (allComplaintsString.contains("Runtime Error")) {
                complaint = "Runtime Error";
                complaint5.setVisibility(View.VISIBLE);
                complaint5.setText(complaint);
                solution5.setVisibility(View.VISIBLE);
                videoButton5.setVisibility(View.VISIBLE);
                seperator5.setVisibility(View.VISIBLE);
            }
            if (allComplaintsString.contains("Report error")) {
                complaint = "Report error";
                complaint6.setVisibility(View.VISIBLE);
                complaint6.setText(complaint);
                solution6.setVisibility(View.VISIBLE);
                videoButton6.setVisibility(View.VISIBLE);
                seperator6.setVisibility(View.VISIBLE);
            }
            if (allComplaintsString.contains("Blank Graph")) {
                complaint = "Blank Graph";
                complaint7.setVisibility(View.VISIBLE);
                complaint7.setText(complaint);
                solution7.setVisibility(View.VISIBLE);
                videoButton7.setVisibility(View.VISIBLE);
                seperator7.setVisibility(View.VISIBLE);
            }
            if (allComplaintsString.contains("Does not show History")) {
                complaint = "Does not show History";
                complaint8.setVisibility(View.VISIBLE);
                complaint8.setText(complaint);
                solution8.setVisibility(View.VISIBLE);
                videoButton8.setVisibility(View.VISIBLE);
                seperator8.setVisibility(View.VISIBLE);
            }
            if (allComplaintsString.contains("Tag value not displayed or incorrect")) {
                complaint = "Tag value not displayed or incorrect";
                complaint9.setVisibility(View.VISIBLE);
                complaint9.setText(complaint);
                solution9.setVisibility(View.VISIBLE);
                videoButton9.setVisibility(View.VISIBLE);
                seperator9.setVisibility(View.VISIBLE);
            }

        } else if (complaintType == 0) {
            String complaint = "";
            if (allComplaintsString.contains("No Power ON or Fuse Blowing")) {
                complaint = "No Power ON or Fuse Blowing";
                complaint1.setVisibility(View.VISIBLE);
                complaint1.setText(complaint);
                solution1.setVisibility(View.VISIBLE);
                videoButton1.setVisibility(View.VISIBLE);
                seperator1.setVisibility(View.VISIBLE);
            }
            if (allComplaintsString.contains("Display Blank")) {
                complaint = "Display Blank";
                complaint2.setVisibility(View.VISIBLE);
                complaint2.setText(complaint);
                solution2.setVisibility(View.VISIBLE);
                videoButton2.setVisibility(View.VISIBLE);
                seperator2.setVisibility(View.VISIBLE);
            }
            if (allComplaintsString.contains("Unit Hangs or Resets")) {
                complaint = "Unit Hangs or Resets";
                complaint3.setVisibility(View.VISIBLE);
                complaint3.setText(complaint);
                solution3.setVisibility(View.VISIBLE);
                videoButton3.setVisibility(View.VISIBLE);
                seperator3.setVisibility(View.VISIBLE);
            }
            if (allComplaintsString.contains("Memory Corrupt - No Backup")) {
                complaint = "Memory Corrupt - No Backup";
                complaint4.setVisibility(View.VISIBLE);
                complaint4.setText(complaint);
                solution4.setVisibility(View.VISIBLE);
                videoButton4.setVisibility(View.VISIBLE);
                seperator4.setVisibility(View.VISIBLE);
            }
            if (allComplaintsString.contains("Settings not stored")) {
                complaint = "Settings not stored";
                complaint5.setVisibility(View.VISIBLE);
                complaint5.setText(complaint);
                solution5.setVisibility(View.VISIBLE);
                videoButton5.setVisibility(View.VISIBLE);
                seperator5.setVisibility(View.VISIBLE);
            }
            if (allComplaintsString.contains("No Communication")) {
                complaint = "No Communication";
                complaint6.setVisibility(View.VISIBLE);
                complaint6.setText(complaint);
                solution6.setVisibility(View.VISIBLE);
                videoButton6.setVisibility(View.VISIBLE);
                seperator6.setVisibility(View.VISIBLE);
            }
            if (allComplaintsString.contains("Printer port not working")) {
                complaint = "Printer port not working";
                complaint7.setVisibility(View.VISIBLE);
                complaint7.setText(complaint);
                solution7.setVisibility(View.VISIBLE);
                videoButton7.setVisibility(View.VISIBLE);
                seperator7.setVisibility(View.VISIBLE);
            }
            if (allComplaintsString.contains("No data in Serial Transfer")) {
                complaint = "No data in Serial Transfer";
                complaint8.setVisibility(View.VISIBLE);
                complaint8.setText(complaint);
                solution8.setVisibility(View.VISIBLE);
                videoButton8.setVisibility(View.VISIBLE);
                seperator8.setVisibility(View.VISIBLE);
            }
            if (allComplaintsString.contains("Input not displayed properly")) {
                complaint = "Input not displayed properly";
                complaint9.setVisibility(View.VISIBLE);
                complaint9.setText(complaint);
                solution9.setVisibility(View.VISIBLE);
                videoButton9.setVisibility(View.VISIBLE);
                seperator9.setVisibility(View.VISIBLE);
            }
            if (allComplaintsString.contains("OPEN displayed even if field input is present")) {
                complaint = "OPEN displayed even if field input is present";
                complaint10.setVisibility(View.VISIBLE);
                complaint10.setText(complaint);
                solution10.setVisibility(View.VISIBLE);
                videoButton10.setVisibility(View.VISIBLE);
                seperator10.setVisibility(View.VISIBLE);
            }
            if (allComplaintsString.contains("Unit received in damaged condition")) {
                complaint = "Unit received in damaged condition";
                complaint11.setVisibility(View.VISIBLE);
                complaint11.setText(complaint);
                solution11.setVisibility(View.VISIBLE);
                videoButton11.setVisibility(View.VISIBLE);
                seperator11.setVisibility(View.VISIBLE);
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solutions);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();

        fieldsAreEmpty = false;
        declaration();
        productNameTextView = findViewById(R.id.productNameTextView5);

        Intent intent = getIntent();
        productID = intent.getStringExtra("productID");
        productDetails = intent.getStringExtra("productDetails");
        productName = intent.getStringExtra("productName");
        allComplaintsString = intent.getStringExtra("allComplaintsString");
        complaintType = intent.getIntExtra("complaintType", 1);
        userName = intent.getStringExtra("userName");

        productNameTextView.setText(productName);

        showTexts();
        setSolutions();
        Toast.makeText(this, complaintType + "", Toast.LENGTH_SHORT).show();

    /*public void nextClick(View view)
    {
        fieldsAreEmpty = false;
        observations = "";
        observationsCompiler(complaint1, comment1);
        observationsCompiler(complaint2, comment2);
        observationsCompiler(complaint3, comment3);
        observationsCompiler(complaint4, comment4);
        observationsCompiler(complaint5, comment5);
        observationsCompiler(complaint6, comment6);
        observationsCompiler(complaint7, comment7);
        observationsCompiler(complaint8, comment8);
        observationsCompiler(complaint9, comment9);
        observationsCompiler(complaint10, comment10);
        observationsCompiler(complaint11, comment11);

        if (!fieldsAreEmpty)
        {
            allComplaintsString = allComplaintsString + "\n" + observations;
            Intent intent;
            intent = new Intent(getApplicationContext(), ReviewFinalActivity.class);
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
            Toast.makeText(this, "All fields are compulsory.", Toast.LENGTH_SHORT).show();
        }
    }*/
    }

}
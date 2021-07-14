package com.example.scanelectronicsystems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

public class ReviewFinalActivity extends AppCompatActivity {

    TextView overviewTextView1;
    TextView titleTextView;
    TextView productNameTextView;
    Button submitButton;
    String productID;
    String productDetails;
    String productName;
    String allComplaintsString;
    String allDetailsString;
    String userName;
    String currentDate;
    String currentTime;
    int currentMonth;
    int currentYear;
    String complaintNumber;
    SharedPreferences sharedPreferences;
    private static final String SHOWCASE_ID = "Simple Showcase";

    private void showTutor(int millis){
        new MaterialShowcaseView.Builder(this) // instantiate the material showcase view using Builder
                .setTarget(submitButton) // set what view will be pointed or highlighted
                .setTitleText("Submit Button") // set the title of the tutorial
                .setDismissText("OK") // set the dismiss text
                .setContentText("Tap here after reviewing to submit the complaint.") // set the content or detail text
                .setDelay(millis) // set delay in milliseconds to show the tutor
                .singleUse(SHOWCASE_ID) // set the single use so it is shown only once using our create SHOWCASE_ID constant
                .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_final);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();

        overviewTextView1 = findViewById(R.id.overviewTextView1);
        titleTextView = findViewById(R.id.titleTextView);
        productNameTextView = findViewById(R.id.productNameTextView4);
        submitButton = findViewById(R.id.nextButton2);

        sharedPreferences = this.getSharedPreferences("com.example.scanelectronicsystems", Context.MODE_PRIVATE);
        complaintNumber = sharedPreferences.getString("complaintNumber", "0");

        productID = "";
        productDetails = "";
        productName = "";
        allComplaintsString = "";
        userName = "";

        Intent intent = getIntent();
        productID = intent.getStringExtra("productID");
        productDetails = intent.getStringExtra("productDetails");
        productName = intent.getStringExtra("productName");
        allComplaintsString = intent.getStringExtra("allComplaintsString");
        userName = intent.getStringExtra("userName");

        allDetailsString = productDetails + "\n" + "Complaints:\n" + allComplaintsString + "\n" + "Addressed by: " + userName;

        titleTextView.setText("Product: " + productName);
        productNameTextView.setText(productName);
        overviewTextView1.setText(allDetailsString);

        showTutor(500);

    }

    public void submitComplaint(View view)
    {
        complaintNumber = String.valueOf(Integer.parseInt(complaintNumber) + 1);
        sharedPreferences.edit().putString("complaintNumber", complaintNumber).apply();
        Calendar calendar = Calendar.getInstance();
        currentMonth = calendar.get(Calendar.MONTH) + 1;
        currentYear = calendar.get(Calendar.YEAR);
        currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("plain/text");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] {"omkarphadke27@gmail.com;support@scanelectronicsystems.com;scanproject64@gmail.com"});
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, ("Customer Complaint - " + userName + " - " + currentMonth + currentYear + " - " + complaintNumber));
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                "Hello Sir,\nHere are the details of the complaint.\n\n"
                        + "Product: " + productName + "\n" + allDetailsString
                        + "\n" + "on " + currentDate + " at " + currentTime
                        + "\n" + "Complaint Number: " + currentMonth + currentYear + " - " + complaintNumber);
        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
    }

}
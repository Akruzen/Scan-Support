package com.example.scanelectronicsystems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProductDetailsActivity extends AppCompatActivity {

    TextView productDetailsTextView;
    TextView productLabel;
    ImageView productImageView;
    String productName;
    String productDetails;
    String productID = "";

    /* ---------- Declaring Edit Texts and their respt Strings ----------- */

    EditText srNoEditText;
    String userName;
    String srNo;
    EditText contactPersonEditText;
    String contactPerson;
    EditText designationEditText;
    String designation;
    EditText companyEditText;
    String company;
    EditText emailEditText;
    String email;
    EditText phoneEditText;
    String phone;

    /* ---------- End of Declaring Edit Texts and their respt Strings ----------- */

    boolean allFieldsAreEmpty = true;
    boolean someFieldsAreEmpty = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();

        productDetailsTextView = findViewById(R.id.productDetailsHeadTextView);
        productLabel = findViewById(R.id.productLabel);
        productImageView = findViewById(R.id.productImageView);

        /* ---------- Linking Edit Texts ----------- */

        srNoEditText = findViewById(R.id.srNoEditText);
        contactPersonEditText = findViewById(R.id.contactPersonEditText);
        designationEditText = findViewById(R.id.designationEditText);
        companyEditText = findViewById(R.id.companyEditText);
        emailEditText = findViewById(R.id.emailEditText);
        phoneEditText = findViewById(R.id.phoneEditText);

        /* ---------- End of Linking Edit Texts ----------- */

        Intent intent = getIntent();
        productID = intent.getStringExtra("productID");
        userName = intent.getStringExtra("userName");
        productName = "";
        switch (productID)
        {
            case "00":
                productName = "Uniscan 3200";
                productImageView.setImageResource(R.drawable.uniscan3200);
                break;
            case "01":
                productName = "Falcon 1600 DL";
                productImageView.setImageResource(R.drawable.f1600dl);
                break;
            case "02":
                productName = "DL 001";
                productImageView.setImageResource(R.drawable.dl001);
                break;
            case "03":
                productName = "FIT DL";
                productImageView.setImageResource(R.drawable.fitdl);
                break;
            case "04":
                productName = "DLP 200";
                productImageView.setImageResource(R.drawable.dlp200);
                break;
            case "05":
                productName = "Battery Operated";
                productImageView.setImageResource(R.drawable.battery_operated);
                break;
            case "100":
                productName = "DPC 965M";
                productImageView.setImageResource(R.drawable.dpc965m);
                break;
            case "101":
                productName = "DPC 9648";
                productImageView.setImageResource(R.drawable.dpc9648);
                break;
            case "110":
                productName = "FIT 96x96mm mA Input";
                productImageView.setImageResource(R.drawable.fit9696mi);
                break;
            case "111":
                productName = "FIT 96x96mm Pulse Input";
                productImageView.setImageResource(R.drawable.fit9696pi);
                break;
            case "112":
                productName = "FIT 48x96mm mA Input";
                productImageView.setImageResource(R.drawable.fit4896mi);
                break;
            case "113":
                productName = "MFM 393";
                productImageView.setImageResource(R.drawable.mfm393);
                break;
            case "114":
                productName = "NHM 393";
                productImageView.setImageResource(R.drawable.nhm393);
                break;
            case "20":
                productName = "Falcon 1600";
                productImageView.setImageResource(R.drawable.falcon1600);
                break;
            case "21":
                productName = "Falcon 444";
                productImageView.setImageResource(R.drawable.falcon444);
                break;
            case "30":
                productName = "RS232 to RS485 - CSCAN485";
                productImageView.setImageResource(R.drawable.rs232tors485);
                break;
            case "31":
                productName = "RS485 Repeater";
                productImageView.setImageResource(R.drawable.rs485repeater);
                break;
            case "32":
                productName = "RS232 Isolator";
                productImageView.setImageResource(R.drawable.rs232isolator);
                break;
            case "33":
                productName = "RS232 or RS485 Ethernet Converter";
                productImageView.setImageResource(R.drawable.rs_ethernet_converter);
                break;
            case "34":
                productName = "HART RS232 or RS485 Converter";
                productImageView.setImageResource(R.drawable.hart_converter);
                break;
            case "35":
                productName = "HART RS232 or RS485 Gateway";
                productImageView.setImageResource(R.drawable.hart_gateway);
                break;
            case "36":
                productName = "MODBUS RTU to MODBUS TCPIP";
                productImageView.setImageResource(R.drawable.modbus_tcpip);
                break;
            case "40":
                productName = "Falcon Mini";
                productImageView.setImageResource(R.drawable.falcon_mini);
                break;
            case "41":
                productName = "Falcon 100";
                productImageView.setImageResource(R.drawable.falcon100);
                break;
            case "42":
                productName = "Falcon DIDO24";
                productImageView.setImageResource(R.drawable.falcon_dido24);
                break;
            case "43":
                productName = "Falcon 1600";
                productImageView.setImageResource(R.drawable.falcon1600);
                break;
            case "44":
                productName = "Falcon 444";
                productImageView.setImageResource(R.drawable.falcon444);
                break;
            case "45":
                productName = "Falcon 148";
                productImageView.setImageResource(R.drawable.falcon148);
                break;
            case "46":
                productName = "SDC 9648";
                productImageView.setImageResource(R.drawable.sdc9648);
                break;
            case "50":
                productName = "Falcon";
                productImageView.setImageResource(R.drawable.falcon);
                break;
            case "51":
                productName = "Proficy iFix SCADA";
                productImageView.setImageResource(R.drawable.ifix);
                break;
            case "60":
                productName = "Analog Isolators and Transmitters";
                productImageView.setImageResource(R.drawable.analog_isolator);
                break;
            case "61":
                productName = "Auto or Manual Station";
                productImageView.setImageResource(R.drawable.auto_manual_station);
                break;
            case "62":
                productName = "Load Cell Amplifier";
                productImageView.setImageResource(R.drawable.load_cell_amplifier);
                break;
            case "70":
                productName = "Sensors";
                productImageView.setImageResource(R.drawable.sensors);
                break;
            case "80":
                productName = "Battery Operated with Indication";
                productImageView.setImageResource(R.drawable.battery_operated_calibrator);
                break;
            case "81":
                productName = "Mains Operated with Indication";
                productImageView.setImageResource(R.drawable.mains_operated_calibrator);
                break;
        }

        productDetailsTextView.setText(productName);
        productLabel.setText(productName);

    }

    public void nextButton(View view)
    {
        srNo = "";
        contactPerson = "";
        designation = "";
        company = "";
        email = "";
        phone = "";
        allFieldsAreEmpty = true;
        someFieldsAreEmpty = true;

        if (!(srNoEditText.getText().toString().matches("") && contactPersonEditText.getText().toString().matches("")
                && designationEditText.getText().toString().matches("") && companyEditText.getText().toString().matches("")
                && emailEditText.getText().toString().matches("") && phoneEditText.getText().toString().matches("")))
        {
            allFieldsAreEmpty = false;
        }
        if (!(contactPersonEditText.getText().toString().matches("") || emailEditText.getText().toString().matches("")
                || phoneEditText.getText().toString().matches("")))
        {
            someFieldsAreEmpty = false;
        }

        if (!allFieldsAreEmpty && !someFieldsAreEmpty)
        {
            srNo = "Device Sr.No: " + srNoEditText.getText().toString() + "\n";
            contactPerson = "Contact Person: " + contactPersonEditText.getText().toString() + "\n";
            designation = "Designation: " + designationEditText.getText().toString() + "\n";
            company = "Company: " + companyEditText.getText().toString() + "\n";
            email = "Email Address: " + emailEditText.getText().toString() + "\n";
            phone = "Contact Number: " + phoneEditText.getText().toString() + "\n";
            productDetails = srNo + contactPerson + designation + company + email + phone;
            allFieldsAreEmpty = true;

            Intent intent = new Intent(getApplicationContext(), ComplaintTypeActivity.class);
            intent.putExtra("productID", productID);
            intent.putExtra("productDetails", productDetails);
            intent.putExtra("productName", productName);
            intent.putExtra("userName", userName);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Please enter all required fields.", Toast.LENGTH_SHORT).show();
        }
    }

}
package uk.ac.tees.aad.w9528614;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;


import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class SaveOrderActivity extends BaseActivity   {
    private ArrayList<RequestType> requestTypeList ;
    private static final String TAG = "SaveOrdersNew";
    AppLocationService appLocationService;


    //  private LocationManager mLocationManager;

    private long UPDATE_INTERVAL = 2 * 1000;  /* 10 secs */
    private long FASTEST_INTERVAL = 2000; /* 2 sec */
    private LocationManager locationManager;
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;
    RequestData requestData;



    private Double latitude = 0.00;
    private Double longitude = 0.00;
    private Button save;
    private EditText tvreqType,tvPinCode,tvlocation,ed_alterNative_Number,tv_dealerAmount,tv_dealer_margin;
    private ImageView imLocation;
    private TextView tvAvilable,itemsCount,tvCost,tvsubrequest,tvreqCost,tvProblem,tvsubrequesttype,btnCheck;
   private String title,requestName;
    private  String userId;
    private  String isDealer = "1";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.save_order_new);
        setActivty(this);
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference("RequestData");
         requestData =  new RequestData();


        appLocationService = new AppLocationService(
                SaveOrderActivity.this);

        userId = getIntent().getStringExtra("userId");
        title =  getIntent().getExtras().getString("headdertitle");
        requestName =  getIntent().getExtras().getString("requestname");
        initUI();


        tvsubrequest.setText(requestName);
        // tvProblem.setText(requestName);
        tvsubrequesttype.setText(title);


        getSupportActionBar().setTitle("Booking ");
        save.setVisibility(View.VISIBLE);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String strPhone =    ed_alterNative_Number.getText().toString();
             String  strAddress = tvlocation.getText().toString();

                addDatatoFirebase(requestName,strPhone,strAddress,title);
               
            }
        });
        imLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Location location = appLocationService
                        .getLocation(LocationManager.GPS_PROVIDER);

                //you can hard-code the lat & long if you have issues with getting it
                //remove the below if-condition and use the following couple of lines
                //double latitude = 37.422005;
                //double longitude = -122.084095

                if (location != null) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    LocationAddress locationAddress = new LocationAddress();
                    locationAddress.getAddressFromLocation(latitude, longitude,
                            getApplicationContext(), new GeocoderHandler());
                } else {
                    showSettingsAlert();
                }

            }
            
        });
      //  save.setVisibility(View.GONE);
       btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }

        });



    }


    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                SaveOrderActivity.this);
        alertDialog.setTitle("SETTINGS");
        alertDialog.setMessage("Enable Location Provider! Go to settings menu?");
        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        SaveOrderActivity.this.startActivity(intent);
                    }
                });
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }

private class GeocoderHandler extends Handler {
    @Override
    public void handleMessage(Message message) {
        String locationAddress;
        switch (message.what) {
            case 1:
                Bundle bundle = message.getData();
                locationAddress = bundle.getString("address");
                break;
            default:
                locationAddress = null;
        }
        tvlocation.setText(locationAddress);
    }
}


    private void initUI() {
         save = (Button)  findViewById(R.id.save);
        tvProblem = (TextView)  findViewById(R.id.tvProblem);
        tvPinCode = (EditText)  findViewById(R.id.tvPinCode);
        ed_alterNative_Number = (EditText)  findViewById(R.id.ed_alterNative_Number);
        tvsubrequesttype = (TextView)  findViewById(R.id.tvsubrequesttype);
        tv_dealerAmount = (EditText)  findViewById(R.id.tv_dealerAmount);
        tv_dealer_margin = (EditText)  findViewById(R.id.tv_dealer_margin);
        imLocation = (ImageView)  findViewById(R.id.imLocation);
        tvAvilable = (TextView)  findViewById(R.id.tvAvilable);
        tvreqCost = (TextView)  findViewById(R.id.tvreqCost);
        tvsubrequest = (TextView)  findViewById(R.id.tvsubrequest);
        btnCheck = (TextView)  findViewById(R.id.btn_check);
        tvlocation = (EditText)  findViewById(R.id.tvlocation);

    }

    private boolean isValidValidation() {

        boolean isTrue = true;
        if ( tvPinCode.getText().toString().trim().length() == 0|| tvlocation.getText().toString().trim().length() == 0 ) {
            Toast.makeText(getApplicationContext(), "All feilds are mandatery", Toast.LENGTH_LONG).show();
            isTrue = false;
        }else if(ed_alterNative_Number.getText().length() > 10 && ed_alterNative_Number.getText().length() < 10){
            Toast.makeText(getApplicationContext(), "Please enter Valid Mobile Number", Toast.LENGTH_LONG).show();
            isTrue = false;


        }



        return isTrue;
    }

    private void addDatatoFirebase(String requestName, String phone, String address, String subrequest) {
        // below 3 lines of code is used to set
        // data in our object class.
       requestData.setRequestType(requestName);
        requestData.setSubRequestType(subrequest);
        requestData.setPhoneNumber(phone);
        requestData.setAddress(address);



        // we are use add value event listener method
        // which is called with database reference.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // inside the method of on Data change we are setting
                // our object class to our database reference.
                // data base reference will sends data to firebase.
                databaseReference.setValue(requestData);

                // after adding this data we are showing toast message.
                Toast.makeText(SaveOrderActivity.this, "data added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(SaveOrderActivity.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }





    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }


    @Override
    protected void onResume() {
        super.onResume();

    }









}
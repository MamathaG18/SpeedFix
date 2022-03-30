package uk.ac.tees.aad.w9528614;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnNext = (Button) findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "work  in progress", Toast.LENGTH_SHORT).show();
               // Toast.makeText(MainActivity.this, "work  in progress", Toast.LENGTH_SHORT).show();
               // Toast.makeText(MainActivity.this, "work  in progress", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
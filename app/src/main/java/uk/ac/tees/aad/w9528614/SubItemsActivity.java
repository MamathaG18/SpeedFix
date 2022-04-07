package uk.ac.tees.aad.w9528614;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import java.util.List;

public class SubItemsActivity  extends AppCompatActivity {
    private int itemId = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainitem_activity);
        itemId = getIntent().getIntExtra("ITEMID",1);

        List<Items> itemsList = CommonUtils.getItems(itemId);

        ListView listView = findViewById(R.id.list_view);
       CustomAdapter customAdapter = new CustomAdapter(this, R.layout.custom_view, itemsList);
       listView.setAdapter(customAdapter);
    }
}

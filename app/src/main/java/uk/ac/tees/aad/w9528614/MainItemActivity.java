package uk.ac.tees.aad.w9528614;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainItemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainitem_activity);

        List<Items> itemsList = new ArrayList<>();
        itemsList.add(new Items(1,R.drawable.chair, "TV"));
        itemsList.add(new Items(2,R.drawable.chair, "AC"));
        itemsList.add(new Items(3,R.drawable.chair, "Water Purifire"));
        itemsList.add(new Items(4,R.drawable.chair, "Geezer"));

        ListView listView = findViewById(R.id.list_view);
        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.custom_view, itemsList);
        listView.setAdapter(customAdapter);
    }
}

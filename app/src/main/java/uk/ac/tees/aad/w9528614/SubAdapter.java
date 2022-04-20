package uk.ac.tees.aad.w9528614;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.ArrayList;
import java.util.List;

public class SubAdapter extends ArrayAdapter<Items> {

    List<Items> items_list = new ArrayList<>();
    int custom_layout_id;
    private Context mContext;
    private  String requestname;

    public SubAdapter(@NonNull Context context, int resource, @NonNull List<Items> objects, String requestName) {
        super(context, resource, objects);
        items_list = objects;
        custom_layout_id = resource;
        mContext= context;
        requestname =requestName;
    }

    @Override
    public int getCount() {
        return items_list.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            // getting reference to the main layout and
            // initializing
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(custom_layout_id, null);
        }

        // initializing the imageview and textview and
        // setting data
        ImageView imageView = v.findViewById(R.id.imageView);
        TextView textView = v.findViewById(R.id.textView);
        LinearLayout itemId = v.findViewById(R.id.itemId);

        // get the item using the  position param
        Items item = items_list.get(position);

        //imageView.setImageResource(item.getImage_id());
        textView.setText(item.getText());
        itemId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent subItem = new Intent(mContext,SaveOrderActivity.class);
                subItem.putExtra("userId",item.getItemId());
                subItem.putExtra("headdertitle",item.getText());
                subItem.putExtra("requestname",requestname);
                mContext.startActivity(subItem);

            }
        });

        return v;
    }
}
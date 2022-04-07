package uk.ac.tees.aad.w9528614;


import java.util.ArrayList;
import java.util.List;

public class CommonUtils {


    public static List<Items> getItems(int itemId) {
        List<Items> itemsList = new ArrayList<>();
        switch (itemId) {
            case 1:
                itemsList.add(new Items(101, R.drawable.chair, "New Installation"));
                itemsList.add(new Items(102, R.drawable.chair, "hardware repaire"));
                itemsList.add(new Items(102, R.drawable.chair, "hardware repaire"));
                itemsList.add(new Items(102, R.drawable.chair, "hardware repaire"));


                break;
            case 2:
                itemsList.add(new Items(105, R.drawable.chair, "New Installation"));
                itemsList.add(new Items(102, R.drawable.chair, "hardware repaire"));
                itemsList.add(new Items(102, R.drawable.chair, "hardware repaire"));
                itemsList.add(new Items(102, R.drawable.chair, "hardware repaire"));

                break;
            case 3:
                itemsList.add(new Items(106, R.drawable.chair, "New Installation"));
                itemsList.add(new Items(102, R.drawable.chair, "hardware repaire"));
                itemsList.add(new Items(102, R.drawable.chair, "hardware repaire"));
                itemsList.add(new Items(102, R.drawable.chair, "hardware repaire"));

                break;
            case 4:
                itemsList.add(new Items(108, R.drawable.chair, "New Installation"));
                itemsList.add(new Items(102, R.drawable.chair, "hardware repaire"));
                itemsList.add(new Items(102, R.drawable.chair, "hardware repaire"));
                itemsList.add(new Items(102, R.drawable.chair, "hardware repaire"));

                break;
        }
        return itemsList;


    }


}

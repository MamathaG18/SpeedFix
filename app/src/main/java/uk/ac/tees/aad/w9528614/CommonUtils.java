package uk.ac.tees.aad.w9528614;


import java.util.ArrayList;
import java.util.List;

public class CommonUtils {


    public static List<Items> getItems(int itemId) {
        List<Items> itemsList = new ArrayList<>();
        switch (itemId) {
            case 1:
                itemsList.add(new Items(101,R.drawable.newinstallation, "New Installation"));
                itemsList.add(new Items(102,R.drawable.repair, "Hardware Repair"));
                itemsList.add(new Items(103,R.drawable.maintenanace, "Maintenance Service"));
                itemsList.add(new Items(104,R.drawable.partsreplacement, "Parts Replacement"));


                break;
            case 2:
                itemsList.add(new Items(105, R.drawable.newinstallation, "New Installation"));
                itemsList.add(new Items(102, R.drawable.repair, "Hardware Repair"));
                itemsList.add(new Items(103,R.drawable.maintenanace, "Maintenance Service"));
                itemsList.add(new Items(104,R.drawable.partsreplacement, "Parts Replacement"));

                break;
            case 3:
                itemsList.add(new Items(106, R.drawable.newinstallation, "New Installation"));
                itemsList.add(new Items(102, R.drawable.repair, "Hardware Repair"));
                itemsList.add(new Items(103,R.drawable.maintenanace, "Maintenance Service"));
                itemsList.add(new Items(104,R.drawable.partsreplacement, "Parts Replacement"));

                break;
            case 4:
                itemsList.add(new Items(107, R.drawable.newinstallation, "New Installation"));
                itemsList.add(new Items(102, R.drawable.repair, "Hardware Repair"));
                itemsList.add(new Items(103,R.drawable.maintenanace, "Maintenance Service"));
                itemsList.add(new Items(104,R.drawable.partsreplacement, "Parts Replacement"));


                break;
        }
        return itemsList;


    }


}

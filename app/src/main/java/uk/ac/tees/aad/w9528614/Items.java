package uk.ac.tees.aad.w9528614;

public class Items {
    private int image_id;
    private int itemId;
    private String text;

    public int getImage_id()
    {
        return image_id;
    }

    public void setImage_id(int image_id)
    {
        this.image_id = image_id;
    }

    public String getText()
    {
        return text;
    }
    public int getItemId()
    {
        return itemId;
    }

    public void setText(String text)
    {
        this.text = text;
    }
    public void setItemId(int text)
    {
        this.itemId = itemId;
    }

    public Items(int id, int img, String text)
    {
        image_id = img;
        itemId = id;
        this.text = text;
    }
}

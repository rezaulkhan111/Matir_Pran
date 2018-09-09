package inc.machine_code.matira_prana.model;

import java.io.Serializable;

public class Home_Screen_Item implements Serializable{
    private int image;
    private String description;

    public Home_Screen_Item(int image, String description) {
        this.image = image;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

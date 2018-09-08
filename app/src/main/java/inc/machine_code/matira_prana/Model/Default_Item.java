package inc.machine_code.matira_prana.Model;

import java.io.Serializable;

public class Default_Item implements Serializable {
    private String Name;
    private String Range;
    private String Type;
    private int image;

    public Default_Item(String name, String range, String type, int image) {
        Name = name;
        Range = range;
        Type = type;
        this.image = image;
    }

    public Default_Item() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRange() {
        return Range;
    }

    public void setRange(String range) {
        Range = range;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

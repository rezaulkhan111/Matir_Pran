package inc.machine_code.matira_prana.model;

import java.io.Serializable;

public class Default_Item implements Serializable {
    private String Serial_NO;
    private String Name;
    private String Range;
    private String Type;
    private int image;

    public Default_Item(String Serial_NO, String name, String range, String type, int image) {
        this.Serial_NO = Serial_NO;
        this.Name = name;
        this.Range = range;
        this.Type = type;
        this.image = image;
    }

    public Default_Item() {

    }

    public String getSerial_NO() {
        return Serial_NO;
    }

    public void setSerial_NO(String serial_NO) {
        Serial_NO = serial_NO;
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

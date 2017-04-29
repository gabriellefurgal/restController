package legoSets;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Siekacz on 18.03.2017.
 */

@Entity
public class LegoSet {


    @Id
    @GeneratedValue
    private long id;
    private String setName;
    private String price;
    private String imagePath;

    @JsonIgnore
    @ManyToOne
    private LegoSetType legoSetType;

    public LegoSet(){};

    public LegoSet(LegoSetType setType, String setName, String price, String imagePath)
    {
        this.legoSetType = setType;
        this.setName = setName;
        this.price = price;
        this.imagePath = imagePath;
    }

    public long getId() {
        return id;
    }

    public String getSetName() {
        return setName;
    }

    public String getPrice() {
        return price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public LegoSetType getLegoSetType() {
        return legoSetType;
    }
}

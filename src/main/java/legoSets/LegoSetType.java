package legoSets;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Siekacz on 18.03.2017.
 */

@Entity
public class LegoSetType {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "legoSetType")
    private Set<LegoSet> legoSets = new HashSet<>();

    public LegoSetType(){};

    public LegoSetType (String name)
    {
        this.name=name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<LegoSet> getLegoSets() {
        return legoSets;
    }
}

package legoSets;

import org.springframework.data.rest.core.config.Projection;

/**
 * Created by Siekacz on 26.03.2017.
 */
@Projection(name = "legoSetData", types = LegoSet.class)
public interface LegoSetData {
    String getSetName();
    String getPrice();
    String getImagePath();
}

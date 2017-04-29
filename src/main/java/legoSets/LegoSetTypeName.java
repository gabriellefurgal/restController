package legoSets;

import org.springframework.data.rest.core.config.Projection;

/**
 * Created by Siekacz on 20.03.2017.
 */
@Projection(name = "legoSetTypeName", types = {LegoSetType.class})
public interface LegoSetTypeName {
    String getName();
}

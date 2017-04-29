package legoSets;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Siekacz on 19.03.2017.
 */

@ResponseStatus (HttpStatus.NOT_FOUND)
public class LegoSetTypeNotFoundException extends RuntimeException {
    public LegoSetTypeNotFoundException(String setID)
    {
        super("Could not find Lego set type '" + setID + "'.");
    }
}

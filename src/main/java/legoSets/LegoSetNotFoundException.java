package legoSets;

/**
 * Created by Siekacz on 19.03.2017.
 */
public class LegoSetNotFoundException extends RuntimeException {
    public LegoSetNotFoundException(String setTypeID, Long setID)
    {
        super("Could not find Lego set ID '" + setID + "' in " + setTypeID + " section.");}
    }

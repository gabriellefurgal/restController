package legoSets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Set;

/**
 * Created by Siekacz on 19.03.2017.
 */
@RestController
@RequestMapping("MB/products/{setID}")
public class LegoSetRestController {

    private final LegoSetRepository legoSetRepository;
    private final LegoSetTypeRepository legoSetTypeRepository;

    @Autowired
    LegoSetRestController(LegoSetRepository legoSetRepository, LegoSetTypeRepository legoSetTypeRepository)
    {
        this.legoSetRepository = legoSetRepository;
        this.legoSetTypeRepository = legoSetTypeRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sets/{legoSetID}")
    LegoSet readLegoSet(@PathVariable String setID, @PathVariable Long legoSetID )
    {
        this.validateSet(setID);
        Set<LegoSet> sets = this.legoSetTypeRepository.findByName(setID).getLegoSets();
        for (LegoSet set : sets) {
            if (set.getId() == legoSetID)
                return set;
        }
        throw new LegoSetNotFoundException(setID, legoSetID);
    }

    @RequestMapping(method = RequestMethod.GET)
    LegoSetType readLegoSetType(@PathVariable String setID){
        this.validateSet(setID);
        return this.legoSetTypeRepository.findByName(setID);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sets")
    Collection<LegoSet> readLegoSetsForType(@PathVariable String setID){
        this.validateSet(setID);
        return this.legoSetRepository.findByLegoSetTypeName(setID);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/getSets")
    Collection<LegoSetData> readLegoSetsData(){return this.legoSetRepository.findAllProjectedBy();}

    private void validateSet(String setID)
    {
        if(legoSetTypeRepository.findByName(setID) == null)
            throw new LegoSetTypeNotFoundException(setID);
    }

}

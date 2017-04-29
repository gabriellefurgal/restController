package legoSets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by Siekacz on 20.03.2017.
 */
@RestController
@RequestMapping("/legoSetTypes")

public class LegoSetTypeRestController {

    private final LegoSetTypeRepository legoSetTypeRepository;

    @Autowired
    public LegoSetTypeRestController(LegoSetTypeRepository legoSetTypeRepository)
    {
        this.legoSetTypeRepository = legoSetTypeRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<LegoSetTypeName> readLegoSetTypes(){return this.legoSetTypeRepository.findAllProjectedBy();}
}

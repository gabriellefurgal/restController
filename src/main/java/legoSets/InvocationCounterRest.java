package legoSets;

import legoSets.aspects.InvocationCounter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Siekacz on 08.04.2017.
 */
@RestController
@RequestMapping("/counter")
public class InvocationCounterRest {

    @RequestMapping(method = RequestMethod.GET)
    public Integer readCounterData(){return InvocationCounter.getCounter();}

}

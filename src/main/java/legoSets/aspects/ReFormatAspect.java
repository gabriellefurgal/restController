package legoSets.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;

/**
 * Created by Siekacz on 03.04.2017.
 */
@Aspect
public class ReFormatAspect {


    @AfterReturning(pointcut = "@annotation(legoSets.aspects.ReFormat)", returning = "response")
    public void formatter(JoinPoint joinPoint, Object response) {
        System.out.println("[@AfterReturning] " + ((String) response).toUpperCase()+ "" + new Date());
    }


}

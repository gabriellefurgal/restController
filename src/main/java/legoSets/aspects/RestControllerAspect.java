package legoSets.aspects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Created by Siekacz on 03.04.2017.
 */

@Aspect
@Component
public class RestControllerAspect {

    private static final Logger logger = Logger.getLogger(RestControllerAspect.class);
    private Properties p = new Properties();

    {
        try {
            String log4JPropertyFile = "C:/Users/Gabi/IdeaProjects/restController/src/main/resources/log4j.properties";
            p.load(new FileInputStream(log4JPropertyFile));
            PropertyConfigurator.configure(p);
            logger.info("Configuration success!");
        } catch (IOException ex)
        {
            logger.error("Error during setting up logger properties!", ex);
        }
    }

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void controller() {
    }

    @Pointcut("execution(* *.*RestController.*(..))")
    protected void allMethod() {
    }

    @Pointcut("within(@org.springframework.web.bind.annotation.RequestMapping *)")
    public void requestMapping() {
    }

    @AfterReturning("controller() && allMethod() && requestMapping()")
    public void afterControllerMethod(JoinPoint joinPoint) {
        InvocationCounter.getInstance().increment();
       // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
       // LocalDateTime now = LocalDateTime.now();
       // List<String> lines = new ArrayList<>();
        logger.info("Finished: " + niceName(joinPoint));
        //lines.add(dtf.format(now) + "\t" + "Finished: " + niceName(joinPoint));
       // logIntoFile(lines);
//        System.out.println("Finished: " + niceName(joinPoint));
    }


    @Before("controller() && allMethod() && requestMapping()")
    public void aroundControllerMethod(JoinPoint joinPoint) throws Throwable {
        InvocationCounter.getInstance().increment();
       // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
       // LocalDateTime now = LocalDateTime.now();
       // List<String> lines = new ArrayList<>();
        logger.info("Invoked: " + niceName(joinPoint));
        //lines.add(dtf.format(now) + "\t" + "Invoked: " + niceName(joinPoint));
       // logIntoFile(lines);
//        System.out.println("Invoked: " + niceName(joinPoint));
    }

   /* private void logIntoFile(List<String> lines){

        Path file = Paths.get("C:/Users/Siekacz/IdeaProjects/restController/log.txt");
        try {
            if(!file.toFile().exists())
                Files.write(file, lines, Charset.forName("UTF-8"));
            else
                Files.write(file, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        } catch (IOException ex)
        {
            System.out.println("[ERROR] Error during loggin data to file! " + ex.getMessage());
        }
    }
*/
    private String niceName(JoinPoint joinPoint) {
        return joinPoint.getTarget().getClass()
                + "#" + joinPoint.getSignature().getName()
                + "\targs:" + Arrays.toString(joinPoint.getArgs());

    }



}

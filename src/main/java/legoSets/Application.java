package legoSets;// tag::runner[]
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


/**
 * Created by Siekacz on 18.03.2017.
 */
/** -javaagent*/

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = "legoSets")
public class Application extends SpringBootServletInitializer{

//    public static void main(String [] args){
//        SpringApplication.run(Application.class, args);
//    }

    @Bean
    CommandLineRunner init(LegoSetTypeRepository legoSetTypeRepository, LegoSetRepository legoSetRepository)
    {
        return (evt) -> Arrays.asList(
                "legoTechnic,legoSystem,legoMindstorm,legoStarWars,legoCity".split(",")).forEach(a -> {
            LegoSetType legoSetType = legoSetTypeRepository.save(new LegoSetType(a));
            legoSetRepository.save(new LegoSet(legoSetType, "Awesome set", "100$", "images/zestaw.jpg"));
            legoSetRepository.save(new LegoSet(legoSetType, "Super set", "200$", "images/class.jpg"));
            legoSetRepository.save(new LegoSet(legoSetType, "Ultimate set", "300$", "images/zestaw.jpg"));
            legoSetRepository.save(new LegoSet(legoSetType, "Supreme set", "400$", "images/class.jpg"));
        });
    }

    public static void main(String[] args) throws Exception{
        configureApplication(new SpringApplicationBuilder()).run(args);
    }

    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        return builder.sources(Application.class).bannerMode(Banner.Mode.OFF);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(Application.class);
    }
}
// end::runner[]
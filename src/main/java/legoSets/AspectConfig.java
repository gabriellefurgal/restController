package legoSets;

import legoSets.aspects.ReFormatAspect;
import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.context.annotation.EnableLoadTimeWeaving.AspectJWeaving;
/**
 * Created by Siekacz on 03.04.2017.
 */

@EnableLoadTimeWeaving(aspectjWeaving = AspectJWeaving.ENABLED)
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
@EnableSpringConfigured
@ComponentScan(basePackages="legoSets")
public class AspectConfig {

    @Bean
    public ReFormatAspect reFormatAspect() {
        return Aspects.aspectOf(ReFormatAspect.class);
    }
    @Bean
    public InstrumentationLoadTimeWeaver loadTimeWeaver()  throws Throwable {
        InstrumentationLoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
        return loadTimeWeaver;
    }


}

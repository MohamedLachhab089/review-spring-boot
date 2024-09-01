package com.stage24.review_spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
// we use this one if we have only 1 property file
/* @PropertySource("classpath:custom.properties") */
// if we've a lot of properties we use:
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom2.properties")
})
public class FirstService {

    @Autowired
    @Qualifier("bean1")
    private Testing testing;
    //private Environment env;

    @Value("${my.prop}")
    private String cp;

    @Value("${my.prop.2}")
    private String cp2;

    public String Message(){
        return "Service: very nice to say " + testing.Hi();
    }

    public String getCp() {
        return cp;
    }

    public String getCp2() {
        return cp2;
    }

    // i've used Environment just for some example here you'll see it in the main class
    /*public String getVersion(){
        return env.getProperty("java.version");
    }

    public String getOsName(){
        return System.getProperty("os.name");
    }

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }*/
}

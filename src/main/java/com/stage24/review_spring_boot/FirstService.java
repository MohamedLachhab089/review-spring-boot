package com.stage24.review_spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class FirstService {

    @Autowired
    @Qualifier("bean1")
    private Testing testing;
    //private Environment env;

    public String Message(){
        return "Service: very nice to say " + testing.Hi();
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

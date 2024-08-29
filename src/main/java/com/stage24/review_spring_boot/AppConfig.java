package com.stage24.review_spring_boot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/* Using @Configuration Spring will automatically detect and create an instance
    of this class */
@Configuration
public class AppConfig {

    @Bean
    //@Qualifier("bean1")
    @Primary
    public Testing FirstTesting(){
        return new Testing("First Testing");
    }

    @Bean
    //@Qualifier("bean2")
    public Testing SecondTesting(){
        return new Testing("Second Testing");
    }

}

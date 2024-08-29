package com.stage24.review_spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FirstService {

    private final Testing testing;

    public FirstService(
            /*@Qualifier("bean2")*/ Testing testing
    ) {
        this.testing = testing;
    }

    public String Message(){
        return "Service: very nice to say " + testing.Hi();
    }


}

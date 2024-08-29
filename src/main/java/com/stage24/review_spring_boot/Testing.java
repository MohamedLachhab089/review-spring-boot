package com.stage24.review_spring_boot;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


//@Service
public class Testing {

    private String myVar;

    public Testing(String myVar) {
        this.myVar = myVar;
    }


    public String Hi(){
        return "Hi for the first testing today ==> myVar = " + myVar;
    }

}

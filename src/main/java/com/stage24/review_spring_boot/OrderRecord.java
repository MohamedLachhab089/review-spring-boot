package com.stage24.review_spring_boot;

public record OrderRecord(
        String customName,
        String productName,
        int quantity
) {

}

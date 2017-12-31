package com.jack.utils;

import javax.validation.constraints.Size;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ValidateTest {
    public static void findByCodeAndAuthor(@Size(min = 8, max = 10) String code) {
        System.out.println(code);
    }

    public static void main(String[] args) {
        findByCodeAndAuthor("s");
    }
}
package com.discernd.discernded.registration;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        Assert.notNull(s, "email vali cannot be null");
        return true;
    }
}

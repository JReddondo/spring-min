package com.example.demo.common;

import java.util.stream.Stream;

public final class Util {
    public static <T> T getEntity(Stream<T> stream){
        return stream
        .findFirst()        
        .orElseThrow(() -> {
            throw new NotfoundException();
        });
    }
}

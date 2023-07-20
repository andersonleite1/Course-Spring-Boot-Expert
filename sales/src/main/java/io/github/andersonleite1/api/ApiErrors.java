package io.github.andersonleite1.api;

import lombok.Getter;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ApiErrors {

    @Getter
    private List<String> errors;

    public ApiErrors(String messageError) {
        this.errors = Arrays.asList(messageError);
    }
}

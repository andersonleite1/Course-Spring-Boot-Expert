package io.github.andersonleite1.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException () {
        super("Order not found");
    }
}

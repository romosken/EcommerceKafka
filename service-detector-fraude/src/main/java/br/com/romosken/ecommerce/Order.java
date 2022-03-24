package br.com.romosken.ecommerce;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class Order {
    private final String userId, orderId;
    private final BigDecimal value;
}

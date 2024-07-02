package com.hexagonal;

import com.hexagonal.domain.model.Order;
import com.hexagonal.domain.service.OrderService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import jakarta.inject.Inject;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

@QuarkusTest
public class OrderServiceTest {

    @Inject
    OrderService orderService;

    @Test
    void testCreateOrder() {
        Order order = new Order();
        orderService.createOrder(order);
        assertNotNull(order.getId());
    }
}

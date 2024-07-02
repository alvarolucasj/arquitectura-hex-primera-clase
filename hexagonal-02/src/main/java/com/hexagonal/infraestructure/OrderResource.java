package com.hexagonal.infraestructure;

import com.hexagonal.domain.model.Order;
import com.hexagonal.domain.model.OrderItem;
import com.hexagonal.domain.service.OrderService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.awt.*;
import java.util.List;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    @Inject
    OrderService orderService;

    @POST
    public Response createOrder(Order order) {
        orderService.createOrder(order);
        return Response.status(Response.Status.CREATED).entity(order).build();
    }

    @POST
    @Path("/{orderId}/items")
    public Response addItemToOrder(@PathParam("orderId") Long orderId, OrderItem orderItem){
        orderService.addItemToOrder(orderId, orderItem);
        return Response.ok().build();
    }

    @PUT
    @Path("/{orderId}/status")
    public Response updateOrderStatus(@PathParam("orderId") Long orderId, String status){
        orderService.updateOrderStatus(orderId, status);
        return Response.ok().build();
    }

    @GET
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GET
    @Path("/{orderId}")
    public Order getOrderById(@PathParam("orderId") Long orderId) {
        return orderService.findOrderById(orderId);
    }
}

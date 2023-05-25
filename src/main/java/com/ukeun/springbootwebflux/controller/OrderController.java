package com.ukeun.springbootwebflux.controller;

import com.ukeun.springbootwebflux.pojo.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @GetMapping(value = "/getAll", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Order> getAll() {
        Flux<Order> fluxOrder = Flux.just(
                        new Order(1L, 100.0),
                        new Order(2L, 200.0),
                        new Order(3L, 300.0),
                        new Order(4L, 100.0),
                        new Order(5L, 200.0),
                        new Order(6L, 300.0),
                        new Order(7L, 100.0),
                        new Order(8L, 200.0),
                        new Order(9L, 300.0),
                        new Order(10L, 100.0),
                        new Order(11L, 200.0),
                        new Order(12L, 300.0),
                        new Order(13L, 200.0),
                        new Order(14L, 300.0),
                        new Order(15L, 100.0),
                        new Order(16L, 200.0),
                        new Order(17L, 300.0),
                        new Order(18L, 100.0),
                        new Order(19L, 200.0),
                        new Order(20L, 300.0))
                .delayElements(Duration.ofSeconds(1))
                .log();
        return fluxOrder;
    }
}

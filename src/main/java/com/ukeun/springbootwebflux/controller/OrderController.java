package com.ukeun.springbootwebflux.controller;

import com.ukeun.springbootwebflux.pojo.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    /*
    Reactive GET
     */
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

    /*
    traditional GET
    위의 코드는 데이터가 하나씩 화면에 뜨는 반면
    모든 데이터가 도착한 후에 화면에 뜬다.
     */
    @GetMapping(value = "/traditional/getAll", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public List<Order> traditionalGetAll() {
        List<Order> list = Arrays.asList(
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
                new Order(20L, 300.0));

        list = list.stream().peek(order -> {
            try {
                System.out.println(order.getId());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).collect(Collectors.toList());

        return list;
    }

    @GetMapping("/getOne")
    public Mono<Order> getOne() {
        Mono<Order> mono = Mono.just(new Order(1L, 100.00)).log();

        return mono;
    }
}

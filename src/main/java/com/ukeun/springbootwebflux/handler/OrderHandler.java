package com.ukeun.springbootwebflux.handler;

import com.ukeun.springbootwebflux.pojo.Order;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@NoArgsConstructor
public class OrderHandler {

    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        // ServerRequest, ServerResponse 는 Spring MVC에서 HttpRequest, HttpResponse와 대응되는 개념이다.
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(
                        Flux.just(
                                new Order(1L, 100.0),
                                new Order(2L, 200.0),
                                new Order(3L, 300.0)),
                        Order.class
                ); // 데이터를 body에 담아서 보내줄 때 데이터의 클래스를 같이 적어줘야 한다.
    }
}

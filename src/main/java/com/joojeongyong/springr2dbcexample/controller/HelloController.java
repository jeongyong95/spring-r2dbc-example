package com.joojeongyong.springr2dbcexample.controller;

import com.joojeongyong.springr2dbcexample.repository.user.ExampleUser;
import com.joojeongyong.springr2dbcexample.repository.user.ExampleUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping
@RestController
public class HelloController {
    private final ExampleUserRepository exampleUserRepository;

    @GetMapping
    public Mono<String> hello() {
        return Mono.just("Hello, world!");
    }

    @PostMapping("/users")
    public Flux<ExampleUser> addUsers() {
        List<ExampleUser> users = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            users.add(ExampleUser.sample());
        }

        log.info("사용자 저장 시작! : {}", LocalDateTime.now());
        var start = System.currentTimeMillis();
        Flux<ExampleUser> flux = exampleUserRepository.saveAll(users);
        log.info("사정자 저장 끝!. 소요시간 : {}ms.", System.currentTimeMillis() - start);

        return flux;
    }
}

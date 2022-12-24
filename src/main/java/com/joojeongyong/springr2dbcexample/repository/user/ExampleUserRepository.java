package com.joojeongyong.springr2dbcexample.repository.user;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleUserRepository extends R2dbcRepository<ExampleUser, Long> {

}

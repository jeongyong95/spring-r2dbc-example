package com.joojeongyong.springr2dbcexample.repository.user;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Getter
@ToString
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "example_user")
public class ExampleUser {
    private static final Random RANDOM;

    static {
        try {
            RANDOM = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Id
    @Column(value = "example_user_id")
    private Long exampleUserId;

    @Column(value = "user_name")
    private String username;

    @Column(value = "user_account")
    private UUID userAccount;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public static ExampleUser sample() {
        return ExampleUser.builder()
                .username("user" + RANDOM.nextInt())
                .userAccount(UUID.randomUUID())
                .build();
    }
}

package com.user.management.sittings.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;

import org.springframework.stereotype.Component;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenConfiguration {
    private String secret;
    private Duration accessTokenTime;
    private Duration refreshTokenTime;
}

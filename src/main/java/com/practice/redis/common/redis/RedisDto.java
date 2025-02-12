package com.practice.redis.common.redis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RedisDto {
    private String key;
    private String value;
    private Duration duration;
}

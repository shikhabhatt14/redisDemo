package com.example.redisDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

import java.time.Duration;

@Configuration
public class RedisCacheConfig {

    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
         return RedisCacheConfiguration.defaultCacheConfig()
                 .entryTtl(Duration.ofMinutes(10)) // Set the default expiration time for cache entries
                    .disableCachingNullValues(); // Disable caching of null values

    }

    // @Bean
    // public RedisCacheConfiguration cacheConfiguration() {
    //     return RedisCacheConfiguration.defaultCacheConfig()
    //             .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    // }

    // @Bean
    // public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
    //     return RedisCacheManager.builder(redisConnectionFactory)
    //             .cacheDefaults(cacheConfiguration())
    //             .transactionAware()
    //             .build();
    // }
}

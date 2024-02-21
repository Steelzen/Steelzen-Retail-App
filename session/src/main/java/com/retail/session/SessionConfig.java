package com.retail.session;

import java.time.Duration;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.session.RedisSessionProperties;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.data.redis.RedisSessionRepository;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(RedisSessionProperties.class)
@EnableSpringHttpSession
public class SessionConfig {

    private final SessionProperties sessionProperties;

    private final RedisSessionProperties redisSessionProperties;

    private final RedisConnectionFactory redisConnectionFactory;

    public SessionConfig(SessionProperties sessionProperties, RedisSessionProperties redisSessionProperties,
                         ObjectProvider<RedisConnectionFactory> redisConnectionFactory) {
        this.sessionProperties = sessionProperties;
        this.redisSessionProperties = redisSessionProperties;
        this.redisConnectionFactory = redisConnectionFactory.getObject();
    }

    @Bean
    public RedisOperations<String, Object> sessionRedisOperations() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(this.redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    @Bean
    public RedisSessionRepository sessionRepository(RedisOperations<String, Object> sessionRedisOperations) {
        RedisSessionRepository sessionRepository = new RedisSessionRepository(sessionRedisOperations);
        Duration timeout = this.sessionProperties.getTimeout();
        if (timeout != null) {
            sessionRepository.setDefaultMaxInactiveInterval(timeout);
        }
        sessionRepository.setRedisKeyNamespace(this.redisSessionProperties.getNamespace());
        sessionRepository.setFlushMode(this.redisSessionProperties.getFlushMode());
        sessionRepository.setSaveMode(this.redisSessionProperties.getSaveMode());
        return sessionRepository;
    }
}

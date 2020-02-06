package com.proptiger.urlshortner.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport{
    
    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
    	   JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
           redisConnectionFactory.setHostName("127.0.0.1");
           redisConnectionFactory.setPort(6379);
           return redisConnectionFactory;
    }
    
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
    
    @Bean
      public CacheManager cacheManager(RedisTemplate<String, String> redisTemplate) {
       RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        return cacheManager;
      }
}


	

 

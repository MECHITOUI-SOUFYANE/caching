package com.caching.config;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class CacheConfiguration {

    @Bean
    public CacheManagerCustomizer<ConcurrentMapCacheManager> customizer(){
        return cacheManager -> {
          cacheManager.setAllowNullValues(false);
          cacheManager.setStoreByValue(true);
        };
    }
}

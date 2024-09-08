package com.caching.config;

import lombok.extern.slf4j.Slf4j;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class CacheEventLogger implements CacheEventListener<Object, Object>{
    @Override
    public void onEvent(CacheEvent<?, ?> cacheEvent) {
        log.info("[{}] cache key {} , cache old value {} , cache new value {}", cacheEvent.getType() , cacheEvent.getKey(), cacheEvent.getOldValue(), cacheEvent.getNewValue());
    }
}

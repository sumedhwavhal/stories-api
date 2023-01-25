package com.sumedh.storiesapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

	@Autowired
	CacheManager cacheManager;

	public void evictAllCacheValues(String cacheName) {
		cacheManager.getCache(cacheName).clear();
	}

	public void evictAllCaches() {
		cacheManager.getCacheNames().stream().forEach(cacheName -> cacheManager.getCache(cacheName).clear());
	}

	@Scheduled(fixedRate = 900000)
	public void evictAllCachesEvery15Minutes() {
		evictAllCaches();
	}
}

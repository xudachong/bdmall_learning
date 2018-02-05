package com.bigdragonmall.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @Author: XuJuLong<5 7 4 4 0 8 5 7 8 @ qq.com>
 * @Description:
 * @Date: Created in 20:34 2017/12/20
 * @
 */
@Slf4j
public class TokenCache {

	public static String TOKEN_PREFIX = "token_";
	//声明一个静态的内存块，LRU算法,有效期设为12小时
	private static LoadingCache<String,String> localCache = CacheBuilder.newBuilder().initialCapacity(1000).maximumSize(10000).expireAfterAccess(12, TimeUnit.HOURS)
			.build(new CacheLoader<String, String>() {
				@Override
				public String load(String s) throws Exception {
					return "null";
				}
			});
	public static void setKey(String key,String value){
		localCache.put(key,value);
	}
	public static String getKey(String key){
		String value = null;
		try {
			value = localCache.get(key);
			if ("null".equals(value)){
				return null;
			}
			return value;
		}catch (Exception e){
			log.error("localCache get error",e);
		}
		return null;
	}



}

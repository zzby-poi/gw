package com.gw.util;

import org.springframework.core.io.buffer.DataBuffer;

import reactor.core.publisher.Flux;

/**
 * @Title: ThreadLocalUtil
 * @Description:
 * @author: yangxy
 * @date 2022年7月15日 下午3:18:54
 */
public class ThreadLocalUtil {
	private static final ThreadLocal<Flux<DataBuffer>> paramThreadLocal = new ThreadLocal<Flux<DataBuffer>>();
	
	public static void set(Flux<DataBuffer> flux) {
		paramThreadLocal.set(flux);
	}
	
	public static Flux<DataBuffer> get() {
		Flux<DataBuffer> flux = paramThreadLocal.get();
		remove();
		return flux;
	}
	
	public static void remove() {
		paramThreadLocal.remove();
	}
}

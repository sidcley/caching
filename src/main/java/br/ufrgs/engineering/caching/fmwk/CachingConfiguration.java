package br.ufrgs.engineering.caching.fmwk;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class CachingConfiguration {

	@Bean
	// the Aspect itself must also be a Bean
	public CachingAspect cachingAspect() {
		return new CachingAspect();
	}
	

	@Bean
	// the Aspect itself must also be a Bean
	public Cache cache() {
		return new CacheImpl();
	}
}

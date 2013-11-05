package br.ufrgs.engineering.caching.fmwk;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class CachingAspect {
	@Autowired
	Cache cache;
	@Autowired
	ObserverFactory factory;
	
	
	
	@Before(value = "@annotation(Evict)")
	public void before(JoinPoint joinPoint) throws NoSuchMethodException, InstantiationException, IllegalAccessException {
		
	
		
		Evict evict = getEvict(joinPoint);
		String key = getKey(evict);
		if(key != null){
		cache.remove(key);
		}
	}
	
	@Around(value = "@annotation(Cacheable)")
	public Object doSomething(final ProceedingJoinPoint pjp)
	    throws Throwable {
		Cacheable cacheable = getCacheable(pjp);
		Object cachedObject = findInCache(cacheable);
		if(cachedObject != null){
			System.out.println("returning from cache...");
			return cachedObject;
		}
		System.out.println(cacheable);
		Serializable ret =  (Serializable) pjp.proceed();
		updateCache(ret, cacheable);
		return ret;
		
	}
	
	public Object findInCache(Cacheable cacheable) throws InstantiationException, IllegalAccessException{
		 String key = getKey(cacheable);
		 return cache.find(key);
		
	}
	
	

	private Cacheable getCacheable(final JoinPoint pjp)
		throws NoSuchMethodException {
		Signature s = pjp.getSignature();
		Class[] classes = new Class[pjp.getArgs().length];
		for (int i = 0; i < classes.length; i++) {
			classes[i] = pjp.getArgs()[i].getClass();
		}
		Method m = s.getDeclaringType().getDeclaredMethod(pjp.getSignature().getName(),classes);
		Cacheable cacheable = m.getAnnotation(Cacheable.class);
	
		return cacheable;
	
	
		
	}
	
	private Evict getEvict(final JoinPoint pjp)
			throws NoSuchMethodException {
			
			Signature s = pjp.getSignature();
			Class[] classes = new Class[pjp.getArgs().length];
			for (int i = 0; i < classes.length; i++) {
				classes[i] = pjp.getArgs()[i].getClass();
			}
			Method m = s.getDeclaringType().getDeclaredMethod(pjp.getSignature().getName(),classes);
			Evict evict = m.getAnnotation(Evict.class);
		
			return evict;
		
		
			
		}
	

	
	
	private String getKey(Cacheable cacheable) throws InstantiationException,
			IllegalAccessException {
		String key;
		if(hasComplexKey(cacheable)){
			key  = cacheable.key() + cacheable.compoundKey().newInstance().compoundKey();
		}
		else{
			key = cacheable.key();
		}
		return key;
	}
	

	private String getKey(Evict evict) throws InstantiationException,
			IllegalAccessException {
		String key;
		if(hasComplexKey(evict)){
			key  = evict.key() + evict.compoundKey().newInstance().compoundKey();
		}
		else{
			key = evict.key();
		}
		return key;
	}
	
	
	
	
	private boolean hasComplexKey(Cacheable cacheable){
		Class<CompoundKey> complexKey = (Class<CompoundKey>) cacheable.compoundKey();
		return !Modifier.isAbstract(complexKey.getModifiers());
	}
	
	
	private boolean hasComplexKey(Evict evict){
		Class<CompoundKey> complexKey = (Class<CompoundKey>) evict.compoundKey();
		return !Modifier.isAbstract(complexKey.getModifiers());
	}
	
	

	
	
	public void updateCache(Serializable ret, Cacheable cacheable) throws InstantiationException, IllegalAccessException{
		String key = getKey(cacheable);
		cache.add(key, ret);
		
	}
	

}

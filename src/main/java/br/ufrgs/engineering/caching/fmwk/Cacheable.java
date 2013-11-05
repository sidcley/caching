package br.ufrgs.engineering.caching.fmwk;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Cacheable {
	
	String key() default "";
	Class<? extends CompoundKey> compoundKey()  default CompoundKey.class ;
	boolean ignoreInput() default false;

}

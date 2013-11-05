package br.ufrgs.engineering.caching.fmwk;

import java.io.Serializable;
import java.util.HashMap;

public class CacheImpl implements Cache {

	static HashMap<String,Object> cache = new HashMap<String, Object>();
	
	/* (non-Javadoc)
	 * @see br.ufrgs.engineering.caching.fmwk.Cache#push(java.lang.String, java.lang.Object)
	 */
	public  void add(String key, Serializable object){
		cache.put(key,object);
	}
	
	
	/* (non-Javadoc)
	 * @see br.ufrgs.engineering.caching.fmwk.Cache#find(java.lang.String)
	 */
	public  Object find(String key){
		return cache.get(key);
	}
	
	/* (non-Javadoc)
	 * @see br.ufrgs.engineering.caching.fmwk.Cache#remove(java.lang.String)
	 */
	public  void remove(String key){
		cache.remove(key);
	}
}

package br.ufrgs.engineering.caching.fmwk;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class ObserverFactory {
	
	
	public static void loadObservers(){
		 AnnotationConfigApplicationContext context  =new  AnnotationConfigApplicationContext();
		 context.scan("com","br");
			
		 context.refresh();
		Map<String,Object> beans = context.getBeansWithAnnotation(CachingObserver.class);
	 	Set<Entry<String, Object>> entries = beans.entrySet();
	 	
	 	for (Iterator iterator = entries.iterator(); iterator.hasNext();) {
			Entry<String, Object> entry = (Entry<String, Object>) iterator
					.next();
			System.out.println(entry.getValue());
			
		}
	
		
		
		
	}

}

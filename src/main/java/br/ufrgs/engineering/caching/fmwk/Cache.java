package br.ufrgs.engineering.caching.fmwk;

import java.io.Serializable;



public interface Cache {

	public abstract void add(String key, Serializable object);

	public abstract Object find(String key);

	public abstract void remove(String key);

}
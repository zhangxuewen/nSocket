package com.ns.core.baseframework.coreinterface;

import java.util.Set;

/**
 * 
 * @author zhangxuewen
 *
 * @date  下午07:29:22
 */
public interface Session {
	public enum SessionStatus {
		NULL, READING, WRITING, IDLE, INITIALIZE, CLOSING, CLOSED
	}
	/*
	 * 
	 */
	public void start();
	/*
	 * 
	 */
	public void closed();
	public boolean isclosed();

	 /**
     * Returns all attribute key set
     * 
     * @return
     */
    public Set<String> attributeKeySet();


    /**
     * Remove attribute
     * 
     * @param key
     */
    void removeAttribute(String key);


    /**
     * Return attribute associated with key
     * 
     * @param key
     * @return
     */
    Object getAttribute(String key);

}

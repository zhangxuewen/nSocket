package com.ns.core.baseframework.coreinterface.impl;

import java.nio.ByteOrder;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import com.ns.core.baseframework.coreinterface.Session;


public class AbstractSession implements Session {
    protected volatile boolean closed, innerClosed;
    protected ByteOrder byteOrder;
    protected boolean loopback;
    public AtomicLong lastOperationTimeStamp = new AtomicLong(0);
    protected AtomicLong scheduleWritenBytes = new AtomicLong(0);
    protected volatile boolean useBlockingWrite = false;
    protected volatile boolean useBlockingRead = true;
    protected volatile boolean handleReadWriteConcurrently = true;
    protected volatile long sessionIdleTimeout;

    protected volatile long sessionTimeout;

	public void start() {
		// TODO Auto-generated method stub
		
	}

	public void closed() {
		// TODO Auto-generated method stub
		
	}

	public boolean isclosed() {
		// TODO Auto-generated method stub
		return false;
	}

	public void Write(Object message) {
		// TODO Auto-generated method stub
		
	}
	public Object Read() {
		return null;
		// TODO Auto-generated method stub
		
	}

	public Set<String> attributeKeySet() {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeAttribute(String key) {
		// TODO Auto-generated method stub
		
	}

	public Object getAttribute(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}

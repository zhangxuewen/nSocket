package com.ns.core.baseframework.coreinterface;

public interface EventDispatcher {
	public void dispatch(Runnable r);

	public void stop();
}

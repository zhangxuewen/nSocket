package com.ns.core.baseframework.coreinterface.impl;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.omg.IOP.CodecFactory;

import com.ns.core.baseframework.coreinterface.Controller;
import com.ns.core.baseframework.coreinterface.ControllerStateListener;
import com.ns.core.baseframework.coreinterface.Handler;
import com.ns.core.baseframework.coreinterface.SocketOption;
import com.ns.core.baseframework.statistics.Statistics;

public abstract class AbstractController implements Controller{

	public long getSessionTimeout() {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getSessionIdleTimeout() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setSessionIdleTimeout(long sessionIdleTimeout) {
		// TODO Auto-generated method stub
		
	}

	public void setSessionTimeout(long sessionTimeout) {
		// TODO Auto-generated method stub
		
	}

	public int getSoTimeout() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setSoTimeout(int timeout) {
		// TODO Auto-generated method stub
		
	}

	public void addStateListener(ControllerStateListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void removeStateListener(ControllerStateListener listener) {
		// TODO Auto-generated method stub
		
	}

	public boolean isHandleReadWriteConcurrently() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setHandleReadWriteConcurrently(
			boolean handleReadWriteConcurrently) {
		// TODO Auto-generated method stub
		
	}

	public int getReadThreadCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setReadThreadCount(int readThreadCount) {
		// TODO Auto-generated method stub
		
	}

	public Handler getHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setHandler(Handler handler) {
		// TODO Auto-generated method stub
		
	}

	public int getPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void start() throws IOException {
		// TODO Auto-generated method stub
		
	}

	public boolean isStarted() {
		// TODO Auto-generated method stub
		return false;
	}

	public Statistics getStatistics() {
		// TODO Auto-generated method stub
		return null;
	}

	public CodecFactory getCodecFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCodecFactory(CodecFactory codecFactory) {
		// TODO Auto-generated method stub
		
	}

	public void stop() throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void setReceiveThroughputLimit(double receivePacketRate) {
		// TODO Auto-generated method stub
		
	}

	public double getReceiveThroughputLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	public InetSocketAddress getLocalSocketAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLocalSocketAddress(InetSocketAddress inetAddress) {
		// TODO Auto-generated method stub
		
	}

	public int getDispatchMessageThreadCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setDispatchMessageThreadCount(int dispatchMessageThreadPoolSize) {
		// TODO Auto-generated method stub
		
	}

	public int getWriteThreadCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setWriteThreadCount(int writeThreadCount) {
		// TODO Auto-generated method stub
		
	}

	public <T> void setSocketOption(SocketOption<T> socketOption, T value) {
		// TODO Auto-generated method stub
		
	}

}

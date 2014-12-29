package com.ns.core.baseframework.coreinterface;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.omg.IOP.CodecFactory;

import com.ns.core.baseframework.statistics.Statistics;


public interface Controller {
	long getSessionTimeout();

	public long getSessionIdleTimeout();

	public void setSessionIdleTimeout(long sessionIdleTimeout);

	void setSessionTimeout(long sessionTimeout);

	int getSoTimeout();

	void setSoTimeout(int timeout);

	void addStateListener(ControllerStateListener listener);

	public void removeStateListener(ControllerStateListener listener);

	boolean isHandleReadWriteConcurrently();

	void setHandleReadWriteConcurrently(boolean handleReadWriteConcurrently);

	int getReadThreadCount();

	void setReadThreadCount(int readThreadCount);

	Handler getHandler();

	void setHandler(Handler handler);

	int getPort();

	void start() throws IOException;

	boolean isStarted();

	Statistics getStatistics();

	CodecFactory getCodecFactory();

	void setCodecFactory(CodecFactory codecFactory);

	void stop() throws IOException;

	void setReceiveThroughputLimit(double receivePacketRate);

	double getReceiveThroughputLimit();

	InetSocketAddress getLocalSocketAddress();

	void setLocalSocketAddress(InetSocketAddress inetAddress);

	int getDispatchMessageThreadCount();

	void setDispatchMessageThreadCount(int dispatchMessageThreadPoolSize);

	int getWriteThreadCount();

	void setWriteThreadCount(int writeThreadCount);

	<T> void setSocketOption(SocketOption<T> socketOption, T value);
}

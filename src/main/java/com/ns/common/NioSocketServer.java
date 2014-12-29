package com.ns.common;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ns.app.MainStart;

public class NioSocketServer implements Runnable {
	private final static Log log = LogFactory.getLog(NioSocketServer.class);
	private ServerSocketChannel servChannel;
	private Selector selector;
	private boolean stop;

	public NioSocketServer(String ip, int port) {
		InetSocketAddress netsocket = new InetSocketAddress(ip, port);
		try {
			selector = Selector.open();
			servChannel = ServerSocketChannel.open();
			servChannel.configureBlocking(false);
			servChannel.socket().bind(netsocket,1024);
			servChannel.register(selector, SelectionKey.OP_ACCEPT);
			log.error("niosocket init ......");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	public void run() {
		while (!stop) {
			//log.error("wait");
			try {
				selector.select(1000);
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				//log.error("selectedKeyssize===="+selectedKeys.size());
				Iterator<SelectionKey> it = selectedKeys.iterator();
				SelectionKey key = null;
				while (it.hasNext()) {
					key = it.next();
			        it.remove();
					try {
						handleFunction(key);
					} catch (Exception e) {
						if (key != null) {
							key.cancel();
							if (key.channel() != null)
								key.channel().close();
						}
					}
				}
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}

		// 多路复用器关闭后，所有注册在上面的Channel和Pipe等资源都会被自动去注册并关闭，所以不需要重复释放资源
		if (selector != null)
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
		}

	}

	public void stop() {
		this.stop = true;
	}

	private void handleFunction(SelectionKey key) throws IOException {
       // log.error("accept");
		if (key.isValid()) {
			// 处理新接入的请求消息
			if (key.isAcceptable()) {
				// log.error("accepted");
				// Accept the new connection
				ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
				SocketChannel sc = ssc.accept();
				sc.configureBlocking(false);
				// Add the new connection to the selector
				sc.register(selector, SelectionKey.OP_READ|SelectionKey.OP_WRITE);
			}
			if (key.isReadable()) {
				//log.error("readed");
				SocketChannel sc = (SocketChannel) key.channel();
				String request="get";
				doRead(sc,request);	
				
			}
			 if(key.isWritable()){
			
				// log.error("write");
				 SocketChannel sc = (SocketChannel) key.channel();
				 String response="helloworld"+System.currentTimeMillis();
				 doWrite(sc,response);
			}	
		}
	}
	private void doWrite(SocketChannel channel, String response) {
		log.error(response);
		if (response != null && response.trim().length() > 0) {
			byte[] bytes = response.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);
			writeBuffer.flip();
			try {
				channel.write(writeBuffer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	private void doRead(SocketChannel channel, String request) {
		// Read the data

		ByteBuffer readBuffer = ByteBuffer.allocate(1024);
		int readBytes = 0;
		try {
			readBytes= channel.read(readBuffer);
			if (readBytes > 0) {
				readBuffer.flip();
				byte[] bytes = new byte[readBuffer.remaining()];
				readBuffer.get(bytes);
				String body = new String(bytes, "UTF-8");
				log.error("The time server receive order :" + body);
			
			} 
			  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
   }
	
}

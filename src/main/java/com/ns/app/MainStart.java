package com.ns.app;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ns.common.NioSocketServer;
public class MainStart {
	private final static Log log = LogFactory.getLog(MainStart.class);
	public static void main(String[] args) {
		try {
			
		    String ip="10.12.124.47";
		    int port=8888;
		    log.error("server start......");
			NioSocketServer server = new NioSocketServer(ip,port);
			Thread tServer = new Thread(server);
			tServer.start();
		} catch (Exception e) {
			log.error("Server error: " + e.getMessage());
			System.exit(-1);
		}
	}
}

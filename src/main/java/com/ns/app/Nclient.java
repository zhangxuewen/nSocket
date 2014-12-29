package com.ns.app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ns.common.NioSocketServer;

public class Nclient {
	private final static Log log = LogFactory.getLog(NioSocketServer.class);
	public static void main(String[] args) {
		Socket client = null;
		DataOutputStream out = null;
		DataInputStream in = null;
		try {
			client = new Socket("10.12.124.47", 8888);
			client.setSoTimeout(10000);
		     while(true){
			   out = new DataOutputStream((client.getOutputStream()));

			   String query = "zhangxuewen";
			   byte[] request = query.getBytes();
			   out.write(request);
			   out.flush();
			   //client.shutdownOutput();

			   in = new DataInputStream(client.getInputStream());
			   byte[] reply = new byte[40];
			   in.read(reply);
			   log.error("RepleTime: " + new String(reply, "UTF-8"));
		     }
		
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

}

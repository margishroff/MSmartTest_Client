package tests;

import java.io.IOException;
import java.net.ServerSocket;

public class TestPort {

	public static int findFreePort()
			throws IOException {
		ServerSocket server =
				new ServerSocket(0);
		int port = server.getLocalPort();
		
		System.out.println("PORT ="+ port);
		
		server.close();
		return port;
	}
}

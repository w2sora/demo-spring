package com.weiwei.timeServer.bio2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
    private static final Logger log = LoggerFactory.getLogger(TimeServer.class);

    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket server = null;

        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }
        }

        try {
            server = new ServerSocket(port);
            log.info("The time server is started in port: {}", port);
            Socket socket = null;
            TimeServerHandlerExecutePool executePool = new TimeServerHandlerExecutePool(50, 10000);
            while (true) {
                socket = server.accept();
                executePool.execute(new TimeServerHandler(socket));
            }
        } finally {
            if (server != null) {
                log.info("Close the time server...");
                server.close();
                server = null;
            }
        }
    }
}

package com.weiwei.timeServer.bio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient {
    private static final Logger log = LoggerFactory.getLogger(TimeClient.class);

    public static void main(String[] args) {
        int port = 8080;
        Socket socket = null;

        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }
        }

        BufferedReader in = null;
        PrintWriter out = null;

        try {
            socket = new Socket("127.0.0.1", port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("QUERY TIME ORDER");
            log.info("Send order to server succeed.");
            String resp = in.readLine();
            log.info("Now is: {}", resp);
        } catch (Exception e) {
            // 不需要处理
        } finally {
            Utils.close(in);
            if (out != null) {
                out.close();
                out = null;
            }
            Utils.close(socket);
        }
    }

}

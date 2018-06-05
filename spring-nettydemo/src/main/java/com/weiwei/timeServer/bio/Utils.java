package com.weiwei.timeServer.bio;

import java.io.Closeable;
import java.io.IOException;

public class Utils {

    public static void close(Closeable target) {
        if (target != null) {
            try {
                target.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            target = null;
        }
    }

}

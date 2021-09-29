package lehulio;


import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.logging.Logger;

public class Application {

    private static final Logger logger = Logger.getLogger(Application.class.getName());

    public static void main(String... args) throws IOException {
        logger.info("main method start");

        HttpServer server = null;
        int port;
        if (args[0].length() > 0) {
            try {
                port = Integer.parseInt(args[0]);
                if (port > 0) {
                    server = HttpServer.create(new InetSocketAddress(port), 0);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        server.createContext("/articles", new PostsAndSearchHandler());
        server.setExecutor(null);
        server.start();
    }


}
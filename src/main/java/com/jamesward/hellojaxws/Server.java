package com.jamesward.hellojaxws;

import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.NetworkListener;
import org.glassfish.grizzly.jaxws.JaxwsHandler;

import java.io.IOException;

public class Server {

    public static void main(String[] args) throws InterruptedException, IOException {
        final int port = System.getenv("PORT") != null ? Integer.valueOf(System.getenv("PORT")) : 8080;

        final HttpServer httpServer = new HttpServer();
        final NetworkListener networkListener = new NetworkListener("jaxws-listener", "0.0.0.0", port);

        final HttpHandler httpHandler = new JaxwsHandler(new HelloWorldService());
        httpServer.getServerConfiguration().addHttpHandler(httpHandler, "/hello");
        httpServer.addListener(networkListener);

        httpServer.start();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                httpServer.shutdownNow();
            }
        });

        Thread.currentThread().join();
    }

}

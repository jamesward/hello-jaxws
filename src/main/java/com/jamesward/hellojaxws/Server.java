package com.jamesward.hellojaxws;

import javax.xml.ws.Endpoint;
import java.io.IOException;
import java.net.URL;

public class Server {

    public static void main(String[] args) throws IOException {
        final int port = System.getenv("PORT") != null ? Integer.valueOf(System.getenv("PORT")) : 8080;
        final URL helloURL = new URL("http", "0.0.0.0", port, "/hello");

        Endpoint.publish(helloURL.toString(), new HelloWorldService());
    }

}

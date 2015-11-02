package com.jamesward.hellojaxws;

import javax.xml.ws.Endpoint;
import java.net.MalformedURLException;
import java.net.URL;

public class Server {

    public static void main(String[] args) throws MalformedURLException {
        final String proto = System.getenv("PROTO") != null ? System.getenv("PROTO") : "http";
        final String host = System.getenv("HOST") != null ? System.getenv("HOST") : "localhost";
        final int port = System.getenv("PORT") != null ? Integer.valueOf(System.getenv("PORT")) : 8080;
        final URL helloURL = new URL(proto, host, port, "/hello");

        Endpoint.publish(helloURL.toString(), new HelloWorldService());
    }

}

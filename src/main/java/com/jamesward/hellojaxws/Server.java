package com.jamesward.hellojaxws;

import org.apache.cxf.jaxws.EndpointImpl;
import javax.xml.ws.Endpoint;

public class Server {

    public static void main(String[] args) {
        final int port = System.getenv("PORT") != null ? Integer.valueOf(System.getenv("PORT")) : 8080;
        final String publishedEndpointUrl = System.getenv("ENDPOINT_URL");
        final EndpointImpl endpoint = (EndpointImpl)Endpoint.create(new HelloWorldService());

        if (publishedEndpointUrl != null) {
            endpoint.setPublishedEndpointUrl(publishedEndpointUrl + "/hello");
        }

        endpoint.publish("http://0.0.0.0:" + port + "/hello");
    }

}

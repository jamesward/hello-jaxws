package com.jamesward.hellojaxws;

import org.apache.cxf.jaxws.EndpointImpl;
import javax.xml.ws.Endpoint;

public class Server {

    public static void main(String[] args) {
        final int port = System.getenv("PORT") != null ? Integer.valueOf(System.getenv("PORT")) : 8080;
        final String publishedEndpointUrl = System.getenv("ENDPOINT_URL");
        final EndpointImpl helloEndpoint = (EndpointImpl)Endpoint.create(new HelloWorldService());

        if (publishedEndpointUrl != null) {
            helloEndpoint.setPublishedEndpointUrl(publishedEndpointUrl + "/hello");
        }

        helloEndpoint.publish("http://0.0.0.0:" + port + "/hello");

        final EndpointImpl contactEndpoint = (EndpointImpl)Endpoint.create(new ContactService());

        if (publishedEndpointUrl != null) {
            contactEndpoint.setPublishedEndpointUrl(publishedEndpointUrl + "/contact");
        }

        contactEndpoint.publish("http://0.0.0.0:" + port + "/contact");
    }

}

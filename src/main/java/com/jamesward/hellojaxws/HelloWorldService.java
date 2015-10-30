package com.jamesward.hellojaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWorldService {

    @WebMethod
    public String sayHello() {
        return "hello, world";
    }

}

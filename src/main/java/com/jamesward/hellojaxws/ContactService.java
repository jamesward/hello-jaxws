package com.jamesward.hellojaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ContactService {

    @WebMethod
    public Contact getContact() {
        return new Contact("Jon Doe");
    }

    static class Contact {

        public Contact(String name) {
            this.name = name;
        }

        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

}

package com.itsupport.exception;


public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException() {
        super("Client not found !");
    }
}

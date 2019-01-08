package com.inomera.sln;

public class EmsanStart {

    public static void main(String[] args) throws InterruptedException {
        EmsanLogin login = new EmsanLogin();
        login.doLogin();
    }
}

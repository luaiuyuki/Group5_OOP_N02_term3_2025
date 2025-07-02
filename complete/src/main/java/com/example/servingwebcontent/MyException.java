package com.example.servingwebcontent;

public class MyException {
    public static void g() {
        throw new RuntimeException("From g()");
    }
    public static void f() {
        g();
    }
    public static void main(String[] args) {
        f();
    }
}

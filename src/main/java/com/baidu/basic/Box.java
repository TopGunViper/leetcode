package com.baidu.basic;

public class Box<T> {
    private final T t;

    public Box(T t) { this.t = t; }

    public T get() { return t; }
    
}

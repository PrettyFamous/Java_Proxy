package com.company.Proxy;

import com.company.RingBuffer.RingBuffer;
import com.company.RingBuffer.RingBufferImpl;

import java.lang.reflect.Type;

public class ProxyBufferFactory<E> {
    public ProxyBuffer createBuffer (int maxSize){
            return new ProxyBuffer<E>(maxSize);
    }
}
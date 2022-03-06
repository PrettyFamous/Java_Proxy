package com.company.Proxy;
import com.company.RingBuffer.RingBufferImpl;

public class ProxyBuffer<T> extends RingBufferImpl<T> {

    RingBufferImpl<T> buffer;
    private String bufferState;

    public ProxyBuffer(int maxSize){
        super(maxSize);
        buffer = new RingBufferImpl<>(maxSize);
        bufferState = "";
    }

    @Override
    public T peek() {
        long timer = System.nanoTime();
        T elem = buffer.peek();

        if (elem != null)
            System.out.println("Элемент из начала очереди: " + elem);
        else
            System.out.println("Буфер пуст");

        System.out.println("Время на обработку возвращения последнего элемента: "
                + (System.nanoTime()- timer) + " нс");

        return elem;
    }

    @Override
    public int getSize() {
        return buffer.getSize();
    }

    @Override
    public void printBuffer() {
        buffer.printBuffer();
    }

    @Override
    public void add(T item) {
        long timer = System.nanoTime();
        if(buffer.isFull()){
            System.out.println("Элемент \"" + buffer.peek() + "\" будет перезаписан");
        }

        buffer.add(item);

        if (buffer.isFull()){
            bufferState = buffer.toString();
        }
        System.out.println("Элемент добавлен");
        System.out.println("Время на обработку добавления элемента: " + (System.nanoTime()- timer) + " нс");
    }

    @Override
    public T poll() {
        long timer = System.nanoTime();
        T elem = buffer.poll();
        if (elem != null)
            System.out.println("Элемент из начала очереди: " + elem);
        else{
            System.out.println("Буфер пуст");
            if(!bufferState.equals("")) {
                System.out.println("Состояние буфера в последний момент, когда он был полон: "
                        + bufferState);
            }
            else {
                System.out.println("Буфер ещё не был полон");
            }
        }

        System.out.println("Время на обработку удаления элемента: " + (System.nanoTime()- timer) + " нс");
        return elem;
    }
}


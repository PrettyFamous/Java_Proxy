package com.company.RingBuffer;
import java.util.Iterator;

public class RingBufferImpl<E> implements RingBuffer<E> {
    static class Node<E>{
        public E info;
        public Node<E> next;

        public Node(E info){
            this.info = info;
            next = null;
        }
    }
    private Node<E> head;
    private Node<E> tail;
    private int maxSize;
    private int curSize;

    public RingBufferImpl(int maxSize){
        head = null;
        tail = null;
        curSize = 0;
        this.maxSize = maxSize;
    }

    /**
     * Добавляет элемент в конец очереди.
     * Затирает начало очереди в случае, если она заполнена.
     *
     * @param item новый элемент
     */
    public void add(E item){
        Node<E> newItem = new Node<>(item);
        if (curSize == maxSize){
            head = head.next;
            tail.next = newItem;
            tail = newItem;
            tail.next = head;
        }
        else {
            if (curSize == 0){
                head = newItem;
                tail = newItem;
            }
            else{
                tail.next = newItem;
                tail = tail.next;
            }
            tail.next = head;
            curSize++;
        }
    }

    /**
     * Возвращает и удаляет элемент из начала очереди.
     *
     * @return Элемент или {@code null}, если очередь пуста
     */
    public E poll(){
        if (curSize != 0){
            Node<E> tmp = head;
            head = head.next;
            tail.next = head;
            curSize--;
            return tmp.info;
        }
        else
            return null;
    }

    /**
     * Возвращает (но не удаляет) элемент из начала очереди.
     *
     * @return Элемент или {@code null}, если очередь пуста
     */
    public E peek(){
        if (curSize != 0)
            return head.info;
        else
            return null;
    }

    /**
     * Возвращает размер коллекции.
     *
     * @return размер
     */
    public int getSize() {
        return curSize;
    }

    /**
     * Определяет, заполнен ли буфер
     */
    public boolean isFull(){
        return curSize == maxSize;
    }

    /**
     * Выводит очередь в консоль
     */
    public void printBuffer(){
        Node<E> tmp = head;
        if (curSize != 0) {
            System.out.println("Содержимое очереди:");
            do {
                System.out.print(tmp.info.toString() + " ");
                tmp = tmp.next;
            }while (tmp != head);
        }
        else
            System.out.println("Очередь пуста.");
    }

    /**
     * Возвращает содержимое очереди в формате строки
     */
    public String toString(){
        String res = "";
        if (curSize != 0) {
            Node<E> tmp = head;
            do {
                res += tmp.info.toString() + " ";
                tmp = tmp.next;
            }while (tmp != head);
        }
        return res;
    }

    public Iterator<E> iterator(){
        Iterator<E> it = new Iterator<>() {
            private Node<E> node = head;

            public boolean hasNext() {
                return node.next != null;
            }

            public E next() {
                node = node.next;
                return node.info;
            }
        };
        return it;
    }
}

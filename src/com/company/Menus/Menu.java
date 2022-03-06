package com.company.Menus;

import com.company.Utils.Input;

import java.lang.reflect.Type;

public class Menu {
    /**
     * Меню выбора действия с кольцевым буфером
     */
    public static int ActionMenu(){
        System.out.println();
        System.out.println("Выберите действие:");
        System.out.println("1 - добавить элемент");
        System.out.println("2 - вернуть и удалить элемент из начала очереди");
        System.out.println("3 - вернуть, но не удалять элемент из начала очереди");
        System.out.println("4 - вывести очередь на экран");
        System.out.println("0 - выход");
        return Input.inputNum(0, 4, "Введите число: ");
    }
}

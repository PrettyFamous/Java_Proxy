package com.company.Utils;

import com.company.Menus.Menu;
import com.company.Proxy.ProxyBuffer;
import com.company.Proxy.ProxyBufferFactory;

public class Tools {
    public static void MainTask()
    {
        ProxyBuffer<Integer> buffer = InitializeBuffer();
        WorkWithBuffer(buffer);
    }

    public static ProxyBuffer InitializeBuffer()
    {
        ProxyBufferFactory<Integer> bufferFactory = new ProxyBufferFactory<>();
        int size = Input.inputNum(2,20,"Введите размер буфера (от 2 до 20): ");

        return bufferFactory.createBuffer(size);
    }


    public static void WorkWithBuffer(ProxyBuffer proxyBuffer)
    {
        int menuItem;

        do {
            menuItem = Menu.ActionMenu();

            switch (menuItem) {
                case 1:
                    proxyBuffer.add( Input.inputNum("Введите новый элемент: ") );
                    break;
                case 2:
                    proxyBuffer.poll();
                    break;
                case 3:
                    proxyBuffer.peek();
                    break;
                case 4:
                    proxyBuffer.printBuffer();
            }
        } while (menuItem != 0);
    }
}

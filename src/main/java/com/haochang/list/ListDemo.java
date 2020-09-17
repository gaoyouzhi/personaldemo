package com.haochang.list;

import com.haochang.thread.character2.ArrayListMultiThread;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 */
public class ListDemo {


    @Test
    public void testArrayList(){
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()){
            Integer i =  it.next();
            System.out.printf(i.toString() );

//            it.remove(1);
        }
    }
}

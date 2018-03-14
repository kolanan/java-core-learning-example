package org.javacore.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nan on 10:40
 */
public class ArrayListN {
    public static void main(String[] args) {
        listMethod();
    }

    public static void listMethod() {
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
            Object o = it.next();
            if(o.equals("2")) {
                it.remove();
            }

        }


    }
}

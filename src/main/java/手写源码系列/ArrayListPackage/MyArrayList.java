package 手写源码系列.ArrayListPackage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: fang
 * @Date: 2019/11/16 14:46
 * @Description:
 */
public class MyArrayList<E> {

    private Object[] elementData;

    private int size;

    public MyArrayList() {
       elementData = new Object[10];
    }

    public MyArrayList(int size) {
         elementData = new Object[size];
    }


    public void add(E e) {
        elementData[size++] = e;
    }

    public E get(int index) {
        return (E)elementData[index];
    }

    public E set(int index,E e){

        E oldValue = (E)elementData[index];
        elementData[index] = e;
        return oldValue;
    }

    public  E remove(int index){

        E oldValue  = (E)elementData[index];
        elementData[index] =null;
        size--;
        return oldValue;
    }



    public static void main(String[] args) {


        ArrayList  list =new ArrayList(10);
        list.add("1");


        System.out.println(list.get(5));
//        System.out.println(list.get(50));


    }


}

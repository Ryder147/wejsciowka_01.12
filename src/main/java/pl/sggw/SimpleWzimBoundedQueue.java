package pl.sggw;

import java.sql.Array;
import java.util.LinkedList;
import java.util.Queue;

public class SimpleWzimBoundedQueue<E> implements WzimBoundedQueue<E> {



    E[] tab;
    int max;
    // .
    public SimpleWzimBoundedQueue(final int maxCapacity) {

        tab= (E[]) new Object[maxCapacity];
        max=maxCapacity;

    }
    
@Override
    public boolean add(E a){

        for (int i = 0; i < tab.length; i++) {
            if(tab[i]==null){
                tab[i]=a;
                return true;
            }
            else{
                if(i==tab.length-1 && tab[i]!=null){
                    throw new IllegalStateException();
                }
            }
        }


        return false;

    }
@Override
    public boolean offer(E a){

        for (int i = 0; i < tab.length; i++) {
            if(tab[i]==null){
                tab[i]=a;
                return true;

            }


        }


        return false;

    }
@Override
    public E remove(){
        E a= tab[0];

        E[] tab1= (E[]) new Object[tab.length];
        for (int i = 0; i < tab.length-1; i++) {

            tab1[i]=tab[i+1];
        }
        tab=tab1;


        return a;





    }
    @Override
    public E poll(){
        E a= tab[0];

        E[] tab1= (E[]) new Object[tab.length];
        for (int i = 0; i < tab.length-1; i++) {

            tab1[i]=tab[i+1];
        }
        tab=tab1;

        if (a!=null)
            return a;
        else{
            return null;
        }
    }
    @Override
    public E element(){
        return tab[0];
    }
    @Override
    public E peek(){
        return tab[0];
    }
    @Override
    public int size(){
        int licznik=0;
        for (int i = 0; i < tab.length; i++) {
            if(tab[i]!=null){
                licznik+=1;
            }
        }
        return licznik;
    }
    @Override
    public int capacity(){
        return max;
    }



}

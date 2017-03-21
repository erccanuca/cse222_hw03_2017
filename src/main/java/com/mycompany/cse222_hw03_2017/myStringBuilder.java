/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cse222_hw03_2017;

import java.util.Iterator;

/**
 * My string builder class
 * @author ercan
 * @param <E> Generic type
 */
public class myStringBuilder<E> {
    
    private SingleLinkedList<E> singleLinkedlist;

    public myStringBuilder() {
        singleLinkedlist = new SingleLinkedList<>();
    }

    public SingleLinkedList<E> getSingleLinkedlist() {
        return singleLinkedlist;
    }
    
    public SingleLinkedList<E> append(E obj){
        singleLinkedlist.addLast(obj);
        return singleLinkedlist;
    }
    public String toString_index(){
        String str = "";
        for(int i=0; i < singleLinkedlist.size(); ++i){
            str += "\n" + singleLinkedlist.get(i) ;
        }
        return str;
    }
    public String toString_iterator(){
        String str = "";
        Iterator itr = singleLinkedlist.Iterator();
        while(itr.hasNext()){
            str +=  "\n" + itr.next();
        }
        return str;
    }
    public String toString_Linked(){
    
        return toString();
    }
    @Override
    public String toString(){
        return singleLinkedlist.toString();
    }
    
}

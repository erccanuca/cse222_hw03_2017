/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cse222_hw03_2017;

import java.util.AbstractCollection;
import java.util.Collection;

/**
 * My abstract collection class
 * @author ercan
 * @param <E> generic type
 */
public abstract class MyAbstractCollection<E> extends AbstractCollection<E>{

    /**
     * Append anything
     * @param c Collection type
     * @return true if added.
     */
    public boolean appendAnyThing(Collection<? extends E> c){
        
       return super.addAll(c);     
    }
    
}

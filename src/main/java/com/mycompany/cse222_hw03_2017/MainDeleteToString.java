/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cse222_hw03_2017;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author ercan
 */
public class MainDeleteToString {
    
    public static void main(String[] args){
       
        SingleLinkedListDeleteNodes deleted = new SingleLinkedListDeleteNodes();
        
        deleted.deleteToString(1);
        deleted.deleteToString(2);
        deleted.deleteToString(1);
        deleted.deleteToString(3);
        deleted.deleteToString(3);
        
        System.out.println(deleted.toString());
    }
    
}

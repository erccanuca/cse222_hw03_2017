/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cse222_hw03_2017;

/**
 *
 * @author ercan
 */
public class MainReverseToString {
    
      public static void main(String[] args){
          
          SingleLinkedList singleLL = new SingleLinkedList();
          SingleLinkedList singleLL2 = new SingleLinkedList();
          
          singleLL.addLast("ercan");
          
          singleLL.addLast(12.344);
          singleLL2.addLast(12);
          singleLL2.addLast(23);
          singleLL2.addLast(34);
          singleLL.addLast(singleLL2);
          
          System.out.println(singleLL.reverseToString());
          
          
      }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cse222_hw03_2017;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ercan
 */
public class MainStringBuilder {
    
    public static void main(String[] args) throws IOException{
    
    createFileWriteRandomNums();
    
    myStringBuilder strBuild = new myStringBuilder();
    System.out.println("------------------toString(index)-----------------------------------");
    long startTimeIndex = System.currentTimeMillis();
    try
    {
        Scanner scanner = new Scanner(new File("numbers.txt"));
        int [] tall = new int [100000];
        int i = 0;
        while(scanner.hasNextInt())
        {
             tall[i] = scanner.nextInt();
             strBuild.append(tall[i]);
             i++;
        }
        printToFile("result1.txt",strBuild.toString_index());
    }catch(IndexOutOfBoundsException e){
        
        System.err.println("Exception:  " + e.toString());
    }
    long endTimeIndex = System.currentTimeMillis();
    System.out.printf("\nTook approximately %d milisecond\n\n", (endTimeIndex-startTimeIndex));
    System.out.println("--------------------------------------------------------------------");
    
    myStringBuilder strBuild2 = new myStringBuilder();
    System.out.println("------------------toString(iterator)--------------------------------");
    long startTimeIter = System.currentTimeMillis();
    try
    {
        Scanner scanner = new Scanner(new File("numbers.txt"));
        int [] tall = new int [100000];
        int i = 0;
        while(scanner.hasNextInt())
        {
             tall[i] = scanner.nextInt();
             strBuild2.append(tall[i]);
             i++;
        }
        printToFile("result2.txt", strBuild2.toString_iterator());
    }catch(IndexOutOfBoundsException e){
        
        System.err.println("Exception:  " + e.toString());
    }
    
    long endTimeIter = System.currentTimeMillis();
    System.out.printf("\nTook approximately %d milisecond\n\n", (endTimeIter-startTimeIter));
    System.out.println("--------------------------------------------------------------------");
    
    myStringBuilder strBuild3 = new myStringBuilder();
    System.out.println("------------------toString(linked)-----------------------------------");
    long startTimeLinked = System.currentTimeMillis();
    try
    {
        Scanner scanner = new Scanner(new File("numbers.txt"));
        int [] tall = new int [100000];
        int i = 0;
        while(scanner.hasNextInt())
        {
             tall[i] = scanner.nextInt();
             strBuild3.append(tall[i]);
             i++;
        }
        printToFile("result3.txt", strBuild3.toString_Linked());
    }catch(IndexOutOfBoundsException e){
        
        System.err.println("Exception:  " + e.toString());
    }
    
    long endTimeLinked = System.currentTimeMillis();
    System.out.printf("\nTook approximately %d milisecond\n\n", (endTimeLinked-startTimeLinked));
    System.out.println("--------------------------------------------------------------------");
   
    
 }
private static void createFileWriteRandomNums(){

     /*Create random 100000 numbers */
    try{
        try (PrintWriter writer = new PrintWriter("numbers.txt", "UTF-8")) {
            for(int i=0; i<100000; ++i){
                Random r = new Random(); //random sınıfı
                int a = r.nextInt(100);
                writer.println(a); 
            }
        }
    } catch (IOException e) {
        System.err.println("IOException: "+e.toString());
    }
}
private static void printToFile(String filename, String toString){

    try{
        try (PrintWriter writer = new PrintWriter(filename, "UTF-8")) {
            writer.print(toString);
        }
    } catch (IOException e) {
        System.err.println("IOException: "+e.toString());
    }
}

}
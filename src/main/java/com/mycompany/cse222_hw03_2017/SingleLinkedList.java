package com.mycompany.cse222_hw03_2017;

import java.util.*;

/** 
 * Class SingleLinkedList implements a double linked list and a Iterator.
 * @author Ercan
 * @param <E> generic type
 * */

public class SingleLinkedList < E > {
  // Data Fields
  /** A reference to the head of the list. */
  private Node < E > head = null;

  /** A reference to the end of the list. */
  private Node < E > tail = null;

  /** The size of the list. */
  private int size = 0;
  

 //Methods
  public String reverseToString(){
      return reverseToString(this.head);
  }


  private String reverseToString(Node<E> head)
  {
    if( head == null)
        return "";
    else
        return  reverseToString(head.next)+ "\n" + head.data ;
  }
  /**
   * About this class
   * @return about this class
   */
  @Override
  public String toString(){
    String  str = "";
    if(head==null)
        return str;
    for(int i=0; i < size(); ++i)
    {
        str += head.data + "\n";
        head = head.next;
    }
    return str;
  }
  /**
   * Size of list
   * @return Size of list
   */
  public int size() {
    return size;
  }

 /** 
  * Insert an object at the beginning of the list.
  * @param item - the item to be added
  */
  public void addFirst(E item) {
    add(0, item);
  }

  /** 
   * Insert an object at the end of the list.
   * @param item - the item to be added
   */
  public void addLast(E item) {
    add(size, item);
  }

  /** 
   * Get the first element in the list.
   * @return The first element in the list.
   */
  public E getFirst() {
    return head.data;
  }

  /** 
   * Get the last element in the list.
   * @return The last element in the list.
   */
  public E getLast() {
    return tail.data;
  }

  /** 
   * Return a Iterator to the list
   * @return a Iterator to the list
   */
  public Iterator < E > Iterator() {
    return  new MyIterator(0);
  }

  /** 
   * Return a Iterator that begins at index
   * @param index - The position the iteration is to begin
   * @return a Iterator that begins at index
   */
  public Iterator < E > Iterator(int index) {
    return  new MyIterator(index);
  }

 
  /** 
   * Add an item at the specified index.
   * @param index The index at which the object is to be inserted 
   * @param obj The object to be inserted
   * @throws IndexOutOfBoundsException if the index is 
     out of range (i < 0 || i > size())
   */
  public void add(int index, E obj) {
     new MyIterator(index).add(obj);
  }

  /** Get the element at position index.
      @param index Position of item to be retrieved
      @return The item at index
   */
  public E get(int index) {
    return Iterator(index).next();
  }

  // Inner Classes
  /** A Node is the building block for a single-linked list. */
  private static class Node < E > {
    
    /** The data value. */
    private E data;
    /** The link to the next node. */
    private Node < E > next = null;

    /** 
     * Construct a node with the given data value.
     * @param dataItem The data value
     */
    private Node(E dataItem) {
      data = dataItem;
    }
  } //end class Node
  
  /** MyIterator Inner class to implement the Iterator interface. */
  private class MyIterator implements Iterator < E > {
    /** A reference to the next item. */
    private Node < E > nextItem;

    /** A reference to the last item returned. */
    private Node < E > lastItemReturned;

    /** The index of the current item. */
    private int index = 0;

    /** 
     * Construct a MyListIterator that will reference the it item.
     * @param i The index of the item to be referenced
     */
    public MyIterator(int i) {
      // Validate i parameter.
      if (i < 0 || i > size) {
        throw new IndexOutOfBoundsException(
            "Invalid index " + i);
      }
      lastItemReturned = null; // No item returned yet.
      // Special case of last item.
      if (i == size) {
        index = size;
        nextItem = null;
      }
      else { // Start at the beginning
        nextItem = head;
        for (index = 0; index < i; index++) {
          nextItem = nextItem.next;
        }
      }
    }

    /** Indicate whether movement forward is defined.
        @return true if call to next will not throw an exception
     */
    @Override
    public boolean hasNext() {
      return nextItem != null;
    }

    /** Move the iterator forward and return the next item.
        @return The next item in the list
        @throws NoSuchElementException if there is no such object
     */
    @Override
    public E next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      lastItemReturned = nextItem;
      nextItem = nextItem.next;
      index++;
      return lastItemReturned.data;
    }

    
    public void add(E obj) {
      if (head == null) { // Add to an empty list.
        // Create a new node.
        Node < E > newNode = new Node <  > (obj);
        head = newNode;
        tail = head;
      }
     
      else  { // Insert at tail.
       // Create a new node.
       Node < E > newNode = new Node <  > (obj);
       tail.next = newNode; // have (the current tail).next point to the new node
       tail = newNode; // assign 'tail' to point to the new node
       newNode.next = null; // may not be required
      }    
      // Increase size and index and set lastItemReturned.
      size++;
      index++;
      lastItemReturned = null;
    } // End of method add.

    /** Remove the head item. This can only be
     *  done once per call to next or previous.
     *  @throws IllegalStateException if next or previous
     *  was not called prior to calling this method
     */
    @Override
    public void remove() {
        if (head == null)
            return;
        else 
        {
            if (head == tail)
            {
                head = null;
                tail = null;
            } 
            else 
            {
                head = head.next;
            }
        }
      // Invalidate lastItemReturned
      lastItemReturned = null;
      // decrement both size and index
      size--;
      index--;
    }
  } //end class MyListIterator
  
}

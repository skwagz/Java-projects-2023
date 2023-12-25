/*
* Author:  Samuel Kaguima, skaguima2022@my.fit.edu
* Course:  CSE 1002, Fall 2023
* Project: My ArrayList
*/

import java.util.Arrays;

public class MyArrayList extends MyListInterface {

   private Integer [] elements;
   private int size;
   
   public MyArrayList (final int capacity) {
      this.elements = new Integer [capacity];
   }

   public MyArrayList () {
      this(10);
   }

   public int size () {
      return size;
   }

   public void clear () {
      size = 0;
   }

   // Implementation of add using ensureCapacity
   public boolean add (final Integer element) {
      ensureCapacity(size + 1);
      elements[size++] = element;
      return true;
   }
    
   // Implementations of the index
   public Integer get (final int index) {
      if (index > size || index < 0) {
         throw new IndexOutOfBoundsException();
      } 
      return elements[index];
   }

   // Implementation of set 
   public Integer set (final int index, final Integer element) {
      if (index > size || index < 0) {
         throw new IndexOutOfBoundsException();
      } 
      final Integer oldValue = elements[index];
      elements[index] = element;
      return oldValue;
   }

   // Implemetation of remove 
   public Integer remove (final int index) {
      if (index > size || index < 0) {
         throw new IndexOutOfBoundsException();
      } 
      final Integer oldValue = elements[index];
      System.arraycopy(elements, index + 1, elements, index, size - index - 1);
      elements[--size] = null; // clear the last element
      return oldValue;
   }
   
   // Implementation of remove element 
   public boolean remove (final Integer element) {
      for (int i = 0; i < size; i++) {
         if (element.equals (elements[i])) {
            remove(i);
            return true;
         }
      }
      return false;
   }

   // Implementation of toString 
   public String toString () {
      final StringBuilder result = new StringBuilder("[");
      for (int i = 0; i < size; i++) {
         result.append(elements[i]);
         if (i < size - 1) {
            result.append(", ");
         }
      }
      result.append("]");
      return result.toString();
   }




   // copy array into anaother array that is twice its size 
   private void ensureCapacity (final int minCapacity) {
      if (minCapacity > elements.length) {
         final int newCapacity = Math.max(elements.length * 2, minCapacity);
         elements = Arrays.copyOf(elements, newCapacity);
      }
   }

}

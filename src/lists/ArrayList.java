package lists;
import java.util.NoSuchElementException;

import utility.Iterator;
import utility.List;
/**
 * 
 * @author quin
 *
 * @date 06/01/2019
 */


public class ArrayList<E>  implements List<E> {

		private int size;
		private E []  element;
		public final static int DEFAULT_CAPACITY = 100;
		
		
		
		public ArrayList() {
			this(DEFAULT_CAPACITY);
		}
		
		public ArrayList(List<E> other) {
			
		}
		@SuppressWarnings("unchecked")
		public ArrayList( int capacity) {
			if(capacity < 0) {
				throw new IllegalArgumentException("Capacity cannot be less than 0");
			}else {
			element = (E[]) new Object[capacity]; 
			}
	
		}
	
		/****************************************************
		 * appends value to end of list 
		 * @param value 
		 * 
		 ***************************************************/
		public void add(E value) {
			this.element[size] = value;
			size++;
		}
		
		/***************************************************
		 * appends value at given index
		 * @param index 
		 * @param value
		 ***************************************************/
		public void add(int index, E value) {
			this.size = size+1;
			for(int i = index+1; i < size; i++) {
				element[i+1]=element[i];	
			}
			this.element[index] = value;	
		}
		
		/*****************************************************
		 * clears the array of all values 
		 ***************************************************/
		public void clear() {
			size = 0;
		}
		/*****************************************************
		 * 
		 */
		
		public boolean contains(E value) {
			return indexOf(value) >= 0;
		}
		/*****************************************************
		 * gets the element at index given 
		 * @param index
		 ***************************************************/
		public E get(int index) {
			checkIndex(index);
			return element[index];
		
	  }
		/*****************************************************
		 * returns index of the value passed in, if there is no value, it returns -1 
		 * @param value 
		 * @return index of the value 
		 ***************************************************/
		
		public int indexOf(E value) {
			for(int i = 0; i < size; i++) {
				if(element[i] == value) {
					return i+1;
				}
			}
			return -1;	

		}
		/*****************************************************
		 * sees if the ArrayList is empty
		 * @return boolean 
		 ***************************************************/
		
		public boolean isEmpty() {
			return size ==0;
		}
		@SuppressWarnings("unchecked")
			
			
			
			/*
			 * (non-Javadoc)
			 * @see utility.List#iterator()
			 */
			
			public Iterator<E> iterator(){
				
				   E [] temp = (E[]) new Object[size];
				    
				    for (int i=size-1, j=0; i>=0; i--, j++) {
				        
				        temp[j] = element[i];
				    }
				    element =temp;
				    return iterator();
				}

			/*********************************************************
			 * removes value at index and shifts all data to left 
			 * @param index
			 *********************************************************/
			
			public void remove (int index) {
					checkIndex(index);
					for(int i = index;  i<size-1;i++) {
						element[i] =element[i+1];
					}
					size--;
			}
			/********************************************
			 * removes an passed in element
			 * @param element
			 ********************************************/
			public void remove(E element) {
				int in = indexOf(element);
				remove(in);
			}
		/***********************************************************
		 * sets existing index value to the one passed in 
		 * @param index
		 * @param value
		 **********************************************************/
			public void set (int index, E value) {
					checkIndex(index);
					for(int i = 0; i < size; i ++) {
						if(i == index) {
							element[i] = value;
						}
					}
				}
			
			
    /**********************************************************
     * returns the size of the array 
     * @return size of the array 
     ********************************************************* */

		public int size() {
			return size;

		}
		
		
		/***********************************************************
		 * prints the ArrayList as a string 
		 * 
		********************************************************* */
		public String toString() {
			
			if(this.size==0) {
				return "[]";
			}else {
			String result = "[" + element[0]+ "]";
			for(int i = 1; i<this.size; i++) {
				result += ", " + "[" + element[i] + "]";
			}
			result+= "]";
			return result;
			}
		}

		/***********************************************************
		 * checks if the passed in index exists 
		 * @param index
		 **********************************************************/

		private void checkIndex(int index) {
				if(index > size ) {
				throw new IllegalArgumentException("Invalid Index");
				}
			}
		
		
		


		public class ArrayIterator implements Iterator<E>{
			private int index;
			private boolean ableToRemove;
			
			
			/***********************************************************
			 * constructor for the ArrayIterator 
			 **********************************************************/
			
			public ArrayIterator() {
				index = 0;	
			}
			/***********************************************************
			 * checks to see if the ArrayList has a next elements 
			 **********************************************************/
			
			public boolean hasNext() {
			return index < size();
			}
			/************************************************************
			 * @return E next element in the ArrayList
			********************************************************* */
			
			public E next() {
				if(!hasNext()) {
					throw new NoSuchElementException();
				}else {
					E answ = get( index );
					index++;
					return answ;
				}
			}
			/************************************************************
			 * removes value at given index and shifts all elements to the left 
			 * @param index
			 ***********************************************************/
			public void remove(int index) {
				checkIndex(index);
				if(!ableToRemove) {
					throw new IllegalStateException("unable to remove");
				}else {

				ArrayList.this.remove(index-1);
				 }
				
			}
			
			
			
		}
			
					
}
		


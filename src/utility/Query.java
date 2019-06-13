
package utility;

import lists.ArrayList;
/**
 * Operations to compare objects, search and sort them according to some predetermined specification
 * @author quin quintero
 * @date 6/12/19
 *
 */
public class Query {
	
	/**
	 * searches for a particular student record in list
	 * @param list
	 * @param key
	 * @return
	 */
	public static <T extends Comparable<T>> int binarySearch(ArrayList<T> list, T key){ 
		
				for(int i=0; i<list.size();i++) {
					if(list.get(i) == key) {
						return i;
					}
				}
				return -1;
			}
		/**
		 * search for a name in the list 
		 * @param list
		 * @param key
		 * @return
		 */
		public static int indexOf(ArrayList<T> list, String key) {
			for(int i = 0; i<list.size();i++) {
				if((list.get(i).getName()).equals(key)) {
					return i;
				}
			}
			return -1;
		}
	/**
	 * partition method for quick sort algorithm 
	 * @param list
	 * @param left
	 * @param right
	 * @return
	 */
		public static <T extends Comparable<T>> int partition(ArrayList<T> list, int left, int right) {
			
		T pivot = list.get(right);
		int index = left-1;
		
		for(int i = left; i < right; i++) {
			if(list.get(i).compareTo(pivot) < 0) {
				index++;
				
				T temp = list.get(index);
				list.set(index, list.get(i));
				list.set(i,temp);
			}
		}
		
		T temp = list.get(index+1);
		list.set(index+1, list.get(right));
		list.set(right, temp);
		return index;
		
		}
		/**
		 * sorts student records using quick sort algorithm
		 * @param list
		 */
		public static <T extends Comparable<T>> void quickSort(ArrayList<T> list) {
			quickSort(list, 0, list.size()-1);
		}
		/**
		 * sorts student records using quick sort algorithm
		 * @param list
		 * @param left
		 * @param right
		 */
		public static <T extends Comparable<T>> void quickSort(ArrayList<T> list, int left, int right) {
		
		if(left < right) {
		int index = partition(list, left, right);
		quickSort(list, left, index-1);
		quickSort(list, index + 1, right);
	}	
	}
		/**
		 * sorts student records using the selection sort algorithm
		 * @param list
		 * @param key
		 */
	public static <T> void selectionSort(ArrayList<T> list, Comparator<T> key) { 
	
		for(int j = 0; j< list.size()-1; j++) {
			int min = j;
			for(int i = j+1; i < list.size(); i++) {
					
				if(key.compare(list.get(i), list.get(min)) < 0 ) {
					 min = i;
				}
			}
			if(min!=j) {
				 T temp = list.get(j);
				list.set(j , list.get(min)); 
				list.set(min, temp);
				}
			}
		}
	}



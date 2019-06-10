package utility;
/**
 * 
 * @author quin quintero
 *
 * @date 06/01/2019
 */
public interface List<E>{
	
public void add(E value) ;
public void add(int index, E value);
public void clear();
public boolean contains(E value) ;
public E get(int index) ;
public int indexOf(E value);
public boolean isEmpty() ;
public Iterator<E> iterator();
public void remove (int index);
public void remove (E element);
public void set (int index, E value) ;
public int size() ;


}

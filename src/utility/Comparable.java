package utility;
/**
 * 
 * @author quin quintero
 * @date 06/01/2019
 */
@FunctionalInterface
public interface Comparable<T> {
	
	public abstract int compareTo(T o);
	
	
}

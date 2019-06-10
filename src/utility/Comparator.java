package utility;
/**
 * 
 * @author quin
 *
 * @date 06/01/2019
 */
@FunctionalInterface
public interface Comparator<T>{
	public abstract int compare(T o1, T o2);

}

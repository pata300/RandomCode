/**
 * @author Patrick Griffin
 * @since 2/14/2019
 */
public interface MyObserver {
    /**
     * interface for the update() of MyObserver
     * @param o This is a MyObservable to keep track of which MyObservable called the update method
     * @param arg This is a message package that you want want to print when update is called
     */
    public void update(MyObservable o, Object arg);
}
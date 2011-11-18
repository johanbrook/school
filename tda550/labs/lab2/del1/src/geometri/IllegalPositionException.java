package geometri;

/**
 * An <tt>Exception</tt> which is thrown when trying to
 * set an illegal position.
 * A position is illegal if any of its coordinates is negative.
 */
public class IllegalPositionException
       extends Exception {
     
    /**
     * Construct a new <TT>Exception</TT> <i>without</i> 
     * a detail message.
     */
    public IllegalPositionException() {
    super();
    } // constructor IllegalPositionException

    /**
     * Construct a new<TT>Exception</TT> <i>with</i>
     * a detail message.
     * @param message The detail message .
     */
    public IllegalPositionException(String message) {
    super(message);
    } // constructor IllegalPositionException

} // class IllegalPositionException
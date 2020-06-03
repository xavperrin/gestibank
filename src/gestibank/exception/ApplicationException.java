package gestibank.exception;

/**
 * This abstract exception is the superclass of all application exception.
 * It is a checked exception because it extends the Exception class.
 */
public abstract class ApplicationException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8789872817004778566L;

	protected ApplicationException() {
    }

    protected ApplicationException(final String message) {
        super(message);
    }
}
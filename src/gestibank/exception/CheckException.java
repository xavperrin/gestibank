package gestibank.exception;

/**
 * This exception is thrown when some checking validation error is found.
 */
public final class CheckException extends ApplicationException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7270768596228817718L;

	public CheckException(final String message) {
        super(message);
    }
}

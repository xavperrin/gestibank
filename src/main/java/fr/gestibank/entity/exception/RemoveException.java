package fr.gestibank.entity.exception;

/**
 * This exception is thrown when an object cannot be deleted.
 */
public final class RemoveException extends ApplicationException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2230503776573099803L;

	public RemoveException(final String message) {
        super(message);
    }
}
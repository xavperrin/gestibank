package gestibank.exception;

/**
 * This exception is throw when an object already exists in the hashmap
 * and we want to add another one with the same identifier.
 */
public final class DuplicateKeyException extends CreateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1458530516865086671L;
}
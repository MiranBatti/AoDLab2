package se.hig.aod.lab2;

/**
 * Exception class that signals if an operation that is not allowed has been
 * done on a full queue.
 * 
 * @author Miran Batti
 * @author Fredrik Lindorf
 * 
 * @version 2015-12-01
 *
 */
@SuppressWarnings("serial")
public class QueueFullException extends RuntimeException{
	public QueueFullException(String message) {
		super(message);
	}
}

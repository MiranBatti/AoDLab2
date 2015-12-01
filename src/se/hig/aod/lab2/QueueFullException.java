package se.hig.aod.lab2;

@SuppressWarnings("serial")
public class QueueFullException extends RuntimeException{
	public QueueFullException(String message) {
		super(message);
	}
}

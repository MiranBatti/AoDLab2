package se.hig.aod.lab2;

@SuppressWarnings("serial")
public class QueueEmptyException extends RuntimeException {
	public QueueEmptyException(String message) {
		super(message);
	}
}

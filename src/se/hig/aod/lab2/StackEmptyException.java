package se.hig.aod.lab2;

@SuppressWarnings("serial")
public class StackEmptyException extends RuntimeException{
	public StackEmptyException(String message) {
		super(message);
	}
}

package exeptions;

public class VoteExeption extends Exception {

	public VoteExeption() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VoteExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public VoteExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public VoteExeption(String message) {
		super(message);
	}

	public VoteExeption(Throwable cause) {
		super(cause);
	}

}

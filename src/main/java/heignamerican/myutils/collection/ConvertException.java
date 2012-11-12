package heignamerican.myutils.collection;

public class ConvertException extends Exception {
	private static final long serialVersionUID = 1L;

	public ConvertException() {
		super();
	}

	public ConvertException(String aMessage, Throwable aCause) {
		super(aMessage, aCause);
	}

	public ConvertException(String aMessage) {
		super(aMessage);
	}

	public ConvertException(Throwable aCause) {
		super(aCause);
	}

	/**
	 * get real cause. @see java.lang.Throwable#getCause()
	 */
	@Override
	public Throwable getCause() {
		return super.getCause();
	}
}

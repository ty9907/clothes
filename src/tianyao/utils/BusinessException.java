package tianyao.utils;

public class BusinessException extends RuntimeException {

	public BusinessException () {
		super();
	}
	
	public BusinessException (String errorMessage) {
		super(errorMessage);
	}
}

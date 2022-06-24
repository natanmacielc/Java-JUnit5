package br.com.natan.test.unit.domain.exceptions;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private final String code;
	
	public String getCode() {
		return code;
	}
	
	public BusinessException(Throwable cause, String code) {
		super(code, cause);
		this.code = code;
	}
	
	public BusinessException(String code) {
		super(code);
		this.code = code;
	}

}

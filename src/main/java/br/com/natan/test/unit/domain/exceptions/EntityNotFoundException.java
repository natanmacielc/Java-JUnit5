package br.com.natan.test.unit.domain.exceptions;

public class EntityNotFoundException extends BusinessException {

	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundException(String message) {
		super(message);
	}

}

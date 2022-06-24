package br.com.natan.test.unit.domain.exceptions;

public class UserNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(UserNotFoundExceptionId userNotFoundExceptionId) {
		this(String.format("Não existe um cadastro de usuário com o código %d",
				userNotFoundExceptionId.getId()));
	}
	
	public UserNotFoundException() {
		this("Não existe cadastro de usuário");
	}

	public static class UserNotFoundExceptionId {
		private Long id;

		public UserNotFoundExceptionId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return id;
		}

	}

}

package br.com.natan.test.unit.domain.exceptions;

public class MovieNotFoundException extends EntityNotFoundException {
	
	private static final long serialVersionUID = 1L;

	public MovieNotFoundException(String message) {
		super(message);
	}

	public MovieNotFoundException(MovieNotFoundExceptionId movieNotFoundExceptionId) {
		this(String.format("Não existe um cadastro de filme com o código %d",
			movieNotFoundExceptionId.getId()));
	}

	public MovieNotFoundException() {
		this("Não existe cadastro de filme");
	}

	public static class MovieNotFoundExceptionId {
		private Long id;

		public MovieNotFoundExceptionId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return id;
		}

	}
}

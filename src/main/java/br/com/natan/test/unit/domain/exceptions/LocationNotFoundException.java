package br.com.natan.test.unit.domain.exceptions;

public class LocationNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public LocationNotFoundException(String message) {
		super(message);
	}

	public LocationNotFoundException(LocationNotFoundExceptionId locationNotFoundException) {
		this(String.format("Não existe um cadastro de locação com o código %d", locationNotFoundException.getId()));
	}

	public LocationNotFoundException() {
		this("Não existe cadastro de locação");
	}

	public static class LocationNotFoundExceptionId {
		private Long id;

		public LocationNotFoundExceptionId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return id;
		}

	}

}

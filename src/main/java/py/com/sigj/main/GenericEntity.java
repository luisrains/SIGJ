package py.com.sigj.expediente.domain;

public abstract class GenericEntity {
	private static final int RESULT = 1;
	private static final int PRIME = 31;
	public static final int ZERO = 0;

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = RESULT;
		result = prime * result + ((getId() == null) ? ZERO : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		GenericEntity other = (GenericEntity) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!(getId().compareTo(other.getId()) == 0)) {
			return false;
		}
		return true;
	}

	public abstract Long getId();

	public abstract void setId(Long id);
}

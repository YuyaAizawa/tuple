package com.lethe_river.tuple;

public final class Tuple4<T1,T2,T3,T4> {
	public final T1 v1;
	public final T2 v2;
	public final T3 v3;
	public final T4 v4;
	
	public Tuple4(T1 v1, T2 v2, T3 v3, T4 v4) {
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.v4 = v4;
	}
	
	@Override
	public String toString() {
		return "("+v1+", "+v2+", "+v3+", "+v4+")";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		@SuppressWarnings("rawtypes")
		Tuple4 subject = (Tuple4) obj;
		if (v1 == null) {
			if (subject.v1 != null)
				return false;
		} else if (!v1.equals(subject.v1))
			return false;
		
		if (v2 == null) {
			if (subject.v2 != null)
				return false;
		} else if (!v2.equals(subject.v2))
			return false;
		
		if (v3 == null) {
			if (subject.v3 != null)
				return false;
		} else if (!v3.equals(subject.v3))
			return false;
		
		if (v4 == null) {
			if (subject.v4 != null)
				return false;
		} else if (!v4.equals(subject.v4))
			return false;
		
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((v1 == null) ? 0 : v1.hashCode());
		result = prime * result + ((v2 == null) ? 0 : v2.hashCode());
		result = prime * result + ((v3 == null) ? 0 : v3.hashCode());
		result = prime * result + ((v4 == null) ? 0 : v4.hashCode());
		return result;
	}
}

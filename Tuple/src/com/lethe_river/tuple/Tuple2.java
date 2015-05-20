package com.lethe_river.tuple;

// イミュータブルなタプルを表すクラス　あると何かと便利
//  要素数固定とジェネリクスでコンパイル時の型チェックがきく
public final class Tuple2<T1,T2> {
	public final T1 v1;
	public final T2 v2;
	
	public Tuple2(T1 v1, T2 v2) {
		this.v1 = v1;
		this.v2 = v2;
	}
	
	@Override
	public String toString() {
		return "("+v1+", "+v2+")";
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
		Tuple2 subject = (Tuple2) obj;
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
		
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((v1 == null) ? 0 : v1.hashCode());
		result = prime * result + ((v2 == null) ? 0 : v2.hashCode());
		return result;
	}
}

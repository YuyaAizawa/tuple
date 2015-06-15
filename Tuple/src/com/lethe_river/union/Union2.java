package com.lethe_river.union;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public final class Union2<T1, T2> {
	
	private interface Member<T1, T2> {
		public <R> R match(Function<T1, R> f1, Function<T2, R> f2);
		public void match(Consumer<T1> f1, Consumer<T2> f2);
		public Object getValue();
	}

	private final Member<T1, T2> member;
	
	public static <T1, T2> Union2<T1, T2> _1(T1 value) {
		Objects.nonNull(value);
		return new Union2<T1, T2>(new Member1<>(value));
	}
	
	public static <T1, T2> Union2<T1, T2> _2(T2 value) {
		Objects.nonNull(value);
		return new Union2<T1, T2>(new Member2<>(value));
	}
	
	public <R> R match(Function<T1, R> f1, Function<T2, R> f2) {
		return member.match(f1, f2);
	}
	
	public void match(Consumer<T1> f1, Consumer<T2> f2) {
		member.match(f1, f2);
	}
	
	public Optional<T1> get1() {
		return Optional.ofNullable(match(t1 -> t1, t2 -> null));
	}
	
	public Optional<T2> get2() {
		return Optional.ofNullable(match(t1 -> null, t2 -> t2));
	}
	
	@Override
	public int hashCode() {
		return member.getValue().hashCode();
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
		Object other = ((Union2)obj).member.getValue();
		return member.getValue().equals(other);
	}

	private Union2(Member<T1, T2> member) {
		this.member = member;
	}
	
	private static class Member1<T1, T2> implements Member<T1, T2> {
		
		private final T1 value;
		
		Member1(T1 value) {
			this.value = value;
		}
		
		@Override
		public <R> R match(Function<T1, R> f1, Function<T2, R> f2) {
			return f1.apply(value);
		}
		
		@Override
		public void match(Consumer<T1> f1, Consumer<T2> f2) {
			f1.accept(value);
		}
		
		@Override
		public Object getValue() {
			return value;
		}
	}
	
	private static class Member2<T1, T2> implements Member<T1, T2> {
		
		private final T2 value;
		
		Member2(T2 value) {
			this.value = value;
		}
		
		@Override
		public <R> R match(Function<T1, R> f1, Function<T2, R> f2) {
			return f2.apply(value);
		}
		
		@Override
		public void match(Consumer<T1> f1, Consumer<T2> f2) {
			f2.accept(value);
		}
		
		@Override
		public Object getValue() {
			return value;
		}
	}
}

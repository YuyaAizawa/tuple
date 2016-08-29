package com.lethe_river.algebra.union;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public final class Union3<T1, T2, T3> {
	
	private interface Member<T1, T2, T3> {
		public <R> R match(Function<T1, R> f1, Function<T2, R> f2, Function<T3, R> f3);
		public void match(Consumer<T1> f1, Consumer<T2> f2, Consumer<T3> f3);
		public Object getValue();
	}
	
	private final Member<T1, T2, T3> member;
	
	public static <T1, T2, T3> Union3<T1, T2, T3> of1(T1 value) {
		return new Union3<T1, T2, T3>(new Member1<>(Objects.requireNonNull(value)));
	}
	@Deprecated
	public static <T1, T2, T3> Union3<T1, T2, T3> _1(T1 value) {
		return of1(value);
	}
	
	public static <T1, T2, T3> Union3<T1, T2, T3> of2(T2 value) {
		return new Union3<T1, T2, T3>(new Member2<>(Objects.requireNonNull(value)));
	}
	@Deprecated
	public static <T1, T2, T3> Union3<T1, T2, T3> _2(T2 value) {
		return of2(value);
	}
	
	public static <T1, T2, T3> Union3<T1, T2, T3> of3(T3 value) {
		return new Union3<T1, T2, T3>(new Member3<>(Objects.requireNonNull(value)));
	}
	@Deprecated
	public static <T1, T2, T3> Union3<T1, T2, T3> _3(T3 value) {
		return of3(value);
	}
	
	public <R> R match(Function<T1, R> f1, Function<T2, R> f2, Function<T3, R> f3) {
		return member.match(f1, f2, f3);
	}
	
	public void match(Consumer<T1> f1, Consumer<T2> f2, Consumer<T3> f3) {
		member.match(f1, f2, f3);
	}
	
	public Optional<T1> get1() {
		return Optional.ofNullable(match(t1 -> t1, t2 -> null, t3 -> null));
	}
	
	public Optional<T2> get2() {
		return Optional.ofNullable(match(t1 -> null, t2 -> t2, t3 -> null));
	}
	
	public Optional<T3> get3() {
		return Optional.ofNullable(match(t1 -> null, t2 -> null, t3 -> t3));
	}
	
	@Override
	public String toString() {
		return match(T1::toString, T2::toString, T3::toString);
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
		Object other = ((Union3)obj).member.getValue();
		return member.getValue().equals(other);
	}
	
	private Union3(Member<T1, T2, T3> member) {
		this.member = member;
	}
	
	
	
	private static final class Member1<T1, T2, T3> implements Member<T1, T2, T3> {
		
		private final T1 value;
		
		Member1(T1 value) {
			this.value = value;
		}
		
		@Override
		public <R> R match(Function<T1, R> f1, Function<T2, R> f2, Function<T3, R> f3) {
			return f1.apply(value);
		}
		
		@Override
		public void match(Consumer<T1> f1, Consumer<T2> f2, Consumer<T3> f3) {
			f1.accept(value);
		}
		
		@Override
		public Object getValue() {
			return value;
		}
	}
	
	private static final class Member2<T1, T2, T3> implements Member<T1, T2, T3> {
		
		private final T2 value;
		
		Member2(T2 value) {
			this.value = value;
		}
		
		@Override
		public <R> R match(Function<T1, R> f1, Function<T2, R> f2, Function<T3, R> f3) {
			return f2.apply(value);
		}
		
		@Override
		public void match(Consumer<T1> f1, Consumer<T2> f2, Consumer<T3> f3) {
			f2.accept(value);
		}
		
		@Override
		public Object getValue() {
			return value;
		}
	}
	
	private static final class Member3<T1, T2, T3> implements Member<T1, T2, T3> {
		
		private final T3 value;
		
		Member3(T3 value) {
			this.value = value;
		}
		
		@Override
		public <R> R match(Function<T1, R> f1, Function<T2, R> f2, Function<T3, R> f3) {
			return f3.apply(value);
		}
		
		@Override
		public void match(Consumer<T1> f1, Consumer<T2> f2, Consumer<T3> f3) {
			f3.accept(value);
		}
		
		@Override
		public Object getValue() {
			return value;
		}
	}
}

package com.lethe_river.union;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public final class Union5<T1, T2, T3, T4, T5> {
	
	private interface Member<T1, T2, T3, T4, T5> {
		public <R> R match(Function<T1, R> f1, Function<T2, R> f2, Function<T3, R> f3, Function<T4, R> f4, Function<T5, R> f5);
		public void match(Consumer<T1> f1, Consumer<T2> f2, Consumer<T3> f3, Consumer<T4> f4, Consumer<T5> f5);
		public Object getValue();
	}
	
	private final Member<T1, T2, T3, T4, T5> member;
	
	public static <T1, T2, T3, T4, T5> Union5<T1, T2, T3, T4, T5> _1(T1 value) {
		Objects.nonNull(value);
		return new Union5<T1, T2, T3, T4, T5>(new Member1<>(value));
	}
	
	public static <T1, T2, T3, T4, T5> Union5<T1, T2, T3, T4, T5> _2(T2 value) {
		Objects.nonNull(value);
		return new Union5<T1, T2, T3, T4, T5>(new Member2<>(value));
	}
	
	public static <T1, T2, T3, T4, T5> Union5<T1, T2, T3, T4, T5> _3(T3 value) {
		Objects.nonNull(value);
		return new Union5<T1, T2, T3, T4, T5>(new Member3<>(value));
	}
	
	public static <T1, T2, T3, T4, T5> Union5<T1, T2, T3, T4, T5> _4(T4 value) {
		Objects.nonNull(value);
		return new Union5<T1, T2, T3, T4, T5>(new Member4<>(value));
	}
	
	public static <T1, T2, T3, T4, T5> Union5<T1, T2, T3, T4, T5> _5(T5 value) {
		Objects.nonNull(value);
		return new Union5<T1, T2, T3, T4, T5>(new Member5<>(value));
	}
	
	public <R> R match(Function<T1, R> f1, Function<T2, R> f2, Function<T3, R> f3, Function<T4, R> f4, Function<T5, R> f5) {
		return member.match(f1, f2, f3, f4, f5);
	}
	
	public void match(Consumer<T1> f1, Consumer<T2> f2, Consumer<T3> f3, Consumer<T4> f4, Consumer<T5> f5) {
		member.match(f1, f2, f3, f4, f5);
	}
	
	public Optional<T1> get1() {
		return Optional.ofNullable(match(t1 -> t1, t2 -> null, t3 -> null, t4 -> null, t5 -> null));
	}
	
	public Optional<T2> get2() {
		return Optional.ofNullable(match(t1 -> null, t2 -> t2, t3 -> null, t4 -> null, t5 -> null));
	}
	
	public Optional<T3> get3() {
		return Optional.ofNullable(match(t1 -> null, t2 -> null, t3 -> t3, t4 -> null, t5 -> null));
	}
	
	public Optional<T4> get4() {
		return Optional.ofNullable(match(t1 -> null, t2 -> null, t3 -> null, t4 -> t4, t5 -> null));
	}
	
	public Optional<T5> get5() {
		return Optional.ofNullable(match(t1 -> null, t2 -> null, t3 -> null, t4 -> null, t5 -> t5));
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
		Object other = ((Union5)obj).member.getValue();
		return member.getValue().equals(other);
	}
	
	private Union5(Member<T1, T2, T3, T4, T5> member) {
		this.member = member;
	}
	
	
	
	private static final class Member1<T1, T2, T3, T4, T5> implements Member<T1, T2, T3, T4, T5> {
		
		private final T1 value;
		
		Member1(T1 value) {
			this.value = value;
		}
		
		@Override
		public <R> R match(Function<T1, R> f1, Function<T2, R> f2, Function<T3, R> f3, Function<T4, R> f4, Function<T5, R> f5) {
			return f1.apply(value);
		}
		
		@Override
		public void match(Consumer<T1> f1, Consumer<T2> f2, Consumer<T3> f3, Consumer<T4> f4, Consumer<T5> f5) {
			f1.accept(value);
		}
		
		@Override
		public Object getValue() {
			return value;
		}
	}
	
	private static final class Member2<T1, T2, T3, T4, T5> implements Member<T1, T2, T3, T4, T5> {
		
		private final T2 value;
		
		Member2(T2 value) {
			this.value = value;
		}
		
		@Override
		public <R> R match(Function<T1, R> f1, Function<T2, R> f2, Function<T3, R> f3, Function<T4, R> f4, Function<T5, R> f5) {
			return f2.apply(value);
		}
		
		@Override
		public void match(Consumer<T1> f1, Consumer<T2> f2, Consumer<T3> f3, Consumer<T4> f4, Consumer<T5> f5) {
			f2.accept(value);
		}
		
		@Override
		public Object getValue() {
			return value;
		}
	}
	
	private static final class Member3<T1, T2, T3, T4, T5> implements Member<T1, T2, T3, T4, T5> {
		
		private final T3 value;
		
		Member3(T3 value) {
			this.value = value;
		}
		
		@Override
		public <R> R match(Function<T1, R> f1, Function<T2, R> f2, Function<T3, R> f3, Function<T4, R> f4, Function<T5, R> f5) {
			return f3.apply(value);
		}
		
		@Override
		public void match(Consumer<T1> f1, Consumer<T2> f2, Consumer<T3> f3, Consumer<T4> f4, Consumer<T5> f5) {
			f3.accept(value);
		}
		
		@Override
		public Object getValue() {
			return value;
		}
	}
	
	private static final class Member4<T1, T2, T3, T4, T5> implements Member<T1, T2, T3, T4, T5> {
		
		private final T4 value;
		
		Member4(T4 value) {
			this.value = value;
		}
		
		@Override
		public <R> R match(Function<T1, R> f1, Function<T2, R> f2, Function<T3, R> f3, Function<T4, R> f4, Function<T5, R> f5) {
			return f4.apply(value);
		}
		
		@Override
		public void match(Consumer<T1> f1, Consumer<T2> f2, Consumer<T3> f3, Consumer<T4> f4, Consumer<T5> f5) {
			f4.accept(value);
		}
		
		@Override
		public Object getValue() {
			return value;
		}
	}
	
	private static final class Member5<T1, T2, T3, T4, T5> implements Member<T1, T2, T3, T4, T5> {
		
		private final T5 value;
		
		Member5(T5 value) {
			this.value = value;
		}
		
		@Override
		public <R> R match(Function<T1, R> f1, Function<T2, R> f2, Function<T3, R> f3, Function<T4, R> f4, Function<T5, R> f5) {
			return f5.apply(value);
		}
		
		@Override
		public void match(Consumer<T1> f1, Consumer<T2> f2, Consumer<T3> f3, Consumer<T4> f4, Consumer<T5> f5) {	
			f5.accept(value);
		}
		
		@Override
		public Object getValue() {
			return value;
		}
	}
}

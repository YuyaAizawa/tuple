package com.lethe_river.algebra.union;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 型パラメータで指定した，いずれかの型の要素を持つコンテナ・オブジェクト．
 * T1, T2, T3, T4のいずれかの型の要素を持つオブジェクトを定義し，操作を提供する．
 * ユーザーはこのオブジェクトに対し，要素の可能性のある型それぞれに対する操作を記述することで，複数の型を統一的に扱うことができる．
 * 型パラメータT1, T2, T3, T4には異なる型が指定されることを想定している．
 * 
 * @author YuyaAizawa
 *
 * @param <T1>
 * @param <T2>
 * @param <T3>
 * @param <T4>
 */
public final class Union4<T1, T2, T3, T4> {
	
	private interface Member<T1, T2, T3, T4> {
		public <R> R match(
				Function<? super T1, ? extends R> f1,
				Function<? super T2, ? extends R> f2,
				Function<? super T3, ? extends R> f3,
				Function<? super T4, ? extends R> f4);
		public void match(
				Consumer<? super T1> c1,
				Consumer<? super T2> c2,
				Consumer<? super T3> c3,
				Consumer<? super T4> c4);
		public Object getValue();
	}

	private final Member<T1, T2, T3, T4> member;


	/**
	 * 指定されたT1型の要素を持つ新しいUnion4を返す．
	 * 
	 * @param value
	 * @return 新しいUnion4
	 * @exception NullPointerException valueがnullの場合
	 */
	public static <T1, T2, T3, T4> Union4<T1, T2, T3, T4> of1(T1 value) {
		return new Union4<T1, T2, T3, T4>(new Member1<>(Objects.requireNonNull(value)));
	}

	/**
	 * 指定されたT1型の要素を持つ新しいUnion4を返す．
	 * 
	 * @deprecated {@link Union2#of1(Object) Union4#of1(T1)}に置き換えられた
	 * 
	 * @param value
	 * @return 新しいUnion4
	 * @exception NullPointerException valueがnullの場合
	 */
	public static <T1, T2, T3, T4> Union4<T1, T2, T3, T4> _1(T1 value) {
		return of1(value);
	}

	/**
	 * 指定されたT2型の要素を持つ新しいUnion4を返す．
	 * 
	 * @param value
	 * @return 新しいUnion4
	 * @exception NullPointerException valueがnullの場合
	 */
	public static <T1, T2, T3, T4> Union4<T1, T2, T3, T4> of2(T2 value) {
		return new Union4<T1, T2, T3, T4>(new Member2<>(Objects.requireNonNull(value)));
	}

	/**
	 * 指定されたT2型の要素を持つ新しいUnion4を返す．
	 * 
	 * @deprecated {@link Union2#of1(Object) Union4#of2(T2)}に置き換えられた
	 * 
	 * @param value
	 * @return 新しいUnion4
	 * @exception NullPointerException valueがnullの場合
	 */
	public static <T1, T2, T3, T4> Union4<T1, T2, T3, T4> _2(T2 value) {
		return of2(value);
	}

	/**
	 * 指定されたT3型の要素を持つ新しいUnion4を返す．
	 * 
	 * @param value
	 * @return 新しいUnion4
	 * @exception NullPointerException valueがnullの場合
	 */
	public static <T1, T2, T3, T4> Union4<T1, T2, T3, T4> of3(T3 value) {
		return new Union4<T1, T2, T3, T4>(new Member3<>(Objects.requireNonNull(value)));
	}

	/**
	 * 指定されたT3型の要素を持つ新しいUnion4を返す．
	 * 
	 * @deprecated {@link Union2#of1(Object) Union4#of3(T3)}に置き換えられた
	 * 
	 * @param value
	 * @return 新しいUnion4
	 * @exception NullPointerException valueがnullの場合
	 */
	public static <T1, T2, T3, T4> Union4<T1, T2, T3, T4> _3(T3 value) {
		return of3(value);
	}

	/**
	 * 指定されたT4型の要素を持つ新しいUnion4を返す．
	 * 
	 * @param value
	 * @return 新しいUnion4
	 * @exception NullPointerException valueがnullの場合
	 */
	public static <T1, T2, T3, T4> Union4<T1, T2, T3, T4> of4(T4 value) {
		return new Union4<T1, T2, T3, T4>(new Member4<>(Objects.requireNonNull(value)));
	}

	/**
	 * 指定されたT4型の要素を持つ新しいUnion4を返す．
	 * 
	 * @deprecated {@link Union2#of1(Object) Union4#of4(T4)}に置き換えられた
	 * 
	 * @param value
	 * @return 新しいUnion4
	 * @exception NullPointerException valueがnullの場合
	 */
	public static <T1, T2, T3, T4> Union4<T1, T2, T3, T4> _4(T4 value) {
		return of4(value);
	}

	/**
	 * 要素に関数を適用し，結果を返す．
	 * 与えたそれぞれの関数のうち，要素の型に対する関数が適用され，結果が返る．
	 * 与える関数の戻り値の型は一致していなければならない．
	 * 
	 * @param f1 T1に適用する関数
	 * @param f2 T2に適用する関数
	 * @param f3 T3に適用する関数
	 * @param f4 T4に適用する関数
	 * @return 関数の戻り値
	*/
	public <R> R map(
				Function<? super T1, ? extends R> f1,
				Function<? super T2, ? extends R> f2,
				Function<? super T3, ? extends R> f3,
				Function<? super T4, ? extends R> f4) {
		return member.match(f1, f2, f3, f4);
	}

	/**
	 * 要素に関数を適用し，結果を返す．
	 * 与えたそれぞれの関数のうち，要素の型に対する関数が適用され，結果が返る．
	 * 与える関数の戻り値の型は一致していなければならない．
	 * 
	 * @deprecated {@link Union4#map(Function, Function, Function, Function) Union4#map(Function&lt? super T1, ? extends R&gt;1, Function&lt? super T2, ? extends R&gt;2, Function&lt? super T3, ? extends R&gt;3, Function&lt? super T4, ? extends R&gt;4 }に置き換えられた
	 * 
	 * @param f1 T1に適用する関数
	 * @param f2 T2に適用する関数
	 * @param f3 T3に適用する関数
	 * @param f4 T4に適用する関数
	 * @return 関数の戻り値
	*/
	public <R> R match(
				Function<? super T1, ? extends R> f1,
				Function<? super T2, ? extends R> f2,
				Function<? super T3, ? extends R> f3,
				Function<? super T4, ? extends R> f4) {
		return map(f1, f2, f3, f4);
	}
	
	/**
	 * 要素に対してオペレーションを実行する．
	 * 与えたそれぞれのオペレーションのうち，要素の型に対するオペレーションが実行される．
	 * 
	 * @param f1 T1に対するオペレーション
	 * @param f2 T2に対するオペレーション
	 * @param f3 T3に対するオペレーション
	 * @param f4 T4に対するオペレーション
	 */
	public void match(
				Consumer<? super T1> c1,
				Consumer<? super T2> c2,
				Consumer<? super T3> c3,
				Consumer<? super T4> c4) {
		member.match(c1, c2, c3, c4);
	}

	
	/**
	 * このインスタンスのT1型の要素を返す．
	 * このインスタンスのT1型の要素を表すOptionalを返す．要素がT1型でない場合は空のOptionalを返す．
	 * 
	 * @return T1型の要素を表すOptional,または空のOptional
	 */
	public Optional<T1> get1() {
		return Optional.ofNullable(map(t1 -> t1, t2 -> null, t3 -> null, t4 -> null));
	}
	
	/**
	 * このインスタンスのT2型の要素を返す．
	 * このインスタンスのT2型の要素を表すOptionalを返す．要素がT2型でない場合は空のOptionalを返す．
	 * 
	 * @return T2型の要素を表すOptional,または空のOptional
	 */
	public Optional<T2> get2() {
		return Optional.ofNullable(map(t1 -> null, t2 -> t2, t3 -> null, t4 -> null));
	}
	
	/**
	 * このインスタンスのT3型の要素を返す．
	 * このインスタンスのT3型の要素を表すOptionalを返す．要素がT3型でない場合は空のOptionalを返す．
	 * 
	 * @return T3型の要素を表すOptional,または空のOptional
	 */
	public Optional<T3> get3() {
		return Optional.ofNullable(map(t1 -> null, t2 -> null, t3 -> t3, t4 -> null));
	}
	
	/**
	 * このインスタンスのT4型の要素を返す．
	 * このインスタンスのT4型の要素を表すOptionalを返す．要素がT4型でない場合は空のOptionalを返す．
	 * 
	 * @return T4型の要素を表すOptional,または空のOptional
	 */
	public Optional<T4> get4() {
		return Optional.ofNullable(map(t1 -> null, t2 -> null, t3 -> null, t4 -> t4));
	}

	/**
	 * 要素の文字列表現を返す.
	 * 
	 * @return 要素の文字列表現
	 */
	@Override
	public String toString() {
		return map(T1::toString, T2::toString, T3::toString, T4::toString);
	}
	
	/**
	 * 要素に基づくハッシュを返す．
	 * 
	 * @return 要素に基づくハッシュ
	 */
	@Override
	public int hashCode() {
		return member.getValue().hashCode();
	}
	
	/**
	 * 指定されたオブジェクトがUnion4と等しいか比較する．
	 * 指定されたオブジェクトもUnion4であり，内部の要素が等しいときにtrueをかえす．
	 * 
	 * @return 指定されたオブジェクトがUnionと等しい場合は true
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		Object other = ((Union4)obj).member.getValue();
		return member.getValue().equals(other);
	}

	private Union4(Member<T1, T2, T3, T4> member) {
		this.member = member;
	}

	
	private static class Member1<T1, T2, T3, T4> implements Member<T1, T2, T3, T4> {
		
		private final T1 value;
		
		Member1(T1 value) {
			this.value = value;
		}
		
		@Override
		public <R> R match(
				Function<? super T1, ? extends R> f1,
				Function<? super T2, ? extends R> f2,
				Function<? super T3, ? extends R> f3,
				Function<? super T4, ? extends R> f4) {
			return f1.apply(value);
		}
		
		@Override
		public void match(
				Consumer<? super T1> c1,
				Consumer<? super T2> c2,
				Consumer<? super T3> c3,
				Consumer<? super T4> c4) {
			c1.accept(value);
		}
		
		@Override
		public Object getValue() {
			return value;
		}
	}
	
	private static class Member2<T1, T2, T3, T4> implements Member<T1, T2, T3, T4> {
		
		private final T2 value;
		
		Member2(T2 value) {
			this.value = value;
		}
		
		@Override
		public <R> R match(
				Function<? super T1, ? extends R> f1,
				Function<? super T2, ? extends R> f2,
				Function<? super T3, ? extends R> f3,
				Function<? super T4, ? extends R> f4) {
			return f2.apply(value);
		}
		
		@Override
		public void match(
				Consumer<? super T1> c1,
				Consumer<? super T2> c2,
				Consumer<? super T3> c3,
				Consumer<? super T4> c4) {
			c2.accept(value);
		}
		
		@Override
		public Object getValue() {
			return value;
		}
	}
	
	private static class Member3<T1, T2, T3, T4> implements Member<T1, T2, T3, T4> {
		
		private final T3 value;
		
		Member3(T3 value) {
			this.value = value;
		}
		
		@Override
		public <R> R match(
				Function<? super T1, ? extends R> f1,
				Function<? super T2, ? extends R> f2,
				Function<? super T3, ? extends R> f3,
				Function<? super T4, ? extends R> f4) {
			return f3.apply(value);
		}
		
		@Override
		public void match(
				Consumer<? super T1> c1,
				Consumer<? super T2> c2,
				Consumer<? super T3> c3,
				Consumer<? super T4> c4) {
			c3.accept(value);
		}
		
		@Override
		public Object getValue() {
			return value;
		}
	}
	
	private static class Member4<T1, T2, T3, T4> implements Member<T1, T2, T3, T4> {
		
		private final T4 value;
		
		Member4(T4 value) {
			this.value = value;
		}
		
		@Override
		public <R> R match(
				Function<? super T1, ? extends R> f1,
				Function<? super T2, ? extends R> f2,
				Function<? super T3, ? extends R> f3,
				Function<? super T4, ? extends R> f4) {
			return f4.apply(value);
		}
		
		@Override
		public void match(
				Consumer<? super T1> c1,
				Consumer<? super T2> c2,
				Consumer<? super T3> c3,
				Consumer<? super T4> c4) {
			c4.accept(value);
		}
		
		@Override
		public Object getValue() {
			return value;
		}
	}
}
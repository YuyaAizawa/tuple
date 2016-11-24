package com.lethe_river.algebra.union;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 型パラメータで指定した，いずれかの型の要素を持つコンテナ・オブジェクト．
 * T1, T2のいずれかの型の要素を持つオブジェクトを定義し，操作を提供する．
 * ユーザーはこのオブジェクトに対し，要素の可能性のある型それぞれに対する操作を記述することで，複数の型を統一的に扱うことができる．
 * 型パラメータT1, T2には異なる型が指定されることを想定している．
 * 
 * @author YuyaAizawa
 *
 * @param <T1>
 * @param <T2>
 * 
 */

public class Union2<T1, T2> {
	
	private interface Member<T1, T2> {
		public <R> R match(
				Function<? super T1, ? extends R> f1,
				Function<? super T2, ? extends R> f2);
		public void matchDo(
				Consumer<? super T1> c1,
				Consumer<? super T2> c2);
		public Object getValue();
	}
	
	private final Member<T1, T2> member;

	
	/**
	 * 指定されたT1型の要素を持つ新しいUnion2を返す．
	 * 
	 * @param value
	 * @return 新しいUnion2
	 * @exception NullPointerException valueがnullの場合
	 */
	public static <T1, T2> Union2<T1, T2> of1(T1 value) {
		return new Union2<T1, T2>(new Member1<>(Objects.requireNonNull(value)));
	}
	
	/**
	 * 指定されたT1型の要素を持つ新しいUnion2を返す．
	 * 
	 * @deprecated {@link Union2#of1(Object) Union2#of1(T1)}に置き換えられた
	 * 
	 * @param value
	 * @return 新しいUnion2
	 * @exception NullPointerException valueがnullの場合
	 */
	public static <T1, T2> Union2<T1, T2> _1(T1 value) {
		return of1(value);
	}
	
	/**
	 * 指定されたT2型の要素を持つ新しいUnion2を返す．
	 * 
	 * @param value
	 * @return 新しいUnion2
	 * @exception NullPointerException valueがnullの場合
	 */
	public static <T1, T2> Union2<T1, T2> of2(T2 value) {
		return new Union2<T1, T2>(new Member2<>(Objects.requireNonNull(value)));
	}
	
	/**
	 * 指定されたT2型の要素を持つ新しいUnion2を返す．
	 * 
	 * @deprecated {@link Union2#of1(Object) Union2#of2(T2)}に置き換えられた
	 * 
	 * @param value
	 * @return 新しいUnion2
	 * @exception NullPointerException valueがnullの場合
	 */
	public static <T1, T2> Union2<T1, T2> _2(T2 value) {
		return of2(value);
	}
	
	/**
	 * 要素に関数を適用し，結果を返す．
	 * 与えたそれぞれの関数のうち，要素の型に対する関数が適用され，結果が返る．
	 * 与える関数の戻り値の型は一致していなければならない．
	 * 
	 * @param f1 T1に適用する関数
	 * @param f2 T2に適用する関数
	 * @return 関数の戻り値
	*/
	public final <R> R match(
				Function<? super T1, ? extends R> f1,
				Function<? super T2, ? extends R> f2) {
		return member.match(f1, f2);
	}
	
	/**
	 * 要素に対してオペレーションを実行する．
	 * 与えたそれぞれのオペレーションのうち，要素の型に対するオペレーションが実行される．
	 * 
	 * @param f1 T1に対するオペレーション
	 * @param f2 T2に対するオペレーション
	 */
	public final void matchDo(
				Consumer<? super T1> c1,
				Consumer<? super T2> c2) {
		member.matchDo(c1, c2);
	}

	
	/**
	 * このインスタンスのT1型の要素を返す．
	 * このインスタンスのT1型の要素を表すOptionalを返す．要素がT1型でない場合は空のOptionalを返す．
	 * 
	 * @return T1型の要素を表すOptional,または空のOptional
	 */
	public Optional<T1> get1() {
		return Optional.ofNullable(match(t1 -> t1, t2 -> null));
	}
	
	/**
	 * このインスタンスのT2型の要素を返す．
	 * このインスタンスのT2型の要素を表すOptionalを返す．要素がT2型でない場合は空のOptionalを返す．
	 * 
	 * @return T2型の要素を表すOptional,または空のOptional
	 */
	public Optional<T2> get2() {
		return Optional.ofNullable(match(t1 -> null, t2 -> t2));
	}
	
	/**
	 * 要素の文字列表現を返す.
	 * 
	 * @return 要素の文字列表現
	 */
	@Override
	public String toString() {
		return match(T1::toString, T2::toString);
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
	 * 指定されたオブジェクトがUnion2と等しいか比較する．
	 * 指定されたオブジェクトもUnion2であり，内部の要素が等しいときにtrueをかえす．
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
		Object other = ((Union2)obj).member.getValue();
		return member.getValue().equals(other);
	}

	private Union2(Member<T1, T2> member) {
		this.member = member;
	}

	/**
	 * 指定されたUnion2を用いてインスタンスを初期化する．
	 * このクラスを継承したクラスを作るときに利用する．
	 *
	 * @param base 初期化に用いるインスタンス
	 */
	protected Union2(Union2<T1, T2> base) {
		this.member = base.member;
	}

	
	private static class Member1<T1, T2> implements Member<T1, T2> {
		
		private final T1 value;
		
		Member1(T1 value) {
			this.value = value;
		}
		
		@Override
		public <R> R match(
				Function<? super T1, ? extends R> f1,
				Function<? super T2, ? extends R> f2) {
			return f1.apply(value);
		}
		
		@Override
		public void matchDo(
				Consumer<? super T1> c1,
				Consumer<? super T2> c2) {
			c1.accept(value);
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
		public <R> R match(
				Function<? super T1, ? extends R> f1,
				Function<? super T2, ? extends R> f2) {
			return f2.apply(value);
		}
		
		@Override
		public void matchDo(
				Consumer<? super T1> c1,
				Consumer<? super T2> c2) {
			c2.accept(value);
		}
		
		@Override
		public Object getValue() {
			return value;
		}
	}
}

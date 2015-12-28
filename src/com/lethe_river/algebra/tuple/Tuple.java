package com.lethe_river.algebra.tuple;

import java.util.Comparator;

public final class Tuple {
	private Tuple() {}
	
	/**
	 * 指定された要素を持つTupleを返す．
	 * 
	 * @param v1　新しいTupleの要素
	 * @param v2　新しいTupleの要素
	 * @return 新しいTuple
	 */
	public static <V1, V2> Tuple2<V1, V2> of(V1 v1, V2 v2) {
		return new Tuple2<V1, V2>(v1, v2);
	}
	
	/**
	 * 指定された要素を持つTupleを返す．
	 * 
	 * @param v1　新しいTupleの要素
	 * @param v2　新しいTupleの要素
	 * @param v3　新しいTupleの要素
	 * @return 新しいTuple
	 */
	public static <V1, V2, V3> Tuple3<V1, V2, V3> of(V1 v1, V2 v2, V3 v3) {
		return new Tuple3<V1, V2, V3>(v1, v2, v3);
	}
	
	/**
	 * 指定された要素を持つTupleを返す．
	 * 
	 * @param v1　新しいTupleの要素
	 * @param v2　新しいTupleの要素
	 * @param v3　新しいTupleの要素
	 * @param v4　新しいTupleの要素
	 * @return 新しいTuple
	 */
	public static <V1, V2, V3, V4> Tuple4<V1, V2, V3, V4> of(V1 v1, V2 v2, V3 v3, V4 v4) {
		return new Tuple4<V1, V2, V3, V4>(v1, v2, v3, v4);
	}
	
	/**
	 * 指定された要素を持つTupleを返す．
	 * 
	 * @param v1　新しいTupleの要素
	 * @param v2　新しいTupleの要素
	 * @param v3　新しいTupleの要素
	 * @param v4　新しいTupleの要素
	 * @param v5　新しいTupleの要素
	 * @return 新しいTuple
	 */
	public static <V1, V2, V3, V4, V5> Tuple5<V1, V2, V3, V4, V5> of(V1 v1, V2 v2, V3 v3, V4 v4, V5 v5) {
		return new Tuple5<V1, V2, V3, V4, V5>(v1, v2, v3, v4, v5);
	}
	
	/**
	 * 指定された型のTupleのコンパレータを返す.
	 * 
	 * @param c1　Tupleの1番目の要素の型
	 * @param c2　Tupleの2番目の要素の型
	 * @return Tupleのコンパレータ
	 */
	
	public static <T1 extends Comparable<T1>, T2 extends Comparable<T2>>
	Comparator<Tuple2<T1, T2>> comparatorOf(Class<T1> c1, Class<T2> c2) {
		return new Comparator<Tuple2<T1, T2>>() {
			@Override
			public int compare(Tuple2<T1, T2> o1, Tuple2<T1, T2> o2) {
				int c;
				c = o1.v1.compareTo(o2.v1);
				if(c != 0) {
					return c;
				}
				c = o1.v2.compareTo(o2.v2);
				return c;
			}
		};
	}
	
	/**
	 * 指定された型のTupleのコンパレータを返す.
	 * 
	 * @param c1　Tupleの1番目の要素の型
	 * @param c2　Tupleの2番目の要素の型
	 * @param c3　Tupleの3番目の要素の型
	 * @return Tupleのコンパレータ
	 */
	
	public static <T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>>
	Comparator<Tuple3<T1, T2, T3>> comparatorOf(Class<T1> c1, Class<T2> c2, Class<T3> c3) {
		return new Comparator<Tuple3<T1, T2, T3>>() {
			@Override
			public int compare(Tuple3<T1, T2, T3> o1, Tuple3<T1, T2, T3> o2) {
				int c;
				c = o1.v1.compareTo(o2.v1);
				if(c != 0) {
					return c;
				}
				c = o1.v2.compareTo(o2.v2);
				if(c != 0) {
					return c;
				}
				c = o1.v3.compareTo(o2.v3);
				return c;
			}
		};
	}
	
	/**
	 * 指定された型のTupleのコンパレータを返す.
	 * 
	 * @param c1　Tupleの1番目の要素の型
	 * @param c2　Tupleの2番目の要素の型
	 * @param c3　Tupleの3番目の要素の型
	 * @param c4　Tupleの4番目の要素の型
	 * @return Tupleのコンパレータ
	 */
	
	public static <T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>, T4 extends Comparable<T4>>
	Comparator<Tuple4<T1, T2, T3, T4>> comparatorOf(Class<T1> c1, Class<T2> c2, Class<T3> c3, Class<T4> c4) {
		return new Comparator<Tuple4<T1, T2, T3, T4>>() {
			@Override
			public int compare(Tuple4<T1, T2, T3, T4> o1, Tuple4<T1, T2, T3, T4> o2) {
				int c;
				c = o1.v1.compareTo(o2.v1);
				if(c != 0) {
					return c;
				}
				c = o1.v2.compareTo(o2.v2);
				if(c != 0) {
					return c;
				}
				c = o1.v3.compareTo(o2.v3);
				if(c != 0) {
					return c;
				}
				c = o1.v4.compareTo(o2.v4);
				return c;
			}
		};
	}
	
	/**
	 * 指定された型のTupleのコンパレータを返す.
	 * 
	 * @param c1　Tupleの1番目の要素の型
	 * @param c2　Tupleの2番目の要素の型
	 * @param c3　Tupleの3番目の要素の型
	 * @param c4　Tupleの4番目の要素の型
	 * @param c5　Tupleの5番目の要素の型
	 * @return Tupleのコンパレータ
	 */
	
	public static <T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>, T4 extends Comparable<T4>, T5 extends Comparable<T5>>
	Comparator<Tuple5<T1, T2, T3, T4, T5>> comparatorOf(Class<T1> c1, Class<T2> c2, Class<T3> c3, Class<T4> c4, Class<T5> c5) {
		return new Comparator<Tuple5<T1, T2, T3, T4, T5>>() {
			@Override
			public int compare(Tuple5<T1, T2, T3, T4, T5> o1, Tuple5<T1, T2, T3, T4, T5> o2) {
				int c;
				c = o1.v1.compareTo(o2.v1);
				if(c != 0) {
					return c;
				}
				c = o1.v2.compareTo(o2.v2);
				if(c != 0) {
					return c;
				}
				c = o1.v3.compareTo(o2.v3);
				if(c != 0) {
					return c;
				}
				c = o1.v4.compareTo(o2.v4);
				if(c != 0) {
					return c;
				}
				c = o1.v5.compareTo(o2.v5);
				return c;
			}
		};
	}
}

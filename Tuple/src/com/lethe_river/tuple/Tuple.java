package com.lethe_river.tuple;

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
}

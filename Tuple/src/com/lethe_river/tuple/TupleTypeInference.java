package com.lethe_river.tuple;

public class TupleTypeInference {

	private TupleTypeInference() {}
	
	public static <V1, V2> Tuple2<V1, V2> newTuple(V1 v1, V2 v2) {
		return new Tuple2<V1, V2>(v1, v2);
	}
	
	public static <V1, V2, V3> Tuple3<V1, V2, V3> newTuple(V1 v1, V2 v2, V3 v3) {
		return new Tuple3<V1, V2, V3>(v1, v2, v3);
	}
	
	public static <V1, V2, V3, V4> Tuple4<V1, V2, V3, V4> newTuple(V1 v1, V2 v2, V3 v3, V4 v4) {
		return new Tuple4<V1, V2, V3, V4>(v1, v2, v3, v4);
	}
	
	public static <V1, V2, V3, V4, V5> Tuple5<V1, V2, V3, V4, V5> newTuple(V1 v1, V2 v2, V3 v3, V4 v4, V5 v5) {
		return new Tuple5<V1, V2, V3, V4, V5>(v1, v2, v3, v4, v5);
	}
}

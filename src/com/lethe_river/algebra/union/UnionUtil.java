package com.lethe_river.algebra.union;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import com.lethe_river.algebra.tuple.Tuple;
import com.lethe_river.algebra.tuple.Tuple2;
import com.lethe_river.algebra.tuple.Tuple3;
import com.lethe_river.algebra.tuple.Tuple4;
import com.lethe_river.algebra.tuple.Tuple5;

public class UnionUtil {
	private UnionUtil(){}
	
	/**
	 * Union2を要素の型パラメータごとに新しいListに蓄積するCollectorを返す．
	 * 
	 * @return すべての入力要素をUnion2の型パラメータごとに検出順にList内に集めるCollector
	 */
	public static <T1, T2> Collector<Union2<T1, T2>, ?, Tuple2<List<T1>, List<T2>>> toList2() {
		return new Collector2<>();
	}
	
	/**
	 * Union3を要素の型パラメータごとに新しいListに蓄積するCollectorを返す．
	 * 
	 * @return すべての入力要素をUnion3の型パラメータごとに検出順にList内に集めるCollector
	 */
	public static <T1, T2, T3> Collector<Union3<T1, T2, T3>, ?, Tuple3<List<T1>, List<T2>, List<T3>>> toList3() {
		return new Collector3<>();
	}
	
	/**
	 * Union4を要素の型パラメータごとに新しいListに蓄積するCollectorを返す．
	 * 
	 * @return すべての入力要素をUnion4の型パラメータごとに検出順にList内に集めるCollector
	 */
	public static <T1, T2, T3, T4> Collector<Union4<T1, T2, T3, T4>, ?, Tuple4<List<T1>, List<T2>, List<T3>, List<T4>>> toList4() {
		return new Collector4<>();
	}
	
	/**
	 * Union5を要素の型パラメータごとに新しいListに蓄積するCollectorを返す．
	 * 
	 * @return すべての入力要素をUnion5の型パラメータごとに検出順にList内に集めるCollector
	 */
	public static <T1, T2, T3, T4, T5> Collector<Union5<T1, T2, T3, T4, T5>, ?, Tuple5<List<T1>, List<T2>, List<T3>, List<T4>, List<T5>>> toList5() {
		return new Collector5<>();
	}
	
	private static class Collector2<T1, T2> implements
	Collector<Union2<T1, T2>,
	Tuple2<LinkedList<T1>, LinkedList<T2>>,
	Tuple2<List<T1>, List<T2>>> {
		@Override
		public BiConsumer<Tuple2<LinkedList<T1>, LinkedList<T2>>, Union2<T1, T2>> accumulator() {
			return (tp , u) -> {u.matchDo(
					t1 -> {tp.v1.add(t1);},
					t2 -> tp.v2.add(t2));};
		}

		@Override
		public Set<java.util.stream.Collector.Characteristics> characteristics() {
			return EnumSet.<Collector.Characteristics>noneOf(Collector.Characteristics.class);
		}

		@Override
		public BinaryOperator<Tuple2<LinkedList<T1>, LinkedList<T2>>> combiner() {
			return (tp1, tp2) -> {
				tp1.v1.addAll(tp2.v1);
				tp1.v2.addAll(tp2.v2);
				return tp1;
			};
		}

		@Override
		public Function<Tuple2<LinkedList<T1>, LinkedList<T2>>, Tuple2<List<T1>, List<T2>>> finisher() {
			return t -> Tuple.of(
					Collections.unmodifiableList(new ArrayList<>(t.v1)),
					Collections.unmodifiableList(new ArrayList<>(t.v2)));
		}

		@Override
		public Supplier<Tuple2<LinkedList<T1>, LinkedList<T2>>> supplier() {
			return () -> Tuple.of(new LinkedList<>(), new LinkedList<>());
		}
	}
	
	private static class Collector3<T1, T2, T3> implements
	Collector<Union3<T1, T2, T3>,
	Tuple3<LinkedList<T1>, LinkedList<T2>, LinkedList<T3>>,
	Tuple3<List<T1>, List<T2>, List<T3>>> {
		@Override
		public BiConsumer<Tuple3<LinkedList<T1>, LinkedList<T2>, LinkedList<T3>>, Union3<T1, T2, T3>> accumulator() {
			return (tp , u) -> {u.matchDo(
					t1 -> {tp.v1.add(t1);},
					t2 -> tp.v2.add(t2),
					t3 -> tp.v3.add(t3));};
		}

		@Override
		public Set<java.util.stream.Collector.Characteristics> characteristics() {
			return EnumSet.<Collector.Characteristics>noneOf(Collector.Characteristics.class);
		}

		@Override
		public BinaryOperator<Tuple3<LinkedList<T1>, LinkedList<T2>, LinkedList<T3>>> combiner() {
			return (tp1, tp2) -> {
				tp1.v1.addAll(tp2.v1);
				tp1.v2.addAll(tp2.v2);
				tp1.v3.addAll(tp2.v3);
				return tp1;
			};
		}

		@Override
		public Function<Tuple3<LinkedList<T1>, LinkedList<T2>, LinkedList<T3>>, Tuple3<List<T1>, List<T2>, List<T3>>> finisher() {
			return t -> Tuple.of(
					Collections.unmodifiableList(new ArrayList<>(t.v1)),
					Collections.unmodifiableList(new ArrayList<>(t.v2)),
					Collections.unmodifiableList(new ArrayList<>(t.v3)));
		}

		@Override
		public Supplier<Tuple3<LinkedList<T1>, LinkedList<T2>, LinkedList<T3>>> supplier() {
			return () -> Tuple.of(new LinkedList<>(), new LinkedList<>(), new LinkedList<>());
		}
	}
	
	private static class Collector4<T1, T2, T3, T4> implements
	Collector<Union4<T1, T2, T3, T4>,
	Tuple4<LinkedList<T1>, LinkedList<T2>, LinkedList<T3>, LinkedList<T4>>,
	Tuple4<List<T1>, List<T2>, List<T3>, List<T4>>> {
		@Override
		public BiConsumer<Tuple4<LinkedList<T1>, LinkedList<T2>, LinkedList<T3>, LinkedList<T4>>, Union4<T1, T2, T3, T4>> accumulator() {
			return (tp , u) -> {u.matchDo(
					t1 -> {tp.v1.add(t1);},
					t2 -> tp.v2.add(t2),
					t3 -> tp.v3.add(t3),
					t4 -> tp.v4.add(t4));};
		}

		@Override
		public Set<java.util.stream.Collector.Characteristics> characteristics() {
			return EnumSet.<Collector.Characteristics>noneOf(Collector.Characteristics.class);
		}

		@Override
		public BinaryOperator<Tuple4<LinkedList<T1>, LinkedList<T2>, LinkedList<T3>, LinkedList<T4>>> combiner() {
			return (tp1, tp2) -> {
				tp1.v1.addAll(tp2.v1);
				tp1.v2.addAll(tp2.v2);
				tp1.v3.addAll(tp2.v3);
				tp1.v4.addAll(tp2.v4);
				return tp1;
			};
		}

		@Override
		public Function<Tuple4<LinkedList<T1>, LinkedList<T2>, LinkedList<T3>, LinkedList<T4>>, Tuple4<List<T1>, List<T2>, List<T3>, List<T4>>> finisher() {
			return t -> Tuple.of(
					Collections.unmodifiableList(new ArrayList<>(t.v1)),
					Collections.unmodifiableList(new ArrayList<>(t.v2)),
					Collections.unmodifiableList(new ArrayList<>(t.v3)),
					Collections.unmodifiableList(new ArrayList<>(t.v4)));
		}

		@Override
		public Supplier<Tuple4<LinkedList<T1>, LinkedList<T2>, LinkedList<T3>, LinkedList<T4>>> supplier() {
			return () -> Tuple.of(new LinkedList<>(), new LinkedList<>(), new LinkedList<>(), new LinkedList<>());
		}
	}
	
	private static class Collector5<T1, T2, T3, T4, T5> implements
	Collector<Union5<T1, T2, T3, T4, T5>,
	Tuple5<LinkedList<T1>, LinkedList<T2>, LinkedList<T3>, LinkedList<T4>, LinkedList<T5>>,
	Tuple5<List<T1>, List<T2>, List<T3>, List<T4>, List<T5>>> {
		@Override
		public BiConsumer<Tuple5<LinkedList<T1>, LinkedList<T2>, LinkedList<T3>, LinkedList<T4>, LinkedList<T5>>, Union5<T1, T2, T3, T4, T5>> accumulator() {
			return (tp , u) -> {u.matchDo(
					t1 -> {tp.v1.add(t1);},
					t2 -> tp.v2.add(t2),
					t3 -> tp.v3.add(t3),
					t4 -> tp.v4.add(t4),
					t5 -> tp.v5.add(t5));};
		}

		@Override
		public Set<java.util.stream.Collector.Characteristics> characteristics() {
			return EnumSet.<Collector.Characteristics>noneOf(Collector.Characteristics.class);
		}

		@Override
		public BinaryOperator<Tuple5<LinkedList<T1>, LinkedList<T2>, LinkedList<T3>, LinkedList<T4>, LinkedList<T5>>> combiner() {
			return (tp1, tp2) -> {
				tp1.v1.addAll(tp2.v1);
				tp1.v2.addAll(tp2.v2);
				tp1.v3.addAll(tp2.v3);
				tp1.v4.addAll(tp2.v4);
				tp1.v5.addAll(tp2.v5);
				return tp1;
			};
		}

		@Override
		public Function<Tuple5<LinkedList<T1>, LinkedList<T2>, LinkedList<T3>, LinkedList<T4>, LinkedList<T5>>, Tuple5<List<T1>, List<T2>, List<T3>, List<T4>, List<T5>>> finisher() {
			return t -> Tuple.of(
					Collections.unmodifiableList(new ArrayList<>(t.v1)),
					Collections.unmodifiableList(new ArrayList<>(t.v2)),
					Collections.unmodifiableList(new ArrayList<>(t.v3)),
					Collections.unmodifiableList(new ArrayList<>(t.v4)),
					Collections.unmodifiableList(new ArrayList<>(t.v5)));
		}

		@Override
		public Supplier<Tuple5<LinkedList<T1>, LinkedList<T2>, LinkedList<T3>, LinkedList<T4>, LinkedList<T5>>> supplier() {
			return () -> Tuple.of(new LinkedList<>(), new LinkedList<>(), new LinkedList<>(), new LinkedList<>(), new LinkedList<>());
		}
	}
}

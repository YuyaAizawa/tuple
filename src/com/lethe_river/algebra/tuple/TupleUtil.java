package com.lethe_river.algebra.tuple;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TupleUtil {
	
	private TupleUtil() {}
	
	/**
	 * 入力されたStreamの同じ位置にある要素をTupleで結合したStreamを作る．
	 * 新しいStreamの要素の数はもっとも少ないものに合わせられる．
	 * @param s1
	 * @param s2
	 * @return 結合したTupleを要素とするStream
	 */
	public static <T1, T2> Stream<Tuple2<T1, T2>>
	zip(Stream<T1> s1, Stream<T2> s2) {
		Objects.nonNull(s1);
		Objects.nonNull(s2);
		final Spliterator<T1> sp1 = s1.spliterator();
		final Spliterator<T2> sp2 = s2.spliterator();
		final int c1 = sp1.characteristics();
		final int c2 = sp2.characteristics();
		final int c = zipCharacteristics(c1, c2);
		final Iterator<Tuple2<T1, T2>> i =new Tuple2Ziper<T1, T2>(
				Spliterators.iterator(sp1),
				Spliterators.iterator(sp2));
		
		if((c & Spliterator.SIZED) != 0) {
			final long limit = Math.min(sp1.getExactSizeIfKnown(),
										sp2.getExactSizeIfKnown());
			assert(limit != -1);
			return StreamSupport.stream(Spliterators.spliterator(i, limit, c), false);
		}
		
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(i, c), false);
	}
	
	/**
	 * 入力されたListの同じ位置にある要素をTupleで結合したStreamを作る．
	 * 新しいStreamの要素の数はもっとも少ないものに合わせられる．
	 * @param l1
	 * @param l2
	 * @return 結合したTupleを要素とするStream
	 */
	public static <T1, T2> Stream<Tuple2<T1, T2>>
	zip(List<T1> l1, List<T2> l2) {
		return zip(l1.stream(), l2.stream());
	}
	
	/**
	 * 入力されたStreamの同じ位置にある要素をTupleで結合したStreamを作る．
	 * 新しいStreamの要素の数はもっとも少ないものに合わせられる．
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return 結合したTupleを要素とするStream
	 */
	public static <T1, T2, T3> Stream<Tuple3<T1, T2, T3>>
	zip(Stream<T1> s1, Stream<T2> s2, Stream<T3> s3) {
		Objects.nonNull(s1);
		Objects.nonNull(s2);
		Objects.nonNull(s3);
		final Spliterator<T1> sp1 = s1.spliterator();
		final Spliterator<T2> sp2 = s2.spliterator();
		final Spliterator<T3> sp3 = s3.spliterator();
		final int c1 = sp1.characteristics();
		final int c2 = sp2.characteristics();
		final int c3 = sp3.characteristics();
		final int c = zipCharacteristics(c1, c2, c3);
		final Iterator<Tuple3<T1, T2, T3>> i = new Tuple3Ziper<T1, T2, T3>(
				Spliterators.iterator(sp1),
				Spliterators.iterator(sp2),
				Spliterators.iterator(sp3)
				);
		if((c & Spliterator.SIZED) != 0) {
			long limit = Math.min(sp1.getExactSizeIfKnown(),
								  sp2.getExactSizeIfKnown());
			limit = Math.min(limit, sp3.getExactSizeIfKnown());
			assert(limit != -1);
			return StreamSupport.stream(Spliterators.spliterator(i, limit, c), false);
		}
		
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(i, c), false);
	}
	
	/**
	 * 入力されたListの同じ位置にある要素をTupleで結合したStreamを作る．
	 * 新しいStreamの要素の数はもっとも少ないものに合わせられる．
	 * @param l1
	 * @param l2
	 * @param l3
	 * @return 結合したTupleを要素とするStream
	 */
	public static <T1, T2, T3> Stream<Tuple3<T1, T2, T3>>
	zip(List<T1> l1, List<T2> l2, List<T3> l3) {
		return zip(l1.stream(), l2.stream(), l3.stream());
	}
	
	
	/**
	 * 入力されたStreamの同じ位置にある要素をTupleで結合したStreamを作る．
	 * 新しいStreamの要素の数はもっとも少ないものに合わせられる．
	 * @param s1
	 * @param s2
	 * @param s3
	 * @param s4
	 * @return 結合したTupleを要素とするStream
	 */
	public static <T1, T2, T3, T4> Stream<Tuple4<T1, T2, T3, T4>>
	zip(Stream<T1> s1, Stream<T2> s2, Stream<T3> s3, Stream<T4> s4) {
		Objects.nonNull(s1);
		Objects.nonNull(s2);
		Objects.nonNull(s3);
		Objects.nonNull(s4);
		final Spliterator<T1> sp1 = s1.spliterator();
		final Spliterator<T2> sp2 = s2.spliterator();
		final Spliterator<T3> sp3 = s3.spliterator();
		final Spliterator<T4> sp4 = s4.spliterator();
		final int c1 = sp1.characteristics();
		final int c2 = sp2.characteristics();
		final int c3 = sp3.characteristics();
		final int c4 = sp4.characteristics();
		final int c = zipCharacteristics(c1, c2, c3, c4);
		final Iterator<Tuple4<T1, T2, T3, T4>> i = new Tuple4Ziper<T1, T2, T3, T4>(
				Spliterators.iterator(sp1),
				Spliterators.iterator(sp2),
				Spliterators.iterator(sp3),
				Spliterators.iterator(sp4)
				);
		if((c & Spliterator.SIZED) != 0) {
			long limit = Math.min(sp1.getExactSizeIfKnown(),
								  sp2.getExactSizeIfKnown());
			limit = Math.min(limit, sp3.getExactSizeIfKnown());
			limit = Math.min(limit, sp4.getExactSizeIfKnown());

			assert(limit != -1);
			return StreamSupport.stream(Spliterators.spliterator(i, limit, c), false);
		}
		
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(i, c), false);
	}
	
	/**
	 * 入力されたListの同じ位置にある要素をTupleで結合したStreamを作る．
	 * 新しいStreamの要素の数はもっとも少ないものに合わせられる．
	 * @param l1
	 * @param l2
	 * @param l3
	 * @param l4
	 * @return 結合したTupleを要素とするStream
	 */
	public static <T1, T2, T3, T4> Stream<Tuple4<T1, T2, T3, T4>>
	zip(List<T1> l1, List<T2> l2, List<T3> l3, List<T4> l4) {
		return zip(l1.stream(), l2.stream(), l3.stream(), l4.stream());
	}
	
	
	/**
	 * 入力されたStreamの同じ位置にある要素をTupleで結合したStreamを作る．
	 * 新しいStreamの要素の数はもっとも少ないものに合わせられる．
	 * @param s1
	 * @param s2
	 * @param s3
	 * @param s4
	 * @param s5
	 * @return 結合したTupleを要素とするStream
	 */
	public static <T1, T2, T3, T4, T5> Stream<Tuple5<T1, T2, T3, T4, T5>>
	zip(Stream<T1> s1, Stream<T2> s2, Stream<T3> s3, Stream<T4> s4, Stream<T5> s5) {
		Objects.nonNull(s1);
		Objects.nonNull(s2);
		Objects.nonNull(s3);
		Objects.nonNull(s4);
		Objects.nonNull(s5);
		final Spliterator<T1> sp1 = s1.spliterator();
		final Spliterator<T2> sp2 = s2.spliterator();
		final Spliterator<T3> sp3 = s3.spliterator();
		final Spliterator<T4> sp4 = s4.spliterator();
		final Spliterator<T5> sp5 = s5.spliterator();
		final int c1 = sp1.characteristics();
		final int c2 = sp2.characteristics();
		final int c3 = sp3.characteristics();
		final int c4 = sp4.characteristics();
		final int c5 = sp5.characteristics();
		final int c = zipCharacteristics(c1, c2, c3, c4, c5);
		final Iterator<Tuple5<T1, T2, T3, T4, T5>> i = new Tuple5Ziper<T1, T2, T3, T4, T5>(
				Spliterators.iterator(sp1),
				Spliterators.iterator(sp2),
				Spliterators.iterator(sp3),
				Spliterators.iterator(sp4),
				Spliterators.iterator(sp5)
				);
		
		if((c & Spliterator.SIZED) != 0) {
			long limit = Math.min(sp1.getExactSizeIfKnown(),
								  sp2.getExactSizeIfKnown());
			limit = Math.min(limit, sp3.getExactSizeIfKnown());
			limit = Math.min(limit, sp4.getExactSizeIfKnown());
			limit = Math.min(limit, sp5.getExactSizeIfKnown());
			assert(limit != -1);
			return StreamSupport.stream(Spliterators.spliterator(i, limit, c), false);
		}
		
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(i, c), false);
	}
	
	/**
	 * 入力されたListの同じ位置にある要素をTupleで結合したStreamを作る．
	 * 新しいStreamの要素の数はもっとも少ないものに合わせられる．
	 * @param l1
	 * @param l2
	 * @param l3
	 * @param l4
	 * @param l5
	 * @return 結合したTupleを要素とするStream
	 */
	public static <T1, T2, T3, T4, T5> Stream<Tuple5<T1, T2, T3, T4, T5>>
	zip(List<T1> l1, List<T2> l2, List<T3> l3, List<T4> l4, List<T5> l5) {
		return zip(l1.stream(), l2.stream(), l3.stream(), l4.stream(), l5.stream());
	}
	
	/**
	 * 入力されたStreamの直積をTupleで結合したStreamを作る．
	 * Tuple内の各要素は入力されたStreamの要素の参照となる．
	 * @param s1
	 * @param s2
	 * @return 直積のTupleを要素とするStream
	 */
	
	public static <T1, T2> Stream<Tuple2<T1, T2>> product(Stream<T1> s1, Stream<T2> s2) {
		List<T2> l2 = s2.collect(Collectors.toList());
		return s1.flatMap(v1 -> l2.stream().map(v2 -> Tuple.of(v1, v2)));
	}
	
	/**
	 * 入力されたListの直積をTupleで結合したStreamを作る．
	 * Tuple内の各要素は入力されたStreamの要素の参照となる．
	 * @param l1
	 * @param l2
	 * @return 直積のTupleを要素とするStream
	 */
	
	public static <T1, T2> Stream<Tuple2<T1, T2>> product(List<T1> l1, List<T2> l2) {
		return product(l1.stream(), l2.stream());
	}
	
	/**
	 * Tuple<T1, T2>をMap<T1, T2>に変換するためのCollectorを得る．
	 * @return Collector
	 */
	public static <T1, T2> Collector<Tuple2<T1, T2>, ?, Map<T1, T2>> toMap() {
		return Collectors.toMap(t -> t.v1, t -> t.v2);
	}

	public static <T1, T2> Collector<Tuple2<T1, T2>, ?, Map<T1, T2>> toMap(
			BinaryOperator<T2> mergeFunction) {
		return Collectors.toMap(t -> t.v1, t -> t.v2, mergeFunction);
	}

	public static <T1, T2, M extends Map<T1, T2>> Collector<Tuple2<T1, T2>, ?, M> toMap(
			BinaryOperator<T2> mergeFunction, Supplier<M> mapSupplier) {
		return Collectors.toMap(t -> t.v1, t -> t.v2, mergeFunction,mapSupplier);
	}
	
	/**
	 * 指定したMapのkeyとvalueのペアを要素とするStreamを作る．
	 * @param map
	 * @return keyとvalueのペアを要素とするStream
	 */
	public static <T1, T2> Stream<Tuple2<T1, T2>> fromMap(Map<T1, T2> map) {
		final int MAP_CHARACTERISTICS =
				  Spliterator.DISTINCT
				| Spliterator.NONNULL
				| Spliterator.SIZED;
		
		final Set<Entry<T1, T2>> entries = map.entrySet();
		final Iterator<Tuple2<T1, T2>> iterator = new Entry2Tuple<>(entries.iterator());
		
		return StreamSupport.stream(Spliterators.spliterator(
				iterator, entries.size(), MAP_CHARACTERISTICS), false);
	}
	
	/**
	 * 入力したStreamの前後2つの要素の組を操作するためのStreamを作る．
	 * 例えば元のStreamの要素が['A', 'B', 'C', 'D']であるとき，作られるStreamの要素は[('A', 'B'), ('B', 'C'), ('C', 'D')]となる．
	 * 入力したStreamは消費される．
	 * @param stream
	 * @return 前後2つの要素の組を要素とするStream
	 */
	public static <T> Stream<Tuple2<T, T>> window2(Stream<T> stream) {
		Objects.nonNull(stream);
		
		if(stream.isParallel()) {
			throw new IllegalArgumentException("stream must be sequencial");
		}
		
		Spliterator<T> spliterator = stream.spliterator();
		
		if(spliterator.estimateSize() < 2) {
			spliterator = Spliterators.emptySpliterator();
		}
			
		return StreamSupport.stream(new Window2Spliterator<T>(spliterator), false);
	}
	
	private static int zipCharacteristics(int... c) {
		int dis = Arrays.stream(c).reduce((l, r) -> l | r).getAsInt();
		int con = Arrays.stream(c).reduce((l, r) -> l & r).getAsInt();
		return (Spliterator.CONCURRENT & (con))
			 | (Spliterator.DISTINCT   & (dis))
			 | (Spliterator.IMMUTABLE  & (con))
			 | (Spliterator.SORTED     & (con))
			 |  Spliterator.NONNULL
			 | (Spliterator.ORDERED    & (con))
			 | (Spliterator.SIZED      & (con));
	}
	
	private static class Tuple2Ziper<T1, T2> implements Iterator<Tuple2<T1, T2>> {
		private final Iterator<T1> i1;
		private final Iterator<T2> i2;
		
		public Tuple2Ziper(Iterator<T1> i1, Iterator<T2> i2) {
			this.i1 = i1;
			this.i2 = i2;
		}
		
		@Override
		public boolean hasNext() {
			return i1.hasNext()
				&& i2.hasNext();
		}

		@Override
		public Tuple2<T1, T2> next() {
			return Tuple.of(i1.next(),
							i2.next());
		}
	}
	
	private static class Tuple3Ziper<T1, T2, T3> implements Iterator<Tuple3<T1, T2, T3>> {
		private final Iterator<T1> i1;
		private final Iterator<T2> i2;
		private final Iterator<T3> i3;
		
		public Tuple3Ziper(Iterator<T1> i1, Iterator<T2> i2, Iterator<T3> i3) {
			this.i1 = i1;
			this.i2 = i2;
			this.i3 = i3;
		}
		
		@Override
		public boolean hasNext() {
			return i1.hasNext()
				&& i2.hasNext()
				&& i3.hasNext();
		}

		@Override
		public Tuple3<T1, T2, T3> next() {
			return Tuple.of(i1.next(),
							i2.next(),
							i3.next());
		}
	}
	
	private static class Tuple4Ziper<T1, T2, T3, T4> implements Iterator<Tuple4<T1, T2, T3, T4>> {
		private final Iterator<T1> i1;
		private final Iterator<T2> i2;
		private final Iterator<T3> i3;
		private final Iterator<T4> i4;
		
		
		public Tuple4Ziper(Iterator<T1> i1, Iterator<T2> i2, Iterator<T3> i3, Iterator<T4> i4) {
			this.i1 = i1;
			this.i2 = i2;
			this.i3 = i3;
			this.i4 = i4;
		}
		
		@Override
		public boolean hasNext() {
			return i1.hasNext()
				&& i2.hasNext()
				&& i3.hasNext()
				&& i4.hasNext();
		}

		@Override
		public Tuple4<T1, T2, T3, T4> next() {
			return Tuple.of(i1.next(), i2.next(), i3.next(), i4.next());
		}
	}
	
	private static class Tuple5Ziper<T1, T2, T3, T4, T5> implements Iterator<Tuple5<T1, T2, T3, T4, T5>> {
		private final Iterator<T1> i1;
		private final Iterator<T2> i2;
		private final Iterator<T3> i3;
		private final Iterator<T4> i4;
		private final Iterator<T5> i5;
		
		public Tuple5Ziper(Iterator<T1> i1, Iterator<T2> i2, Iterator<T3> i3, Iterator<T4> i4, Iterator<T5> i5) {
			this.i1 = i1;
			this.i2 = i2;
			this.i3 = i3;
			this.i4 = i4;
			this.i5 = i5;
		}
		
		@Override
		public boolean hasNext() {
			return i1.hasNext()
				&& i2.hasNext()
				&& i3.hasNext()
				&& i4.hasNext()
				&& i5.hasNext();
		}

		@Override
		public Tuple5<T1, T2, T3, T4, T5> next() {
			return Tuple.of(i1.next(),
							i2.next(),
							i3.next(),
							i4.next(),
							i5.next());
		}
	}
	
	private static class Entry2Tuple<T1, T2> implements Iterator<Tuple2<T1, T2>> {
		private final Iterator<Entry<T1, T2>> entries;
		
		public Entry2Tuple(Iterator<Entry<T1, T2>> iterator) {
			entries = iterator;
		}
		
		@Override
		public boolean hasNext() {
			return entries.hasNext();
		}
		
		@Override
		public Tuple2<T1, T2> next() {
			Entry<T1, T2> entry = entries.next();
			return new Tuple2<>(entry.getKey(), entry.getValue());
		}
	}
	
	private static class Window2Spliterator<T> implements Spliterator<Tuple2<T, T>> {
	
		Spliterator<T> spliterator;
		Iterator<T> iterator;
		
		T previous;
		T last;
		
		public Window2Spliterator(Spliterator<T> spliterator) {
			this(checkOrderd(spliterator), null, null);
		}
		
		private static <T> Spliterator<T> checkOrderd(Spliterator<T> spliterator) {
			if((spliterator.characteristics() & Spliterator.ORDERED) == 0) {
				throw new IllegalArgumentException("spliterator must be orderd");
			}
			return spliterator;
		}

		private Window2Spliterator(Spliterator<T> spliterator, T first, T last) {
			this.spliterator = spliterator;
			this.last = last;
			this.previous = first;
		}
		
		@Override
		public boolean tryAdvance(Consumer<? super Tuple2<T, T>> action) {
			Tuple2<T, T> tuple;
			
			if(iterator == null) {
				iterator = Spliterators.iterator(spliterator);
			}
			
			if(previous == null) {
				previous = iterator.next();
			}
			
			if(iterator.hasNext()) {
				tuple = Tuple.of(previous, iterator.next());
			} else {
				tuple = Tuple.of(previous, last);
				last = null;
			}
			previous = tuple.v2;
			
			action.accept(tuple);
			
			return iterator.hasNext() || last != null;
		}
	
		@Override
		public Spliterator<Tuple2<T, T>> trySplit() {
			Spliterator<T> prefix = spliterator.trySplit();
			if(prefix == null) {
				return null;
			}
			
			iterator = Spliterators.iterator(spliterator);
			T prefixPrevious = previous;
			previous = iterator.next();
			
			return new Window2Spliterator<T>(prefix, prefixPrevious, previous);
		}
	
		@Override
		public long estimateSize() {
			return spliterator.estimateSize() - (last == null ? 1 : 0);
		}
	
		@Override
		public int characteristics() {
			return spliterator.characteristics();
		}
	}
}
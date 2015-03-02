package com.lethe_river.tuple;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static com.lethe_river.tuple.TupleTypeInference.*;

public class TupleUtil {

	private TupleUtil() {}
	
	
	/**
	 * 入力されたStreamの要素をTupleで結合したStreamを作る
	 * 
	 * 要素の数はもっとも少ないものに合わせられる
	 * @param s1
	 * @param s2
	 * @return Tupleを要素とするStream
	 */
	public static <T1, T2> Stream<Tuple2<T1,T2>> zip(Stream<T1> s1, Stream<T2> s2) {
		final Spliterator<T1> sp1 = s1.spliterator();
		final Spliterator<T2> sp2 = s2.spliterator();
		final int c1 = sp1.characteristics();
		final int c2 = sp2.characteristics();
		final int c = makeCharacteristics(c1, c2);
		final Iterator<Tuple2<T1,T2>> i =new Tuple2Ziper<T1, T2>(
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
	
	public static <T1, T2, T3> Stream<Tuple3<T1,T2,T3>> zip(Stream<T1> s1, Stream<T2> s2, Stream<T3> s3) {
		final Spliterator<T1> sp1 = s1.spliterator();
		final Spliterator<T2> sp2 = s2.spliterator();
		final Spliterator<T3> sp3 = s3.spliterator();
		final int c1 = sp1.characteristics();
		final int c2 = sp2.characteristics();
		final int c3 = sp3.characteristics();
		final int c = makeCharacteristics(c1, c2, c3);
		final Iterator<Tuple3<T1,T2,T3>> i = new Tuple3Ziper<T1, T2, T3>(
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
	
	public static <T1, T2, T3, T4> Stream<Tuple4<T1,T2,T3,T4>> zip(Stream<T1> s1, Stream<T2> s2, Stream<T3> s3, Stream<T4> s4) {
		final Spliterator<T1> sp1 = s1.spliterator();
		final Spliterator<T2> sp2 = s2.spliterator();
		final Spliterator<T3> sp3 = s3.spliterator();
		final Spliterator<T4> sp4 = s4.spliterator();
		final int c1 = sp1.characteristics();
		final int c2 = sp2.characteristics();
		final int c3 = sp3.characteristics();
		final int c4 = sp4.characteristics();
		final int c = makeCharacteristics(c1, c2, c3, c4);
		final Iterator<Tuple4<T1,T2,T3,T4>> i = new Tuple4Ziper<T1, T2, T3, T4>(
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
	
	public static <T1, T2, T3, T4, T5> Stream<Tuple5<T1,T2,T3,T4,T5>> zip(Stream<T1> s1, Stream<T2> s2, Stream<T3> s3, Stream<T4> s4, Stream<T5> s5) {
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
		final int c = makeCharacteristics(c1, c2, c3, c4, c5);
		final Iterator<Tuple5<T1,T2,T3,T4,T5>> i = new Tuple5Ziper<T1, T2, T3, T4, T5>(
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
	
	public static <T1, T2> List<Tuple2<T1,T2>> zip(List<T1> l1, List<T2> l2) {
		return zip(l1.stream(), l2.stream()).collect(Collectors.toList());
	}
	
	public static <T1, T2, T3> List<Tuple3<T1,T2,T3>> zip(List<T1> l1, List<T2> l2, List<T3> l3) {
		return zip(l1.stream(), l2.stream(), l3.stream()).collect(Collectors.toList());
	}
	
	public static <T1, T2, T3, T4> List<Tuple4<T1,T2,T3,T4>> zip(List<T1> l1, List<T2> l2, List<T3> l3, List<T4> l4) {
		return zip(l1.stream(), l2.stream(), l3.stream(), l4.stream()).collect(Collectors.toList());
	}
	
	public static <T1, T2, T3, T4, T5> List<Tuple5<T1,T2,T3,T4,T5>> zip(List<T1> l1, List<T2> l2, List<T3> l3, List<T4> l4, List<T5> l5) {
		return zip(l1.stream(), l2.stream(), l3.stream(), l4.stream(), l5.stream()).collect(Collectors.toList());
	}
	
	private static int makeCharacteristics(int... c) {
		int dis = Arrays.stream(c).reduce((l, r) -> l | r).getAsInt();
		int con = Arrays.stream(c).reduce((l, r) -> l & r).getAsInt();
		return (Spliterator.CONCURRENT & (con))
			 | (Spliterator.DISTINCT   & (dis))
			 | (Spliterator.IMMUTABLE  & (con))
			 |  Spliterator.NONNULL
			 | (Spliterator.ORDERED    & (con))
			 | (Spliterator.SIZED      & (con));
	}
	
	
	
	private static class Tuple2Ziper<T1, T2> implements Iterator<Tuple2<T1, T2>> {
		private final Iterator<T1> i1;
		private final Iterator<T2> i2;
		
		public Tuple2Ziper(Iterator<T1> i1, Iterator<T2> i2) {
			Objects.nonNull(i1);
			Objects.nonNull(i2);
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
			return newTuple(i1.next(),
							i2.next());
		}
	}
	
	private static class Tuple3Ziper<T1, T2, T3> implements Iterator<Tuple3<T1, T2, T3>> {
		private final Iterator<T1> i1;
		private final Iterator<T2> i2;
		private final Iterator<T3> i3;
		
		public Tuple3Ziper(Iterator<T1> i1, Iterator<T2> i2, Iterator<T3> i3) {
			Objects.nonNull(i1);
			Objects.nonNull(i2);
			Objects.nonNull(i3);
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
			return newTuple(i1.next(),
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
			Objects.nonNull(i1);
			Objects.nonNull(i2);
			Objects.nonNull(i3);
			Objects.nonNull(i4);
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
			return newTuple(i1.next(), i2.next(), i3.next(), i4.next());
		}
	}
	
	private static class Tuple5Ziper<T1, T2, T3, T4, T5> implements Iterator<Tuple5<T1, T2, T3, T4, T5>> {
		private final Iterator<T1> i1;
		private final Iterator<T2> i2;
		private final Iterator<T3> i3;
		private final Iterator<T4> i4;
		private final Iterator<T5> i5;
		
		public Tuple5Ziper(Iterator<T1> i1, Iterator<T2> i2, Iterator<T3> i3, Iterator<T4> i4, Iterator<T5> i5) {
			Objects.nonNull(i1);
			Objects.nonNull(i2);
			Objects.nonNull(i3);
			Objects.nonNull(i4);
			Objects.nonNull(i5);
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
			return newTuple(i1.next(),
							i2.next(),
							i3.next(),
							i4.next(),
							i5.next());
		}
	}
}
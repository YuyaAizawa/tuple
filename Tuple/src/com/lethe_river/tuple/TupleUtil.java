package com.lethe_river.tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static com.lethe_river.tuple.TupleTypeInference.*;

public class TupleUtil {

	private TupleUtil() {}
	
	/**
	 * 入力されたStreamの要素をTupleで結合したStreamを作る
	 * 新しいStreamの要素の数はもっとも少ないものに合わせられる
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
	 * 入力されたStreamの要素をTupleで結合したStreamを作る
	 * 新しいStreamの要素の数はもっとも少ないものに合わせられる
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
	 * 入力されたStreamの要素をTupleで結合したStreamを作る
	 * 新しいStreamの要素の数はもっとも少ないものに合わせられる
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
	 * 入力されたStreamの要素をTupleで結合したStreamを作る
	 * 新しいStreamの要素の数はもっとも少ないものに合わせられる
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
	 * 入力されたStreamの直積をTupleで結合したStreamを作る
	 * Tuple内の各要素は入力されたStreamの要素の参照となる
	 * @param s1
	 * @param s2
	 * @return 直積のTupleを要素とするStream
	 */
	public static <T1, T2> Stream<Tuple2<T1, T2>> product(Stream<T1> s1, Stream<T2> s2) {
		final Spliterator<T1> sp1 = s1.spliterator();
		final Spliterator<T2> sp2 = s2.spliterator();
		final int c1 = sp1.characteristics();
		final int c2 = sp2.characteristics();
		final int c = productCharacteristics(c1, c2);
		final Iterator<Tuple2<T1, T2>> i = new Tuple2Productor<T1, T2>(
				Spliterators.iterator(sp1),
				Spliterators.iterator(sp2)
				);
		
		if((c & Spliterator.SIZED) != 0) {
			long limit = sp1.getExactSizeIfKnown() * sp2.getExactSizeIfKnown();
			assert(limit < 0);
			return StreamSupport.stream(Spliterators.spliterator(i, limit, c), false);
		}
		
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(i, c), false);
	}

	private static int zipCharacteristics(int... c) {
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

	private static int productCharacteristics(int... c) {
		int con = Arrays.stream(c).reduce((l, r) -> l & r).getAsInt();
		return (Spliterator.CONCURRENT & (con))
			 | (Spliterator.DISTINCT   & (con))
			 | (Spliterator.IMMUTABLE  & (con))
			 |  Spliterator.NONNULL
			 | (Spliterator.ORDERED    & (con))
			 | (Spliterator.SIZED      & (con));
	}
	
	private static class Tuple2Productor<T1, T2> implements Iterator<Tuple2<T1, T2>> {
		private final Iterator<T1> i1;
		private final List<T2> l2;
		private T1 v1;
		private Iterator<T2> i2;
		private boolean hasNext;
		
		@SuppressWarnings("serial")
		public Tuple2Productor(Iterator<T1> i1, Iterator<T2> i2) {
			this.l2 = Collections.unmodifiableList(
					new ArrayList<T2>(){{
						while(i2.hasNext())
							add(i2.next());
					}});
			this.i1 = i1;
			this.i2 = l2.iterator();
			if(i1.hasNext() && this.i2.hasNext()) {
				v1 = i1.next();
				hasNext = true;
			} else {
				hasNext = false;
			}
		}

		@Override
		public boolean hasNext() {
			return hasNext;
		}

		@Override
		public Tuple2<T1, T2> next() {
			if(!hasNext)
				throw new NoSuchElementException();
			
			if(!i2.hasNext() && i1.hasNext()) {
				v1 = i1.next();
				i2 = l2.iterator();
			}
			final Tuple2<T1, T2> retVal = newTuple(v1, i2.next());
			hasNext = i1.hasNext() || i2.hasNext();	
			return retVal;
		}
	}
}
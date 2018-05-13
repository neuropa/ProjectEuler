package net.projecteuler.utils;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

public class FibonacciSeries
{
	private long first = 0;
	private long second = 1;
	private long skip = 0;

	public FibonacciSeries()
	{
		this(0, 1, false);
	}

	public FibonacciSeries(final long first, final long second)
	{
		this(first, second, true);
	}

	public FibonacciSeries(final long first, final long second, final boolean skip)
	{
		this.first = first;
		this.second = second;
		this.skip = (skip ? 2 : 0);
	}

	public List<Long> getNext(final int count) throws IllegalArgumentException
	{
		if (count <= 0)
			throw new IllegalArgumentException("Element must be positive;");

		final Stream<Long> fibonacciStream = getFibonacciSeriesStream(first, second);
		final List<Long> elements = fibonacciStream.skip(skip).limit(count).collect(toList());

		skip = count > 1 ? 2 : 0;
		second = (count > 1 ? elements.get(count - 1) : second + first);
		first = (count > 1 ? elements.get(count - 2) : second - first);

		return elements;
	}

	private Stream<Long> getFibonacciSeriesStream(final long first, final long second)
	{
		return Stream.iterate(new long[] { first, second }, s -> new long[] { s[1], s[0] + s[1] }).map(n -> n[0]);
	}
}
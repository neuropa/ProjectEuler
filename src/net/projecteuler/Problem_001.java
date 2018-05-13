package net.projecteuler;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Bence
 * 
 * Problem 1: Multiples of 3 and 5
 * 
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem_001
{
	public static void main(String[] args)
	{
		for (int count = 0; count < 10; count++) {
			System.out.println(fibonacci2().limit(10));
		}
		
	}

	public static Stream<Integer> fibonacci2()
	{ // ref: Java 8 in Action, section 5.7;
		return Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).map(t -> t[0]);
	}

	public static Stream<Integer> fibonacci3()
	{
		IntSupplier s = new IntSupplier() {
			int previous = 0;
			int current = 1; // <- record the states;

			@Override
			public int getAsInt()
			{
				int retval = previous;
				int next = current + previous;
				previous = current;
				current = next;
				return retval;
			}
		};

		return IntStream.generate(s).boxed();
	}
}
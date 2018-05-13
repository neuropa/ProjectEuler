package net.projecteuler;

import java.util.Arrays;

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
		final Long startedAt = System.currentTimeMillis();
		final long result = solution_1(1000, 3, 5);
		final Long finishedAt = System.currentTimeMillis();

		System.out.println(result + " [" + (finishedAt - startedAt) + " ms]");
	}

	public static long solution_1(final int limit, final int... divisors)
	{
		long sum = 0;

		for (int number = Arrays.stream(divisors).min().getAsInt(); number < limit; number++)
		{
			for (final int divisor : divisors)
			{
				if (number % divisor == 0)
				{
					sum += number;
					break;
				}
			}
		}

		return sum;
	}
}
import java.util.Scanner;

public class RunTimerMain {

	public static long alg1(int iterations)	
	{
		long startTime = System.currentTimeMillis();
		int sum = 0;

		for (int i = 0; i < iterations; i++)
		{sum++;}

		long endTime =  System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		System.out.println("Algorithm 1:" + timeElapsed);
		return sum;

	}

	public static long alg2(int iterations)	
	{
		long startTime = System.currentTimeMillis();
		int sum = 0;

		for (int i = 0; i < iterations; i++)
		{
			for (int j=0; j < iterations; j++)
			{
				sum++;
			}
		}

		long endTime =  System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		System.out.println("Algorithm 2:" + timeElapsed);
		return sum;

	}

	public static long alg3(int iterations)	
	{
		long startTime = System.currentTimeMillis();
		int sum = 0;

		for (int i = 0; i < iterations; i++)
		{
			for (int j=0; j < iterations*iterations; j++)
			{
				sum++;
			}
		}

		long endTime =  System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		System.out.println("Algorithm 3:" + timeElapsed);
		return sum;

	}

	public static long alg4(int iterations)	
	{
		long startTime = System.currentTimeMillis();
		int sum = 0;

		for (int i = 0; i < iterations; i++)
		{
			for (int j=0; j < i; j++)
			{
				sum++;
			}
		}

		long endTime =  System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		System.out.println("Algorithm 4:" + timeElapsed);
		return sum;

	}

	public static long alg5(int iterations)	
	{
		long startTime = System.currentTimeMillis();
		int sum = 0;

		for (int i = 0; i < iterations; i++)
		{
			for (int j=0; j < i*i; j++)
			{
				for (int k = 0; k < j; k++)
				{
					sum++;
				}

			}
		}


		long endTime =  System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		System.out.println("Algorithm 5:" + timeElapsed);
		return sum;

	}
	public static void alg6(int iterations)	
	{
		int startTime = (int)System.currentTimeMillis();

		int sum = 0;

		for (int i = 1; i < iterations; i++)
		{
			for (int j=1; j < i*i; j++)
			{
				if (j % i == 0)
				{
					for (int k = 0; k < j; k++)
					{
						sum++;
					}

				}
			}
		}
		int endTime =  (int)System.currentTimeMillis();
		int timeElapsed = (int) (endTime - startTime);
		System.out.println("Algorithm 6:" + timeElapsed);

	}




	public static void main(String[] args) {
		System.out.println("Please enter the number you would like to run through the algorithm");
		Scanner sc = new Scanner(System.in);
		int iterations = sc.nextInt();
		alg1(iterations);
		alg2(iterations);
		alg3(iterations);
		alg4(iterations);
		alg5(iterations);
		alg6(iterations);
	}





}



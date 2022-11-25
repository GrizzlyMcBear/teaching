using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;

namespace Introduction.QuestionsSolutions {

	// You can always develop a fail-proof system,
	// You can never develop a fool-proof system!
	public class Question04 {
		private static void Solution() {
			Random random = new Random();
			int amount = random.Next();

			Console.Write("Please enter a negative number: ");
			int negative = int.Parse(Console.ReadLine());
			Console.Write("Please enter a positive number: ");
			int positive = int.Parse(Console.ReadLine());

			if (negative >= 0 || positive <= 0) {// At least one of the bounds is invalid
				Console.WriteLine("Those are the wrong numbers!");
			} else {// The `lower` and `upper` bounds are valid
				int invalid1 = Math.Max(positive, Math.Abs(negative)) + 1;
				int invalid2 = Math.Max(positive, Math.Abs(negative)) + 2;

				int firstClosest = invalid1;
				int secondClosest = invalid2;

				for (int i = 1; i <= amount; i++) {// Create `amount` random numbers

					// Create the random number
					int number = random.Next(negative, positive);

					if (number != 0) {// Assume we don't "cheet" and ignore the number when it is 0
						// Find its distance from zero
						int currDistFromZero = Math.Abs(number);

						// Check the distance of `number`
						if (currDistFromZero < Math.Abs(firstClosest)) {// Closer to zero than `firstClosest`
							int temp = firstClosest;
							firstClosest = number;
							secondClosest = temp;
						} else if (currDistFromZero < Math.Abs(secondClosest)) {// Closer to zero than `secondClosest`
							secondClosest = number;
						}
					}
				}

				// Question 1: how could we find out if `firstClosest` or `secondClosest` still contain invalid (initial) values?
				// Question 2: find another answer to question 1.
			}
		}
		public static void TestSolution() {
			Solution();
		}
	}
}

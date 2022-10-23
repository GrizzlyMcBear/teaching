using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionsSolutions.Questions {
	public class Question05 {
		private static int firstNumber;
		private static int secondNumber;
		private static int thirdNumber;
		private static int fourthNumber;
		private static int firstLargest;
		private static int secondLargest;
		private static int thirdLargest;
		private static int fourthLargest;

		private static void ResetValues() {
			firstNumber = -1;
			secondNumber = -1;
			thirdNumber = -1;
			fourthNumber = -1;
			firstLargest = -1;
			secondLargest = -1;
			thirdLargest = -1;
			fourthLargest = -1;
		}
		private static void ReadInputFromUser() {
			Console.WriteLine("Please enter 4 numbers to get their order:");
			Console.Write("First number: ");
			firstNumber = int.Parse(Console.ReadLine());
			Console.Write("Second number: ");
			secondNumber = int.Parse(Console.ReadLine());
			Console.Write("Third number: ");
			thirdNumber = int.Parse(Console.ReadLine());
			Console.Write("Fourth number: ");
			fourthNumber = int.Parse(Console.ReadLine());
		}
		private static void PrintNumbers() {
			Console.WriteLine("The 4 numbers entered by their size are:");
			Console.WriteLine("First largest (largest): " + firstLargest);
			Console.WriteLine("Second largest: " + secondLargest);
			Console.WriteLine("Third largest: " + thirdLargest);
			Console.WriteLine("Fourth largest (smallest): " + fourthLargest);
		}
		public static void PrintIntegersByOrder1() {
			ResetValues();
			ReadInputFromUser();

			// Find the largest and smallest numbers
			firstLargest = Math.Max(Math.Max(firstNumber, secondNumber), 
				Math.Max(thirdNumber, fourthNumber));
			fourthLargest = Math.Min(Math.Min(firstNumber, secondNumber), 
				Math.Min(thirdNumber, fourthNumber));

			// Find the two other numbers by their relative size
			int middleNumber1 = -1;
			int middleNumber2 = -1;
			bool secondMiddleFound = false;
			if (firstNumber != firstLargest && firstNumber != fourthLargest) {
				middleNumber1 = firstNumber;
			} else if (secondNumber != firstLargest && secondNumber != fourthLargest) {
				middleNumber1 = secondNumber;
			} else {
				middleNumber1 = thirdNumber;
				middleNumber2 = fourthNumber;
				secondMiddleFound = true;
			}

			if (!secondMiddleFound) {
				if (secondNumber != firstLargest && secondNumber != fourthLargest && secondNumber != middleNumber1) {
					middleNumber2 = secondNumber;
				} else if (thirdNumber != firstLargest && thirdNumber != fourthLargest) {
					middleNumber2 = thirdNumber;
				} else {
					middleNumber2 = fourthNumber;
				}
			}

			secondLargest = Math.Max(middleNumber1, middleNumber2);
			thirdLargest = Math.Min(middleNumber1, middleNumber2);

			PrintNumbers();
		}
		
		public static void PrintIntegersByOrder2() {
			ResetValues();
			ReadInputFromUser();

			// Swap the numbers to propagate the largest into `fourthNumber` and smallest into `firstNumber`
			int tempNum;
			
			// Pass #1
			if (firstNumber > secondNumber) {
				tempNum = firstNumber;
				firstNumber = secondNumber;
				secondNumber = tempNum;
			}
			if (secondNumber > thirdNumber) {
				tempNum = secondNumber;
				secondNumber = thirdNumber;
				thirdNumber = tempNum;
			}
			if (thirdNumber > fourthNumber) {
				tempNum = thirdNumber;
				thirdNumber = fourthNumber;
				fourthNumber = tempNum;
			}

			// Pass #2
			if (firstNumber > secondNumber) {
				tempNum = firstNumber;
				firstNumber = secondNumber;
				secondNumber = tempNum;
			}
			if (secondNumber > thirdNumber) {
				tempNum = secondNumber;
				secondNumber = thirdNumber;
				thirdNumber = tempNum;
			}

			// Pass #3
			if (firstNumber > secondNumber) {
				tempNum = firstNumber;
				firstNumber = secondNumber;
				secondNumber = tempNum;
			}

			PrintNumbers();
		}

		private static void Swap1and2() {
			int tempNum;
			if (firstNumber > secondNumber) {
				tempNum = firstNumber;
				firstNumber = secondNumber;
				secondNumber = tempNum;
			}
		}
		private static void Swap2and3() {
			int tempNum;
			if (secondNumber > thirdNumber) {
				tempNum = secondNumber;
				secondNumber = thirdNumber;
				thirdNumber = tempNum;
			}
		}
		private static void Swap3and4() {
			int tempNum;
			if (thirdNumber > fourthNumber) {
				tempNum = thirdNumber;
				thirdNumber = fourthNumber;
				fourthNumber = tempNum;
			}
		}
		public static void PrintIntegersByOrder3() {
			ResetValues();
			ReadInputFromUser();

			// Swap the numbers to propagate the largest into `fourthNumber` and smallest into `firstNumber`
			Swap1and2();
			Swap2and3();
			Swap3and4();

			Swap1and2();
			Swap2and3();
			
			Swap1and2();

			PrintNumbers();
		}
	}
}

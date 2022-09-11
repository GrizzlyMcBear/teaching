using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Input {
	public class Program {
		public static void Main(string[] args) {
			ReadAndPrintInput();
			ReadAndPrintManipulatedAge();
			ReadAndPrintFormattedAge();
		}
		/// <summary>
		/// This method asks the user for input and prints it.
		/// </summary>
		public static void ReadAndPrintInput() {
			// Print the request for the user
			Console.Write("Please enter your input: ");

			/* Call `Console.ReadLine()` to read the user's input,
			 * then store it inside a string variable called `userInput` */
			string userInput = Console.ReadLine();

			/* Print an informative message with the user's age -
			 * combine (concatenate) the two together */
			Console.WriteLine("This is the user's input: " + userInput);
		}
		public static void ReadAndPrintManipulatedAge() {
			Console.Write("Please enter your age: ");
			string userInput = Console.ReadLine();
			int userAge = Convert.ToInt32(userInput);
			Console.WriteLine("Your age is: " + userAge + ", next year you'll be " +
				(userAge + 1) + " years old.");
		}

		public static void ReadAndPrintFormattedAge() {
			Console.Write("Please enter your age: ");
			string userInput = Console.ReadLine();
			int userAge = Convert.ToInt32(userInput);

			string userOutput = "Your age is: " + userAge;
			Console.WriteLine(userOutput);

			userOutput = String.Format("We can also duplicate your age ({0}) and get ({1})",
				userAge, userAge * 2);//, userAge + 1);
			Console.WriteLine(userOutput);
		}
	}
}

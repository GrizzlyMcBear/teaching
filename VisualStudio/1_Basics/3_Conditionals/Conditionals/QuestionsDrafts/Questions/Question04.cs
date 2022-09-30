using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionsDrafts.Questions {
	public class Question04 {
		public static void CalculatorProgram() {
			double number1;
			double number2;
			int operatorCode;
			string userInput;

			// Ask the user for the 1st number
			Console.Write("Please enter the 1st number: ");
			userInput = Console.ReadLine();
			number1 = double.Parse(userInput);

			// Ask the user for the 2nd number
			Console.Write("Please enter the 2nd number: ");
			userInput = Console.ReadLine();
			number2 = double.Parse(userInput);

			// Ask the user for the operation
			Console.WriteLine("Please enter the desired operation's code:");
			Console.WriteLine("1 - Addition");
			Console.WriteLine("2 - Subtraction");
			Console.WriteLine("3 - Multiplication");
			Console.WriteLine("4 - Division");
			userInput = Console.ReadLine();
			operatorCode = int.Parse(userInput);

			// Check the input's validity, calculate and print the appropriate output
			if (operatorCode == 1) {// Addition
				Console.WriteLine(number1 + " + " + number2 + " = " + (number1 + number2));

				/* Note: we could've used the variable `userInput` because it still
				 * contains the user's input of the desired operation.
				 */
			} else if (operatorCode == 2) {// Subtraction
				Console.WriteLine(number1 + " - " + number2 + " = " + (number1 - number2));
			} else if (operatorCode == 3) {// Multiplication
				Console.WriteLine(number1 + " * " + number2 + " = " + (number1 * number2));
			} else if (operatorCode == 4) {// Division
				if (number2 == 0) {
					Console.WriteLine("Error: cannot divide by zero!");
				} else {
					Console.WriteLine(number1 + " / " + number2 + " = " + (number1 / number2));
				}
			} else {
				Console.WriteLine("Error: invalid operation code!");
			}
		}
	
		// Todo: finish writing this method
		public static void CalculatorProgramSwitch() {

		}
	}
}

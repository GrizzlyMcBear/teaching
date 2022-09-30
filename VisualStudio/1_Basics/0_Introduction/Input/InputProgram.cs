using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Input {
	public class InputProgram {
		public static void Main(string[] args) {
			//ReadingString();
			ReadingInt();
			//ReadingOtherVariables();
		}

		public static void ReadingString() {
			Console.Write("Please enter your first name: ");
			string userFirstName = Console.ReadLine();
			Console.Write("Please enter your last name: ");
			string userLastName = Console.ReadLine();

			Console.WriteLine("Greetings " + userLastName + " " + userFirstName);
		}
		public static void ReadingInt() {
			Console.Write("Please enter your age: ");
			string userAgeStr = Console.ReadLine();

			// Now convert the input into the desired type
			int userAge = int.Parse(userAgeStr);

			Console.WriteLine("Last year you were " + (userAge - 1) + " years old");
		}
		public static void ReadingOtherVariables() {
			Console.Write("Enter a double: ");
			string doubleInput = Console.ReadLine();

			Console.Write("Enter a char: ");
			string charInput = Console.ReadLine();

			Console.Write("Enter a bool: ");
			string boolInput = Console.ReadLine();

			// Now convert and print those inputs
			double doubleValue = double.Parse(doubleInput);
			char charValue = char.Parse(charInput);
			bool boolValue = bool.Parse(boolInput);
			Console.WriteLine("Your double is: " + doubleValue + ", your char is: " + charValue +
				", and your bool is: " + boolValue);
		}
	}
}

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
		}

		public static void ReadAndPrintInput() {
			Console.Write("Please enter your input: ");
			string userInput = Console.ReadLine();
			Console.WriteLine("This is the user's input: " + userInput);
		}

		public static void ReadAndPrintManipulatedAge() {
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

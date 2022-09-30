using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Output {
	public class OutputProgram {
		public static void Main(string[] args) {
			OutputMethods();
			PrintingValues();
			PrintingResults();
			FormattingOutput();
		}
		public static void OutputMethods() {
			Console.WriteLine("This command prints text and descends 1 line.");
			Console.Write("This command prints text and stays in the same line.");
			Console.WriteLine();// We can also print nothing and descend 1 line
		}
		public static void PrintingValues() {
			// We can print a string
			Console.WriteLine("This is a string.");

			// We can print an int (which would be converted into a string and then printed).
			Console.WriteLine(12);

			// We can do the same with a double, float, char or a boolean
			Console.WriteLine(1.1234);
			Console.WriteLine(1.1234f);
			Console.WriteLine('c');
			Console.WriteLine(true);
		}
		public static void PrintingResults() {
			// We can print the result of an arithmetic calculation
			Console.WriteLine(7 + 8);
			Console.WriteLine(5.2 / 3);

			// And we can concatenate (combine/glue) several values/items
			Console.WriteLine("My age is " + 13);

			// However, when we try to combine the two above, see what happens
			Console.WriteLine("Next year I'll be " + 13 + 1);
			Console.WriteLine("Twice my age is " + 13 * 2);// Notice the operators' precedence

			// In order to do the same correctly, we'll use parenthesis
			Console.WriteLine("Next year I'll be " + (13 + 1));
			Console.WriteLine("Twice my age is " + (13 * 2));
		}
		public static void FormattingOutput() {
			int userAge = 21;
			string userOutput = String.Format("We can duplicate your age:{0} and get: {1}, then use your age again: {0} and again: {0} and so on and so forth...",
				userAge, userAge * 2);
			Console.WriteLine(userOutput);
		}
	}
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Output {
	public class Program {
		public static void Main(string[] args) {
			Console.WriteLine("This command prints text and descends 1 line.");
			Console.Write("This command prints text and stays in the same line.");
			Console.WriteLine();// We can also print nothing and descend 1 line

			Console.WriteLine(7 + 8);// And also print the result of arithmetic expressions
			Console.WriteLine("But see what happens when we combine text and arithmetic expression: " + 7 + 8);
		}
	}
}

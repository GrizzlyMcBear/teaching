using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionsDrafts {
	public class Program {
		public static void Main(string[] args) {
			Console.WriteLine("Hello World!");
		}

		public static void Question1() {
			int a = 25;
			int b = 10;
			int x, y;

			y = Math.Abs(a - b);
			x = b - a;

			if (x == y)
				Console.WriteLine("print1");
			else
				Console.WriteLine("print2");
		}

		public static void Question2() {
			int x = 3;
			int y = 7;
			int temp;

			y = x + y;
			x = y - x;
			y = y - x;

			Console.WriteLine("x = " + x + " y = " + y);

			if (x >= y) {
				temp = x;
				x = y;
				y = temp;
				Console.WriteLine("x = " + x + " y = " + y);
			}
		}

		/*
		public static void ConditionalAlgorithm1() {
			// Code Block 1
			if ( Condition 1 ) {
				// Code Block 2
			} else if ( Condition 2 ) {
				// Code Block 3
			} else {
				// Code Block 4
			}
			// Code Block 5
		}
		*/
	}
}

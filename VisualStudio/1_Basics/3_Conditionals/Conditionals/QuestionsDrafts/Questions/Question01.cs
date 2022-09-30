using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionsDrafts.Questions {
	public class Question01 {
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
	}
}

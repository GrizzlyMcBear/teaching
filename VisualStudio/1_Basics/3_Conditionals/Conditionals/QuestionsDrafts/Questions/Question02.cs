using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionsDrafts.Questions {
	public class Question02 {
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
	}
}

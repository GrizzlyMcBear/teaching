using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Declaration {
	public class Program {
		public static void Main(string[] args) {
			string name = "ronen";
			int hour = 12;

			if (hour < 0 || hour > 24) {// Invalid input
				Console.WriteLine("Invalid time");
			} else if (hour >= 0 && hour <= 12) {
				Console.WriteLine("Good morning");
			} else if (hour > 12 && hour <= 17) {
				Console.WriteLine("Good afternoon");
			} else if (hour > 17 && hour <= 20) {
				Console.WriteLine("Good evening");
			} else if (hour > 21 && ) {
				Console.WriteLine("Good night");
			}
			// Other commands
		}
	}
}



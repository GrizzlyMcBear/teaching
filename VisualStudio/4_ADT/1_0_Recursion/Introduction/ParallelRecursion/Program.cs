using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ParallelRecursion {
	public class Program {
		public static void Main(string[] args) {
			Section2();
			Section3();
		}

		public static void Section2() {
			PrintAndDecrease(10);
			Console.WriteLine();
		}
		public static void Section3() {
			DecreaseAndPrint(10);
			Console.WriteLine();
		}
		public static void PrintAndDecrease(int limit) {
			if (limit <= 0) {
				Console.Write("");
			} else {
				Console.Write(limit + ",");
				DecreaseAndPrint(limit - 1);
			}
		}
		public static void DecreaseAndPrint(int limit) {
			if (limit <= 0) {
				Console.Write("");
			} else {
				PrintAndDecrease(limit - 1);
				Console.Write(limit + ",");
			}
		}
	}
}

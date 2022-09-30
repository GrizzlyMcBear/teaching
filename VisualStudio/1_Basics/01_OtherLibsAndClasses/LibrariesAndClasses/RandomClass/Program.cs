using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RandomClass {
	public class Program {
		public static void Main(string[] args) {
			Random random = new Random();
			int regularRandom = random.Next();
			int randomWithMax = random.Next(100);
			int randomWithLimits = random.Next(-500, 200);
			Console.WriteLine("Regular random: " + regularRandom);
			Console.WriteLine("Random with maximum value: " + randomWithMax);
			Console.WriteLine("Random with limits: " + randomWithLimits);
		}
	}
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Schema;

namespace QuestionsDrafts.LabFirst {
	public class Lab1 {
		public static void MysteryMethod1() {
			int userAge;

			Console.Write("Please enter your age: ");
			userAge = int.Parse(Console.ReadLine());

			Console.WriteLine("If you are older than 16 years, you can get a driver's license.");
			Console.WriteLine("If you are younger than 16 years, you cannot.");
		}

		public static void MysteryMethod2() {
			int userAge;

			Console.Write("Please enter your age: ");
			userAge = int.Parse(Console.ReadLine());

			if (userAge > 16) {
				Console.WriteLine("You can get a driver's license.");
			}

			if (userAge < 16) {
				Console.WriteLine("You cannot get a driver's license.");
			}
		}

		public static void MysteryMethod3() {
			int userAge;

			Console.Write("Please enter your age: ");
			userAge = int.Parse(Console.ReadLine());

			if (userAge >= 0 && userAge <= 120) {
				if (userAge >= 16) {
					Console.WriteLine("You can get a driver's license.");
				}

				if (userAge < 16) {
					Console.WriteLine("You cannot get a driver's license.");
				}
			}

			if (userAge < 0 || userAge > 120) {
				Console.WriteLine("You have entered an illegal age.");
			}
		}
	}
}

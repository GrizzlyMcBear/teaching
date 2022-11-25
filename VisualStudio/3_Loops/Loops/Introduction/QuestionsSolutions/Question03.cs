using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Introduction.QuestionsSolutions {
	public class Question03 {

		static Random random = new Random();
		static int grades = 50;
		static int highest1 = -1;
		static int highest2 = -1;
		static int highest3 = -1;
		static int finestSum = 0;
		static int finestAmount = 0;

		public static void TestSolution() {
			Solution();
		}

		private static void Solution() {
			PrintHeaders();
			PrintFollowupTableLine(0, highest1, highest2, highest3, "Undefined", finestSum, finestAmount, "Undefined");
			for (int i = 0; i < grades; i++) {
				PrintFollowupTableLine(1, highest1, highest2, highest3, "Undefined", finestSum, finestAmount, i.ToString());

				int currGrade = random.Next(0, 101);
				PrintFollowupTableLine(2, highest1, highest2, highest3, currGrade.ToString(), finestSum, finestAmount, i.ToString());
				
				PrintFollowupTableLine(2, highest1, highest2, highest3, currGrade.ToString(), finestSum, finestAmount, i.ToString());

				if (currGrade >= 90) {
					finestAmount++;
					finestSum += currGrade;
				}

				if (highest1 < currGrade) {
					highest3 = highest2;
					highest2 = highest1;
					highest1 = currGrade;
				} else if (highest2 < currGrade) {
					highest3 = highest2;
					highest2 = currGrade;
				} else if (highest3 < currGrade) {
					highest3 = currGrade;
				}
			}

			if (finestAmount == 0) {
				Console.WriteLine("No fine grades.");
			} else {
				Console.WriteLine("Finest average is: " + (1.0 * finestSum / finestAmount));
			}

			Console.WriteLine("Highest 1st = " + highest1 + 
				" Highest 2nd = " + highest2 +
				" Highest 3rd = " + highest3);
		}

		private static void PrintHeaders() {
			Console.WriteLine("  # Command    | Highest Grade | 2nd Highest Grade | 3rd Highest Grade | Current Grade | Finest Grades Sum | Finest Students Amount |    i    ");
			Console.WriteLine("==============================================================================================================================================");
		}

		private static void PrintFollowupTableLine(int command, int highestGrade1, int highestGrade2, int highestGrade3, 
			string currGrade, int finestSum, int finestAmount, string i) {
			Console.WriteLine(String.Format("  {0}    | {1} | {2} | {3} | {4} | {5} |    {6}    | {7} | {8} ", command, highestGrade1, highestGrade2, highestGrade3, currGrade, finestSum, finestAmount, i));
			Console.WriteLine("------------------------------------------------------------------------------------------------------------------------------");
		}
	}
}

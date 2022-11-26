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
			PrintFollowupTableLine(0, highest1, highest2, highest3, "Undefined   ", finestSum, finestAmount, " Undefined ");
			for (int i = 0; i < grades; i++) {
				PrintFollowupTableLine(1, highest1, highest2, highest3, "Undefined   ", finestSum, finestAmount, "\t" + i.ToString());

				int currGrade = random.Next(0, 101);
				PrintFollowupTableLine(2, highest1, highest2, highest3, currGrade.ToString() + "\t\t", finestSum, finestAmount, "\t" + i.ToString());
				

				if (currGrade >= 90) {
					PrintFollowupTableLine(3, highest1, highest2, highest3, currGrade.ToString() + "\t\t", finestSum, finestAmount, "\t" + i.ToString());
					finestAmount++;
					PrintFollowupTableLine(4, highest1, highest2, highest3, currGrade.ToString() + "\t\t", finestSum, finestAmount, "\t" + i.ToString());
					finestSum += currGrade;
					PrintFollowupTableLine(5, highest1, highest2, highest3, currGrade.ToString() + "\t\t", finestSum, finestAmount, "\t" + i.ToString());
				}

				if (highest1 < currGrade) {
					PrintFollowupTableLine(6, highest1, highest2, highest3, currGrade.ToString() + "\t\t", finestSum, finestAmount, "\t" + i.ToString());
					highest3 = highest2;
					PrintFollowupTableLine(7, highest1, highest2, highest3, currGrade.ToString() + "\t\t", finestSum, finestAmount, "\t" + i.ToString());
					highest2 = highest1;
					PrintFollowupTableLine(8, highest1, highest2, highest3, currGrade.ToString() + "\t\t", finestSum, finestAmount, "\t" + i.ToString());
					highest1 = currGrade;
					PrintFollowupTableLine(9, highest1, highest2, highest3, currGrade.ToString() + "\t\t", finestSum, finestAmount, "\t" + i.ToString());
				} else if (highest2 < currGrade) {
					PrintFollowupTableLine(10, highest1, highest2, highest3, currGrade.ToString() + "\t\t", finestSum, finestAmount, "\t" + i.ToString());
					highest3 = highest2;
					PrintFollowupTableLine(11, highest1, highest2, highest3, currGrade.ToString() + "\t\t", finestSum, finestAmount, "\t" + i.ToString());
					highest2 = currGrade;
					PrintFollowupTableLine(12, highest1, highest2, highest3, currGrade.ToString() + "\t\t", finestSum, finestAmount, "\t" + i.ToString());
				} else if (highest3 < currGrade) {
					PrintFollowupTableLine(13, highest1, highest2, highest3, currGrade.ToString() + "\t\t", finestSum, finestAmount, "\t" + i.ToString());
					highest3 = currGrade;
					PrintFollowupTableLine(14, highest1, highest2, highest3, currGrade.ToString() + "\t\t", finestSum, finestAmount, "\t" + i.ToString());
				}
			}

			if (finestAmount == 0) {
				PrintFollowupTableLine(15, highest1, highest2, highest3, "Undefined   ", finestSum, finestAmount, " Undefined ");
				Console.WriteLine("No fine grades.");
				PrintFollowupTableLine(16, highest1, highest2, highest3, "Undefined   ", finestSum, finestAmount, " Undefined ");
			} else {
				PrintFollowupTableLine(17, highest1, highest2, highest3, "Undefined   ", finestSum, finestAmount, " Undefined ");
				Console.WriteLine("Finest average is: " + (1.0 * finestSum / finestAmount));
				PrintFollowupTableLine(18, highest1, highest2, highest3, "Undefined   ", finestSum, finestAmount, " Undefined ");
			}

			Console.WriteLine("Highest 1st = " + highest1 + 
				" Highest 2nd = " + highest2 +
				" Highest 3rd = " + highest3);
			PrintFollowupTableLine(19, highest1, highest2, highest3, "Undefined   ", finestSum, finestAmount, " Undefined ");
		}

		private static void PrintHeaders() {
			Console.WriteLine("  # Command\t| Highest Grade | 2nd High Grade | 3rd High Grade | Curr Grade  | Finest Grades Sum\t| Finest Students Amount |    i\t\t |");
			Console.WriteLine("==================================================================================================================================================");
		}

		private static void PrintFollowupTableLine(int command, int highestGrade1, int highestGrade2, int highestGrade3, 
			string currGrade, int finestSum, int finestAmount, string i) {
			Console.WriteLine(String.Format("\t{0}\t|\t{1}\t|\t{2}\t |\t{3}\t  | {4}|\t{5}\t\t|\t{6}\t\t |{7}\t |", 
				command, highestGrade1, highestGrade2, highestGrade3, currGrade, finestSum, finestAmount, i));
			Console.WriteLine("--------------------------------------------------------------------------------------------------------------------------------------------------");
		}
	}
}

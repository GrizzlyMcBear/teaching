using System;
using System.Collections.Generic;
using System.Text;

namespace Introduction {
	public class Exercise {

		/// <summary>
		/// טענת כניסה: ראו את שורת החתימה של הפעולה
		/// טענת יציאה: הפעולה מחזירה מערך המכיל מספרים שלמים וחיוביים בערכים ובכמות שהוגדרו ע"י המשתמש
		/// </summary>
		/// <returns></returns>
		public static int[] getIntArray() {
			int[] result;

			Console.Write("Please enter the amount of numbers: ");
			result = new int[int.Parse(Console.ReadLine())];

			for (int i = 0; i < result.Length; i++) {
				Console.Write("Enter number #{0}", i+1);
				result[i] = int.Parse(Console.ReadLine());
			}

			return result;
		}
		/// <summary>
		/// טענת כניסה: ראו את שורת החתימה של הפעולה
		/// טענת יציאה: הפעולה מקבלת מערך של מספרים שלמים, ומחזירה את האיבר הגדול ביותר.
		/// הערה: התוכנית תדפיס הודעה מתאימה במידה והקלט אינו תקין ואז תחזיר את הערך -1
		/// </summary>
		/// <param name="numbers"></param>
		/// <returns></returns>
		public static int maxNum(int[] numbers) {
			int maxNum = -1;
			if (numbers == null) {
				Console.WriteLine("The given array wasn't defined!");
			} else if (numbers.Length == 0) {
				Console.WriteLine("The given array has no items!");
			} else {
				for (int i = 0; i < numbers.Length; i++) {
					if (maxNum < numbers[i])
						maxNum = numbers[i];
				}
			}

			return maxNum;
		}
	}
}
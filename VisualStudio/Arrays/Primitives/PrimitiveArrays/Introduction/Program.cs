using System;

namespace Introduction {
	public class Program {
		public static void Main(string[] args) {
			double avgAmount = getAverageVirusAmount();
			Console.WriteLine("The average amount of viruses is: " + avgAmount);
		}

		/// <summary>
		/// טענת כניסה: ראו את שורת החתימה של הפעולה
		/// טענת יציאה: הפעולה קוראת 4 ערכי דגימת נגיפים, מחשבת את הממוצע שלהם ומחזירה אותו
		/// </summary>
		/// <returns></returns>
		public static double getAverageVirusAmount() {
			int totalVirusAmount = 0;
			int currVirusAmount = 0;

			Console.WriteLine("Please enter the virus amount in 4 samples:");

			for (int i = 0; i < 4; i++) {
				Console.Write("Sample #" + (i+1) + ": ");
				currVirusAmount = int.Parse(Console.ReadLine());// נתעלם מבדיקת תקינות הקלט כעת
				totalVirusAmount += currVirusAmount;
			}

			// השורה הבאה אינה עובדת כשורה, שנו אותה כדי שתעבוד באופן תקין
			return totalVirusAmount / 4;
		}

		/// <summary>
		/// שימו לב, זוהי פעולה שאינו כתובה טוב!!!
		/// אין לקחת ממנה דוגמא כיצד כותבים קוד
		/// 
		/// 
		/// טענת כניסה: ראו את שורת החתימה של הפעולה
		/// טענת יציאה: הפעולה קוראת 4 ערכי דגימת נגיפים,
		/// מדפיסה את כמות הדגימות עם ערך מעל הממוצע ומחזירה את הממוצע
		/// </summary>
		/// <returns></returns>
		public static double getAvgVirusPrintAmountAbove() {
			int sample1Amount = 0;
			int sample2Amount = 0;
			int sample3Amount = 0;
			int sample4Amount = 0;

			Console.WriteLine("Please enter the virus amount in 4 samples:");

			// נתעלם מבדיקת תקינות הקלט גם כעת ונקרא את ערכי הדגימות
			Console.Write("Sample #1: ");
			sample1Amount = int.Parse(Console.ReadLine());
			Console.Write("Sample #2: ");
			sample2Amount = int.Parse(Console.ReadLine());
			Console.Write("Sample #3: ");
			sample3Amount = int.Parse(Console.ReadLine());
			Console.Write("Sample #4: ");
			sample4Amount = int.Parse(Console.ReadLine());

			// נחשב את ממוצע הנגיפים בדגימות
			double avgVirusAmount = (double)(sample1Amount + sample2Amount + sample3Amount + sample4Amount) / 4;

			// נחשב ונדפיס את כמות הדגימות הגדולות מהממוצע
			int amountAboveAvg = 0;
			if (sample1Amount > avgVirusAmount) amountAboveAvg++;
			if (sample2Amount > avgVirusAmount) amountAboveAvg++;
			if (sample3Amount > avgVirusAmount) amountAboveAvg++;
			if (sample4Amount > avgVirusAmount) amountAboveAvg++;
			Console.WriteLine("The amount of samples above average is: " + amountAboveAvg);

			// נחזיר את ממוצע הנגיפים בדגימות
			return avgVirusAmount;
		}
	}
}

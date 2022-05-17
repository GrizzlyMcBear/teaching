using System;

namespace Introduction {
	public class Program {
		public static void Main(string[] args) {
			// PowerPoint Question 1
			//double avgAmount = getAverageVirusAmount();
			//Console.WriteLine("The average amount of viruses is: " + avgAmount);

			int[] intArr = Exercise.GetIntArray();
			// Exercise 1
			//int maxInt = Exercise.maxNum(intArr);
			//Console.WriteLine("Maximum number is: {0}", maxInt);

			// IndexOutOfRangeException
			MinNumFindIssue(intArr);
		}

		/// <summary>
		/// טענת כניסה: ראו את שורת החתימה של הפעולה
		/// טענת יציאה: הפעולה קוראת 4 ערכי דגימת נגיפים, מחשבת את הממוצע שלהם ומחזירה אותו
		/// </summary>
		/// <returns></returns>
		public static double GetAverageVirusAmount() {
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
		/// טענת כניסה: ראו את שורת החתימה של הפעולה
		/// טענת יציאה: הפעולה קוראת 4 ערכי דגימת נגיפים,
		/// מדפיסה את כמות הדגימות עם ערך מעל הממוצע ומחזירה את הממוצע
		/// </summary>
		/// <returns></returns>
		public static double GetAvgVirusPrintAmountAbove() {
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
	
		/// <summary>
		/// טענת כניסה: ראו את שורת החתימה של הפעולה
		/// טענת יציאה: הפעולה קוראת 1,000,000 ערכי דגימת נגיפים, מחשבת את הממוצע שלהם,
		/// מדפיסה את כמות הדגימות עם ערכים מעל לממוצע ומחזירה את ממוצע הדגימות
		/// </summary>
		/// <returns></returns>
		public static double GetAvgVirusPrintAmountAboveWithArray() {
			int totalVirusAmount = 0;
			int[] virusSamples = new int[1000000];
			double avgVirusAmount = 0.0;
			int samplesAboveAvgAmount = 0;

			// נקלוט את הערכים
			Console.WriteLine("Please enter the virus amount in 1,000,000 samples:");
			for (int i = 0; i < 1000000; i++) {
				Console.Write("Sample #" + (i + 1) + ": ");
				virusSamples[i] = int.Parse(Console.ReadLine());// שוב נתעלם מבדיקת תקינות הקלט
				totalVirusAmount += virusSamples[i];
			}

			// נחשב את הממוצע
			avgVirusAmount = (double)totalVirusAmount / 1000000;

			// נחשב ונדפיס כמה דגימות עם ערכים מעל לממוצע
			for (int i = 0; i < 1000000; i++) {
				if (virusSamples[i] > avgVirusAmount)
					samplesAboveAvgAmount++;
			}
			Console.WriteLine("Samples above average: " + samplesAboveAvgAmount);

			// נחזיר את כמות הנגיפים הממוצעת בבדיקה
			return avgVirusAmount;
		}

		#region Array Definition Methods

		public static void DefineArray1() {
			// נגדיר מערך באורך של מספר קבוע
			int[] array = new int[10];
		}
		public static void DefineArray2() {
			// נגדיר מערך באורך של משתנה
			int size = 10;
			double[] array = new double[size];
		}
		public static void DefineArray3() {
			// נגדיר מערך תוך כדי איפוס שלו
			bool[] array = { false, true, true, false, true };
		}
		public static void DefineArray4() {
			// נגדיר משתנה המצביע על מערך
			long[] array;

			// נאתחל אותו
			array = new long[42];
		}

		#endregion Array Definition Methods

		#region Array Exceptions

		/// <summary>
		/// פעולה זו מכילה בעיה בקוד, נסו למצוא אותה ללא הרצה שלו
		/// ובמידה ואפשר - גם לתקן את הפעולה.
		/// </summary>
		/// <param name="numbers"></param>
		public static void MinNumFindIssue(int[] numbers) {
			if (numbers == null || numbers.Length == 0) {
				Console.WriteLine("Invalid input");
				return;
			}

			int minNum = numbers[0];
			for (int i = 1; i <= numbers.Length; i++) {
				if (numbers[i] < minNum)
					minNum = numbers[i];
			}

			Console.WriteLine("Minimum number is {0}", minNum);
		}

		#endregion Array Exceptions
	}
}

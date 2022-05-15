using System;

namespace PlagueExercise {
	public class Program {
		public static void Main(string[] args) {
			//StrainsRatingsWithLocalVariables();
			//SimpleTestTubeRatings();
			VirusTestTubeRatings();
		}

		//public static void CreateVirus
		/// <summary>
		/// A method showing the use of just local variables
		/// </summary>
		public static void StrainsRatingsWithLocalVariables() {
			Console.WriteLine("Enter ratings for 3 strains:");
			double alphaStrainRating = double.Parse(Console.ReadLine());
			double betaStrainRating = double.Parse(Console.ReadLine());
			double deltaStrainRating = double.Parse(Console.ReadLine());

			Console.WriteLine("Alpha strain's rating is: {0}", alphaStrainRating);
			Console.WriteLine("Beta strain's rating is: {0}", betaStrainRating);
			Console.WriteLine("Delta strain's rating is: {0}", deltaStrainRating);
		}

		/// <summary>
		/// A method showing the usage of an object with a field which contains the data,
		/// this field is an array which stores primitive values.
		/// </summary>
		public static void SimpleTestTubeRatings() {
			PrimitiveTestTube primitiveTestTube = new PrimitiveTestTube(2);

			primitiveTestTube.SetVirusRating(88, 0);
			primitiveTestTube.SetVirusRating(56, 1);
			primitiveTestTube.SetVirusRating(92, 1);

			Console.WriteLine(primitiveTestTube.ToString());
		}

		/// <summary>
		/// This method shows how we could store the data in a more ordered way -
		/// using an object with a field which is an array of other objects.
		/// </summary>
		private static void VirusTestTubeRatings() {
			TestTube testTube = new TestTube(2);

			testTube.SetVirus(0, new Virus("Alpha", 99.1));
			testTube.SetVirus(1, new Virus("Omicron", 100.5));

			Console.WriteLine(testTube.ToString());
		}
	}
}
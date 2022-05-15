using System;
using System.Collections.Generic;
using System.Text;

namespace PlagueExercise {
	public class PrimitiveTestTube {

		private double[] ratings;
		private const int DefaultAmount = 10;

		public PrimitiveTestTube() {
			this.ratings = new double[DefaultAmount];
		}

		public PrimitiveTestTube(int virusAmount) {
			if (virusAmount > 0)
				this.ratings = new double[virusAmount];
		}

		public bool IsIndexValid(int index) {
			return (index >= 0 && index < this.ratings.Length);
		}

		public void SetVirusRating(double rating, int index) {
			// נעדכן את הדירוג לנגיף רק אם הקלט חוקי
			if (IsIndexValid(index) && Virus.IsRatingValid(rating)) {

				// Update the rating in the desired index
				this.ratings[index] = rating;
			}
		}

		public double GetVirusRating(int index) {
			double result;

			if (IsIndexValid(index)) {
				result = this.ratings[index];
			} else {
				result = Virus.MinRating - 1;
				Console.WriteLine("Warning, attempting to access an invalid index ({0})", index);
			}

			return result;
		}

		public int GetRatingsAmounts() {
			return this.ratings.Length;
		}

		public override string ToString() {
			string result = "These are the test tube's ratings:\n";

			for (int index = 0; index < GetRatingsAmounts(); index++) {
				result += string.Format("Virus #{0}: {1}", index, this.ratings[index]);
			}

			return result;
		}
	}
}
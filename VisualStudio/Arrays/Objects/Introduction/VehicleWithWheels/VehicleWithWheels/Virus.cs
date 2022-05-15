using System;
using System.Collections.Generic;
using System.Text;

namespace PlagueExercise {
	public class Virus {

		private double rating;		
		private String name;
		public static double MinRating = 0.0;
		public static double MaxRating = 100.0;

		/// <summary>
		/// Default c'tor, there's a better way of assigning values to properties.
		/// </summary>
		public Virus() {
			this.rating = 0.0;
			this.name = "Unknown";
		}

		/// <summary>
		/// C'tor with arguments.
		/// </summary>
		/// <param name="name"></param>
		/// <param name="rating"></param>
		public Virus(String name, double rating) {
			SetName(name);
			SetRating(rating);
		}
		
		public static bool IsValid(Virus virus) {
			return (virus != null && IsRatingValid(virus.GetRating()) && IsNameValid(virus.GetName()));
		}
		public static bool IsRatingValid(double rating) {
			return (rating >= MinRating && rating <= MaxRating);
		}
		
		public static bool IsNameValid(String name) {
			return (name != null && name.Length != 0);
		}
		
		public void SetRating(double rating) {
			if (IsRatingValid(rating)) {
				this.rating = rating;
			} else {
				Console.WriteLine("Warning: invalid input detected (rating is {0})", rating);
			}
		}
		
		public double GetRating() {
			return this.rating;
		}
		
		public void SetName(String name) {
			if (IsNameValid(name) && !name.Equals(GetName()))
				this.name = name;
		}
		
		public String GetName() {
			return this.name;
		}
		
		public override string ToString() {
			return string.Format("Virus - Name: {0}, Rating: {1}.", GetName(), GetRating());
		}
	}
}
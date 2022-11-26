using Introduction.QuestionsSolutions;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Introduction {
	public class Program {
		public static void Main(string[] args) {
			Question03.TestSolution();
		}

		private static void CalculateProductsSum() {
			// Define a variable to store the total price
			double totalPrice = 0.0;

			// Iterate to read the details for the (5) products
			for (int i = 1; i <= 5; i++) {

				// Read the products' details
				Console.Write("Please enter the price per unit: ");
				double pricePerUnit = double.Parse(Console.ReadLine());
				Console.Write("Please enter the amount of units: ");
				int unitAmount = int.Parse(Console.ReadLine());

				// Add this product's overall price to the total products' price
				totalPrice += pricePerUnit * unitAmount;
			}

			// Print the total products' price
			Console.WriteLine("The total price is : " + totalPrice);
		}
	}
}

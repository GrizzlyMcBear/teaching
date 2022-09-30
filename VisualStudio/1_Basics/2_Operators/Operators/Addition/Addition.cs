using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Addition {
	public class Addition {

		public static void Main(string[] args) {
			Console.Write("For the calculator app, please enter the first number: ");
			string userInput = Console.ReadLine();
			double operand1 = double.Parse(userInput);

			Console.Write("And now the second operand: ");
			double operand2 = double.Parse(Console.ReadLine());

			Console.WriteLine("Enter a number for the desired operation:");
			Console.WriteLine("1: Addition");
			Console.WriteLine("2: Subtraction");
			Console.WriteLine("3: Multiplication");
			Console.WriteLine("4: Division");
			Console.WriteLine("5: Division Remainder");
			string userOperator = Console.ReadLine();
			int operatorCode = int.Parse(userOperator);

			double result = 0.0;
			/*
			if (operatorCode == 1) {
				result = operand1 + operand2;
			} else if (operatorCode == 2) {
				result = operand1 - operand2;
			} else if (operatorCode == 3) {
				result = operand1 * operand2;
			} else if (operatorCode == 4) {
				if (operand2 == 0) {
					Console.WriteLine("Error, denominator can't be zero!");
				} else {
					result = operand1 / operand2;
				}
			} else if (operatorCode == 5) {
				if (operand2 == 0) {
					Console.WriteLine("Error, denominator can't be zero!");
				}
				else {
					result = operand1 % operand2;
				}
			} else {
				Console.WriteLine("Your operation is illegal!");
			}
			*/

			char temp = '*';
			switch (temp) {
				case '+':
					Console.WriteLine("asdf");
					break;
				default:
					break;
			}
			switch (operatorCode) {
				case 1:
					result = operand1 + operand2;
					break;
				case 2:
					result = operand1 - operand2;
					break;
				case 3:
					result = operand1 * operand2;
					break;
				case 4:
					if (operand2 == 0) {
						Console.WriteLine("Error, denominator can't be zero!");
					}
					else {
						result = operand1 / operand2;
					}
					break;
				default:
					Console.WriteLine("Your operation is illegal!");
					break;
			}
			Console.WriteLine("The result of " + operand1 + userOperator +
					operand2 + " = " + (operand1 + operand2));








			Console.WriteLine("Now printing the results of the arithmetic operators: ");
			Integers();
			DoubleFloatingPoint();
			//SingleFloatingPoint();
			//Characters();
			//Strings();
			//Booleans();
		}
		public static void Integers() {
			Console.WriteLine("Please enter 2 integer operands:");
			Console.Write("First: ");
			int integer1 = int.Parse(Console.ReadLine());
			Console.Write("Second: ");
			int integer2 = int.Parse(Console.ReadLine());

			Console.WriteLine("For the integer numbers: " + integer1 + ", and " + integer2 + ":");
			Console.WriteLine(integer1 + " + " + integer2 + " = " + (integer1 + integer2));
			Console.WriteLine(integer2 + " + " + integer1 + " = " + (integer2 + integer1));
			Console.WriteLine(integer1 + " - " + integer2 + " = " + (integer1 - integer2));
			Console.WriteLine(integer2 + " - " + integer1 + " = " + (integer2 - integer1));
			Console.WriteLine(integer1 + " / " + integer2 + " = " + (integer1 / integer2));
			Console.WriteLine(integer2 + " / " + integer1 + " = " + (integer2 / integer1));
			Console.WriteLine(integer1 + " * " + integer2 + " = " + (integer1 * integer2));
			Console.WriteLine(integer2 + " * " + integer1 + " = " + (integer2 * integer1));
			Console.WriteLine(integer1 + " % " + integer2 + " = " + (integer1 % integer2));
			Console.WriteLine(integer2 + " % " + integer1 + " = " + (integer2 % integer1));
		}
		public static void DoubleFloatingPoint() {
			Console.WriteLine("Please enter 2 double operands:");
			Console.Write("First: ");
			double double1 = double.Parse(Console.ReadLine());
			Console.Write("Second: ");
			double double2 = double.Parse(Console.ReadLine());

			Console.WriteLine("For the double-floating-point numbers: " + double1 + ", and " + double2 + ":");
			Console.WriteLine(double1 + " + " + double2 + " = " + (double1 + double2));
			Console.WriteLine(double2 + " + " + double1 + " = " + (double2 + double1));
			Console.WriteLine(double1 + " - " + double2 + " = " + (double1 - double2));
			Console.WriteLine(double2 + " - " + double1 + " = " + (double2 - double1));
			Console.WriteLine(double1 + " / " + double2 + " = " + (double1 / double2));
			Console.WriteLine(double2 + " / " + double1 + " = " + (double2 / double1));
			Console.WriteLine(double1 + " * " + double2 + " = " + (double1 * double2));
			Console.WriteLine(double2 + " * " + double1 + " = " + (double2 * double1));
			Console.WriteLine(double1 + " % " + double2 + " = " + (double1 % double2));
			Console.WriteLine(double2 + " % " + double1 + " = " + (double2 % double1));
		}
		public static void SingleFloatingPoint() {
			float float1 = 13.3f;
			float float2 = 12.5f;
		}
		public static void Characters() {
			char char1 = 'a';
			char char2 = 'b';
		}
		public static void Strings() {
			string string1 = "Israel";
			string string2 = "Israeli";
		}
		public static void Booleans() {
			bool bool1 = true;
			bool bool2 = false;
		}
	}
}

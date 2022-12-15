using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Node;

namespace QuestionsSolutions.Solutions {
	public class Question06 {
		public static Node<int> FullAdder() {
			
			// Representing the numbers
			Node<int> firstNumber = ReadNumber();
			Node<int> secondNumber = ReadNumber();
			Node<int> sumResult = new Node<int>(0);

			// Help variables
			Node<int> currFirstDigNode = firstNumber;
			Node<int> currSecondDigNode = secondNumber;
			Node<int> currSummationResult = sumResult;
			int currFirstDig = 0;
			int currSecondDig = 0;
			int currDigSum = 0;
			int reminder = 0;
			int currResultDig = 0;

			// Go over all of the numbers' digits (nodes lists)
			while (currFirstDigNode != null || currSecondDigNode != null || reminder != 0) {

				// Obtain the digits' numeric values
				currFirstDig = (currFirstDigNode != null ? currFirstDigNode.GetValue() : 0);
				currSecondDig = (currSecondDigNode != null ? currSecondDigNode.GetValue() : 0);
				
				// Calculate the current digit result and remainder
				currDigSum = reminder + currFirstDig + currSecondDig;
				reminder = currDigSum / 10;
				currResultDig = currDigSum % 10;

				// Update the result node
				currSummationResult.SetValue(currResultDig);

				// Continue 'scanning' the numbers
				currFirstDigNode = (currFirstDigNode != null ? currFirstDigNode.GetNext() : null);
				currSecondDigNode = (currSecondDigNode != null ? currSecondDigNode.GetNext() : null);
				currSummationResult.SetNext(new Node<int>(0));
				currSummationResult = currSummationResult.GetNext();
			}

			// Print values to verify code correctness:
			/*
			Console.WriteLine(ConvertNumberNodesToString(firstNumber));
			Console.WriteLine(ConvertNumberNodesToString(secondNumber));
			Console.WriteLine(ConvertNumberNodesToString(sumResult));
			*/

			return sumResult;
		}
		private static Node<int> ReadNumber() {
			
			// Read the number from the user
			Console.Write("Please enter a number: ");
			string inputNumber = Console.ReadLine();
			
			// Create local variables
			Node<int> numberNode = new Node<int>(0);
			Node<int> currDigNode = numberNode;

			// Convert the number into a node list
			for (int currDigIndex = (inputNumber.Length-1); currDigIndex >= 0; currDigIndex--) {
				
				// Convert the current digit
				int digit = int.Parse(inputNumber[currDigIndex].ToString());
				currDigNode.SetValue(digit);
				
				// Prepare the next node
				if (currDigIndex > 0) {
					currDigNode.SetNext(new Node<int>(0));
					currDigNode = currDigNode.GetNext();
				}
			}

			return numberNode;
		}
		private static string ConvertNumberNodesToString(Node<int> number) {
			string strNum = "";
			Node<int> currNode = number;

			while (currNode != null) {
				strNum = (currNode.GetValue() + strNum);
				currNode = currNode.GetNext();
			}

			return strNum;
		}
	}
}

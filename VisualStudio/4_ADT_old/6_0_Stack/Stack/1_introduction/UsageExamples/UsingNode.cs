using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ADT;

namespace _1_introduction.UsageExamples {
	public class UsingNode {
		public static void IntegersStack() {
			ADT.Stack<int> intStack = new ADT.Stack<int>();

			Console.WriteLine("Stack emptiness situation: " + intStack.IsEmpty());

			Console.WriteLine("intStack: " + intStack.ToString());
			
			intStack.Push(4);
			Console.WriteLine("Stack emptiness situation: " + intStack.IsEmpty());
			Console.WriteLine("intStack: " + intStack.ToString());

			intStack.Push(3);
			intStack.Push(10);

			Console.WriteLine("intStack: " + intStack.ToString());

			Console.WriteLine("Topmost stack item: " + intStack.Top());
			Console.WriteLine("Popping out the topmost item.");
			intStack.Pop();

			Console.WriteLine("intStack: " + intStack.ToString());
		}
	}
}

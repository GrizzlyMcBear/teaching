using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ADT.Queue {
	public class Reverse {
		public static void TestSolution() {
			List<MOE.Queue<int>> queuesList = CreateData();

			foreach (var queue in queuesList) {
				Console.WriteLine($"Queue before reversing: {queue.ToString()}");
				ReverseRecursive(queue);
				Console.WriteLine($"Queue after reversing: {queue.ToString()}\n");
			}
		}
		private static MOE.Queue<int> ReverseRecursive(MOE.Queue<int> queue) {
			if (queue == null) return queue;
			if (queue.IsEmpty()) return queue;

			int firstNumber = queue.Remove();
			ReverseWithStack(queue);
			queue.Insert(firstNumber);

			return queue;
		}
		private static MOE.Queue<int> ReverseWithStack(MOE.Queue<int> queue) {
			if (queue == null) return queue;
			if (queue.IsEmpty()) return queue;

			MOE.Stack<int> stack = new MOE.Stack<int>();
			while (!queue.IsEmpty()) {
				stack.Push(queue.Remove());
			}
			while (!stack.IsEmpty()) {
				queue.Insert(stack.Pop());
			}

			return queue;
		}
		private static List<MOE.Queue<int>> CreateData() {
			List<MOE.Queue<int>> queuesList = new List<MOE.Queue<int>>();

			queuesList.Add(MOE.Queue.Utilities.Create(""));
			queuesList.Add(MOE.Queue.Utilities.Create("1"));
			queuesList.Add(MOE.Queue.Utilities.Create("1,1"));
			queuesList.Add(MOE.Queue.Utilities.Create("1,2"));
			queuesList.Add(MOE.Queue.Utilities.Create("1,2,1"));
			queuesList.Add(MOE.Queue.Utilities.Create("1,2,3"));
			queuesList.Add(MOE.Queue.Utilities.Create("1,2,3,4,5,6,7,8,9,10"));
			queuesList.Add(MOE.Queue.Utilities.Create("1,2,1,4,5,6,1,8,2,10"));

			return queuesList;
		}
	}
}

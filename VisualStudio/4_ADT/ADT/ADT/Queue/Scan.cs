using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ADT.Queue {
	public class Scan {
		public static void TestSolution() {
			List<MOE.Queue<int>> queues = CreateData();
			int number = 1;

			foreach (var queue in queues) {
				Console.WriteLine($"Queue: {queue} Contains the number {number}");
				Console.WriteLine($"{CountWithMarker(queue, number)} times.");
				//Console.WriteLine($"The queue {queue} contains {CountWithMarker(queue, number)} times the number {number}.");
			}
		}
		private static int CountWithMarker(MOE.Queue<int> queue, int number) {
			int count = 0;
			int marker = -1;
			
			// Validate the input
			if (queue == null || queue.IsEmpty() || number == marker) return count;

			queue.Insert(marker);// Insert the marker

			// Until reaching the inserted marker, iterate and perform:
			while (queue.Head() != marker) {

				// Increment the counter each time we encounter the number
				if (queue.Head() == number) count++;

				queue.Insert(queue.Remove());
			}

			// Don't forget to remove the marker
			queue.Remove();

			return count;
		}
		/// <summary>
		/// Scan the amount of times `number` appears in `queue`, notice we assume nothing regarding the value of the queue's items.
		/// </summary>
		/// <param name="queue"></param>
		/// <param name="number"></param>
		/// <returns></returns>
		private static int CountWithQueue(MOE.Queue<int> queue, int number) {
			int count = 0;
			MOE.Queue<int> helpQueue = new MOE.Queue<int>();
			
			// Validate the input
			if (queue == null || queue.IsEmpty()) return count;

			// Until emptying the original queue, iterate and perform
			while (!queue.IsEmpty()) {
				// Increment the counter each time we encounter the number
				if (queue.Head() == number) count++;

				helpQueue.Insert(queue.Remove());
			}
			
			// Empty `helpQueue` back into `queue`
			while (!helpQueue.IsEmpty()) {
				queue.Insert(helpQueue.Remove());
			}

			return count;
		}
		private static List<MOE.Queue<int>> CreateData() {
			List<MOE.Queue<int>> queues = new List<MOE.Queue<int>>();

			queues.Add(MOE.Queue.Utilities.Create(""));
			queues.Add(MOE.Queue.Utilities.Create("1"));
			queues.Add(MOE.Queue.Utilities.Create("1,2"));
			queues.Add(MOE.Queue.Utilities.Create("3,1,4,1,5,9,2,6,5,3"));
			queues.Add(MOE.Queue.Utilities.Create("1,2,3,4,5,6,7,8,9,10"));
			queues.Add(MOE.Queue.Utilities.Create("-1,2,3,4,5,4,3,2,1,1,2"));
			
			return queues;
		}
	}
}

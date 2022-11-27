using Node;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IntroductionQuestionsSolutions {
	public class Question01 {

		private static Node<int> RemoveNodes(Node<int> list, int number) {
			
			// Skip all of the nodes with values equal to `number` or if the list is empty
			Node<int> resultList = list;
			while (resultList != null && resultList.GetValue() == number) {
				resultList = resultList.GetNext();
			}
			if (resultList == null) return null;

			// Remove all nodes with values equal to `number`
			Node<int> currNode = resultList;
			while (currNode.HasNext()) {
				if (currNode.GetNext().GetValue() == number) {
					currNode.SetNext(currNode.GetNext().GetNext());
				} else {
					currNode = currNode.GetNext();
				}
			}

			return resultList;
		}

		public static void TestSolution() {
			List<Node<int>> lists = CreateLists();

			Console.WriteLine("Before removing 2:");
			PrintLists(lists);

			RemoveNumberFromLists(lists, 2);

			Console.WriteLine("\nAfter removing 2:");
			PrintLists(lists);
		}

		private static List<Node<int>> CreateLists() {

			List<Node<int>> lists = new List<Node<int>>();
			
			lists.Add(Node.Utilities.CreateList(""));
			lists.Add(Node.Utilities.CreateList("2"));
			lists.Add(Node.Utilities.CreateList("1"));
			lists.Add(Node.Utilities.CreateList("2,1"));
			lists.Add(Node.Utilities.CreateList("1,2"));
			lists.Add(Node.Utilities.CreateList("1,2,3"));
			lists.Add(Node.Utilities.CreateList("2,2,2,1,2,2,3,2,4,2"));

			return lists;
		}
		private static void PrintLists(List<Node<int>> lists) {
			for (int i = 0; i < lists.Count; i++) {
				Console.WriteLine(String.Format("#{0}: {1}", 
					i, (lists[i] == null ? "-> -|" : lists[i].ToString())));
			}
		}
		private static void RemoveNumberFromLists(List<Node<int>> lists, int number) {
			for (int i = 0; i < lists.Count; i++) {
				lists[i] = RemoveNodes(lists[i], number);
			}
		}
	}
}

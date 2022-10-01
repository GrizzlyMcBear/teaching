using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ADT;

namespace Node {
	internal class Program {
		static void Main(string[] args) {
			Student student1 = new Student(15, "Mike");
			Node<Student> myStudents = new Node<Student>(student1);

			myStudents.SetNext(new Node<Student>(new Student(13, "Liza")));

			Console.WriteLine(myStudents.ToString());
		}
	}
}

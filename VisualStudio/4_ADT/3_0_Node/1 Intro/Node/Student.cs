using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Node {
	internal class Student {
		private int age;
		private string name;

		public Student() {
			age = 0;
			name = "N/A";
		}

		public Student(int age, string name) {
			SetAge(age);
			SetName(name);
		}


		public void SetAge(int age) {
			if (age < 0) {
				Console.WriteLine("Age is invalid, setting 0");
				age = 0;
			}

			this.age = age;
		}
		public int GetAge() {
			return this.age;
		}
		public void SetName(string name) {
			if (name == null || name.Equals("")) {
				Console.WriteLine("Name is invalid, setting 'N/A'");
				name = "N/A";
			}

			this.name = name;
		}
		public string GetName() {
			return this.name;
		}
	
		override public string ToString() {
			return String.Format("Name: {0}, Age: {1}", GetName(), GetAge());
		}
	}
}

using System;
using System.Collections.Generic;
using System.Text;

namespace ClassroomExercise {
	public class Student {

		private int grade;
		private String name;

		public Student() {
			this.grade = 0;
			this.name = "Unknown";
		}

		public Student(String name, int grade) {
			this.name = name;
			SetGrade(grade);
		}

		public void SetGrade(int grade) {
			if (grade >= 0 && grade <= 100) {
				this.grade = grade;
			}
		}

		public int GetGrade() {
			return this.grade;
		}

		public void SetName(String name) {
			this.name = name;
		}

		public String GetName() {
			return this.name;
		}

		public override string ToString() {
			return string.Format("Name: {0}, Grade: {1}.", name, grade);
		}
	}
}

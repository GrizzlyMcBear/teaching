using System;
using System.Collections.Generic;
using System.Text;

namespace ClassroomExercise {
	public class Classroom {

		// This contradicts the purpose of encapsulation, and is only for demonstration purposes!
		public Student[] students;

		// There's a better way of doing this.
		public const int MaxAmountOfStudents = 20;

		public Classroom() {
			this.students = new Student[MaxAmountOfStudents];
		}

		public void SetGrade(int index, int grade) {
			// Update the grade only if the grade's index is valid (the value is checked inside 'Student').
			if (index >= 0 && index < MaxAmountOfStudents) {

				// Update the grade in the desired index
				this.students[index].SetGrade(grade);
			}
		}

		public int GetGrade(int index) {
			int result = -1;

			if (index >= 0 && index < MaxAmountOfStudents) {
				result = students[index].GetGrade();
			}
			
			return result;
		}

		public override string ToString() {
			String result = "This class's students data is:\n";

			for (int index = 0; index < MaxAmountOfStudents; index++) {
				if (students[index] != null)
					result += students[index].ToString() + "\n";
			}

			return result;
		}
	}
}

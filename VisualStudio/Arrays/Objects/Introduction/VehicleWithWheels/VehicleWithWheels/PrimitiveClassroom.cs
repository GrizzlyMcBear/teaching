using System;
using System.Collections.Generic;
using System.Text;

namespace ClassroomExercise {
	public class PrimitiveClassroom {

		private int[] grades;

		// There's a better way of doing this.
		public const int MaxAmountOfStudents = 20;

		public PrimitiveClassroom() {
			this.grades = new int[MaxAmountOfStudents];
		}

		public void SetGrade(int grade, int index) {
			// Update the grade only if the grade's index and value are valid
			if (index >= 0 && index < MaxAmountOfStudents &&
				grade >= 0 && grade <= 100) {

				// Update the grade in the desired index
				this.grades[index] = grade;
			}
		}

		public int GetGrade(int index) {
			int result = -1;

			if (index >= 0 && index < MaxAmountOfStudents)
				result = this.grades[index];

			return result;
		}
	}
}
using System;

namespace ClassroomExercise {
	class Program {
		static void Main(string[] args) {
			//localVariablesGrades();
			//simpleClassroomGrades();
			studentsClassroomGrades();
		}

		/// <summary>
		/// A method showing the use of just local variables
		/// </summary>
		private static void localVariablesGrades() {
			int gradeForIsrael = 80;
			int gradeForIsraela = 99;
			int gradeForRonen = 88;

			Console.WriteLine("Israel's grade is: " + gradeForIsrael);
			Console.WriteLine("Israela's grade is: " + gradeForIsraela);
			Console.WriteLine("Ronen's grade is: " + gradeForRonen);
		}

		/// <summary>
		/// A method showing the usage of an object with a field which contains the data,
		/// this field is an array which stores primitive values.
		/// </summary>
		private static void simpleClassroomGrades() {
			PrimitiveClassroom primitiveClassroom = new PrimitiveClassroom();

			primitiveClassroom.SetGrade(88, 0);
			primitiveClassroom.SetGrade(56, 1);
			primitiveClassroom.SetGrade(92, 1);

			Console.WriteLine("These are the class's grades:");
			for (int index = 0; index < PrimitiveClassroom.MaxAmountOfStudents; index++) {
				Console.WriteLine("Student #" + index + ": " + primitiveClassroom.GetGrade(index));
			}
		}

		/// <summary>
		/// This method shows how we could store the data in a more ordered way -
		/// using an object with a field which is an array of other objects.
		/// </summary>
		private static void studentsClassroomGrades() {
			Classroom classroom = new Classroom();

			classroom.students[0] = new Student("Israel", 99);
			classroom.students[1] = new Student("Israela", 100);

			Console.WriteLine(classroom.ToString());
		}
	}
}
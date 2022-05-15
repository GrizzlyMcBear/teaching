using System;
using System.Collections.Generic;
using System.Text;

namespace PlagueExercise {
	public class TestTube {

		private Virus[] viruses;
		private const int DefaultAmount = 20;

		public TestTube() {
			this.viruses = new Virus[DefaultAmount];
		}

		public TestTube(int virusAmount) {
			if (virusAmount > 0)
				this.viruses = new Virus[virusAmount];
		}

		public bool IsIndexValid(int index) {
			return (index >= 0 && index < this.viruses.Length);
		}

		public Virus GetVirus(int index) {
			Virus result = null;

			if (IsIndexValid(index))
				result = viruses[index];

			return result;
		}

		public void SetVirus(int index, Virus virus) {
			if (IsIndexValid(index) && Virus.IsValid(virus))
				this.viruses[index] = virus;
		}

		public override string ToString() {
			String result = "This test tube's viruses data is:\n";

			for (int index = 0; index < viruses.Length; index++) {
				if (viruses[index] != null)
					result += viruses[index].ToString() + "\n";
			}

			return result;
		}
	}
}

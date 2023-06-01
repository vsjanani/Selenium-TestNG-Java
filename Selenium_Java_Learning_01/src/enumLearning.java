
public class enumLearning {

	enum dum {
		adding;
//		("add");
//
//		private String mystr;
//
//		public String getMystr() {
//			return mystr;
//		}
//
//		dum(String mystr) {
//			this.mystr = mystr;
//		}

	}

	public int hello() {
		return 100;
	}

	public int hi() {
		return 200;
	}

	public int values(String checkit) {

		dum t = dum.valueOf(checkit);
		return switch (t) {
		case adding -> {
			int myint = hello();
			yield myint;
		}
		
		};

	}

	public static void main(String[] args) {
		enumLearning d = new enumLearning();
//		dum enumConst = dum.add;
		System.out.println(d.values("adding"));

	}
}

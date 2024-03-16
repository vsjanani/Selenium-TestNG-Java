
public class MethodsLearn {
	static int a=5;
	public static void main (String[] args) {
		
		int b=10;
		MethodsLearn ob = new MethodsLearn();
		try {
			System.out.println(ob.sum(a, b));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
	public int sum(int 	x, int y) {
		int add = x + y;
		System.out.println(a);
		return add;
	}
}

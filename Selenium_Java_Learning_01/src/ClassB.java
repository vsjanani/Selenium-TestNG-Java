class ClassB extends ClassA{
	
	public int bar(){
		
		System.out.println("hi");
		return 2;
	}
	public static void main (String[] args) {
		ClassB b = new ClassB();
		b.bar();
	}}
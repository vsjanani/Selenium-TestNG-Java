class Person{

   static int age;
   int sum = 0;
   public int hello() {
	   sum = sum + age; 
	   return sum;
   }

}

class Child{

   public static void main(String args[]){

       Person p1 = new Person();

       Person p2 = new Person();

       p1.age = 30;

       p2.age = 31;

       Person.age = 32;

       System.out.println("P1\'s age is: " + p1.age);

       System.out.println("P2\'s age is: " + p2.age);
       int sum  = p1.hello();
       System.out.println(sum);

   }

}
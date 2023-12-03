import java.util.*;
class Array{
	Scanner sc= new Scanner(System.in);
	int size;
	String arr[];
	public void giveInput() {
		try {
		Scanner sc= new Scanner(System.in);
		System.out.print("enter the size of array : ");
		this.size =sc.nextInt();
		this.arr = new String [this.size];
		for(int i=1;i<=size;i++) {
		    System.out.print("enter element "+i+": ");
			this.arr[i-1]=sc.next();
		}
	}catch(InputMismatchException e) {
		System.out.println(e + " please enter valid datatype for array elements.");
	}
	}
	public void accessElement() {
		Scanner sc= new Scanner(System.in);
		try {
		int index;
		System.out.println("enter the index of element to be found : ");
		index=sc.nextInt();
		System.out.println("element at index " + index +" is : "+ arr[index]);
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e + " you are trying to access invalid index. Please enetr valid index. Max value of size is "+ size);
		}
	}

	public void division(){
		int num1, num2;
		Scanner sc= new Scanner(System.in);
		try {
			int index1,index2;
			System.out.println("enter the index of element for number_1 : ");
			index1=sc.nextInt();
			num1=Integer.parseInt(arr[index1]);
			System.out.println("enter the index of element for number_2: ");
			index2=sc.nextInt();
			num2=Integer.parseInt(arr[index2]);
			System.out.println("the first number is : "+ num1);
			System.out.println("the second number is : "+ num2);
                    System.out.println("division of "+ num1+ " and "+ num2 +" is : " + num1/num2);
            }
            catch(ArithmeticException e) {
            System.out.println(e + " cannot divide a number by zero. please enter number_2 accordingly.");
            }
		catch(NumberFormatException e) {
			System.out.println(e + " please enter integer values for numbers.");
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e + " you are trying to access invalid index. Please enetr valid index. Max value of size is "+ size);
		}
		finally {
			System.out.println("finally block executed");
		     }
		}
	}
class Ass_6 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Array obj1 = new Array();
		int choice;
		do {
			System.out.println("MENU");
			System.out.println("press 1. take array input ");
			System.out.println("press 2. access element in array ");
			System.out.println("press 3. divide the numbers ");
			System.out.println("press 4. exit code");
			System.out.println("Enter your choice : ");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					obj1.giveInput();
					break;
				case 2 :
					obj1.accessElement();
					break;
				case 3:
					obj1.division();
					break;
				case 4 :
					System.out.println(" code exited successfully.");
					break;
				default :
					System.out.println("enter valid choice");
					break;
				}
		}while(choice !=4);
	}
 }
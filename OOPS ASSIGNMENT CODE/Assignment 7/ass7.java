import java.util.*;

public class ass7 {
    static int evencount=0;
    static int oddcount=0;
    static int prime=0;
    static int nonprime=0;
    static int strpallincount=0;
    static int strnonpallincount=0;
    static int numpallincount=0;
    static int numnonpallincount=0;
    ArrayList<Integer> num= new ArrayList<Integer>();
	ArrayList<String> str= new ArrayList<String>();
    static void odd_even(int n) {
        if(n%2==0 || n==0) {
            evencount++;
        } else if(n%2!=0) {
            oddcount++;
        }
    }

    static void if_prime(int n) {
        if(n < 2) {
            nonprime++;
        } else {
            boolean isPrime = true;
            for(int i=2; i<=Math.sqrt(n); i++) {
                if(n%i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                prime++;
            } else {
                nonprime++;
            }
        }
    }

    static void if_pallin_num(int n) {
        int original = n;
        int rev = 0;
        int r = 0;
        while(n > 0) {
            r = n % 10;
            rev = (rev * 10) + r;
            n = n / 10;
        }
        if(original == rev) {
            numpallincount++;
        } else {
            numnonpallincount++;
        }
    }

    static void if_pallin_str(String s) {
        StringBuilder s1 = new StringBuilder(s);
        if(s.equals(s1.reverse().toString())) {
            strpallincount++;
        } 
        else {
            strnonpallincount++;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> num= new ArrayList<Integer>();
		ArrayList<String> str= new ArrayList<String>();
        int ch;
        int op, strop;
        int size, element,strsize;
        String st;
        do {
            System.out.println("1 . enter 1 for INTEGER input");
            System.out.println("2. enter 2 for STRING input");
            System.out.println("3. enter 3 to EXIT code");
            System.out.print("enter your choice :  ");
            ch = sc.nextInt();
            switch(ch) {
                case 1:
                    System.out.print("enter the number of integers in list :  ");
                    size = sc.nextInt();
                    for(int i=0; i<size; i++) {
                        System.out.print("enter the element for index "+i+" :  ");
                        element = sc.nextInt();
                        num.add(element);
                    }
                    do {
                        System.out.println("1. enter 1 to check EVEN or ODD ");
                        System.out.println("2. enter 2 to check PRIME or NOT");
                        System.out.println("3. enter 3 to check PALLINDROME or NOT");
                        System.out.println("4. enter 4 to EXIT code");
                        System.out.print("enter your SUB CHOICE :  ");
                        op = sc.nextInt();
                        switch(op) {
                            case 1:
                                for(int i=0; i<size; i++) {
                                    int x = num.get(i);
                                    odd_even(x);
                                }
                                System.out.println("the TOTAL number of EVEN numbers are : "+ evencount);
                                System.out.println("the LIST of EVEN numbers is : ");
                                for(int i=0; i<size; i++) {
                                    int n = num.get(i);
                                    if(n % 2 == 0 || n == 0) {
                                        System.out.println("The INDEX is : "+ i +" and "+"the EVEN element is : "+n+" ");
                                    }
                                }
                                System.out.println();
                                System.out.println("the TOTAL number of ODD numbers are : "+ oddcount);
                                System.out.println("the LIST of ODD numbers is : ");
                                for(int i=0; i<size; i++) {
                                    int n = num.get(i);
                                    if(n % 2 != 0) {
                                        System.out.println("The INDEX is : "+ i +" and "+"the ODD element is : "+n+" ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 2:
                                for(int i=0; i<size; i++) {
                                    int x = num.get(i);
                                    if_prime(x);
                                }
                                System.out.println("the TOTAL number of PRIME numbers are : "+ prime);
                                System.out.println("the LIST of PRIME numbers is : ");
                                for(int i=0; i<size; i++) {
                                    int n = num.get(i);
                                    if(n >= 2) {
                                        boolean isPrime = true;
                                        for(int k=2; k<=Math.sqrt(n); k++) {
                                            if(n % k == 0) {
                                                isPrime = false;
                                                break;
                                            }
                                        }
                                        if(isPrime) {
                                            System.out.println("The INDEX is : "+ i +" and "+"the PRIME element is : "+n+" ");
                                        }
                                    }
                                }
                                System.out.println();
                                System.out.println("the TOTAL number of NON PRIME numbers are : "+ nonprime);
                                System.out.println("the LIST of NON PRIME numbers is : ");
                                for(int i=0; i<size; i++) {
                                    int n = num.get(i);
                                    if(n < 2) {
                                        System.out.println("The INDEX is : "+ i +" and "+"the NON PRIME element is : "+n+" ");
                                    } else {
                                        boolean isPrime = true;
                                        for(int k=2; k<=Math.sqrt(n); k++) {
                                            if(n % k == 0) {
                                                isPrime = false;
                                                break;
                                            }
                                        }
                                        if(!isPrime) {
                                            System.out.println("The INDEX is : "+ i +" and "+"the NON PRIME element is : "+n+" ");
                                        }
                                    }
                                }
                                System.out.println();
                                break;
                            case 3:
                                // Implement palindrome check for numbers
                                for(int i=0; i<size; i++) {
                                    int x = num.get(i);
                                    if_pallin_num(x);
                                }
                                System.out.println("the TOTAL number of PALLINDROME numbers are : "+ numpallincount);
                                System.out.println("the LIST of PALLINDROME numbers is : ");
                                for(int i=0; i<size; i++) {
                                    int n = num.get(i);
                                    int original = n;
                                    int rev = 0;
                                    int r = 0;
                                    while(n > 0) {
                                        r = n % 10;
                                        rev = (rev * 10) + r;
                                        n = n / 10;
                                    }
                                    if(original == rev) {
                                        System.out.println("The INDEX is : "+ i +" and "+"the PALLINDROME element is : "+original+" ");
                                    }
                                }
                                System.out.println();
                                System.out.println("the TOTAL number of NON PALLINDROME numbers are : "+ numnonpallincount);
                                System.out.println("the LIST of NON PALLINDROME numbers is : ");
                                for(int i=0; i<size; i++) {
                                    int n = num.get(i);
                                    int original = n;
                                    int rev = 0;
                                    int r = 0;
                                    while(n > 0) {
                                        r = n % 10;
                                        rev = (rev * 10) + r;
                                        n = n / 10;
                                    }
                                    if(original != rev) {
                                        System.out.println("The INDEX is : "+ i +" and "+"the NON PALLINDROME element is : "+original+" ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 4:
                            	System.out.println ("code executed successfully");
                            	break;
                        	default:
                        		System.out.println("enter valid input");
                        		break;
                        }
                    }while(op!=4);
                    break;
                case 2:
                	 System.out.print("enter the number of STRINGS in list :  ");
                     strsize = sc.nextInt();
                     for(int i=0; i<strsize; i++) {
                         System.out.print("enter the string for index "+i+" :  ");
                         st = sc.next();
                         str.add(st);
                     }
                     do {
                         System.out.println("1. enter 1 to check PALLINDROME or NOT");
                         System.out.println("2. enter 2 to EXIT code");
                         System.out.print("enter your SUB CHOICE :  ");
                         strop = sc.nextInt();
                         switch(strop) {
                         	case 1:
                         		for(int i=0; i<strsize; i++) {
                         			String x = str.get(i);
                         			if_pallin_str(x);
                         		}
                         		System.out.println("the TOTAL number of PALLINDROME numbers are : "+ strpallincount);
                         		System.out.println("the LIST of PALLINDROME numbers is : ");
                         		for(int i=0;i<strsize;i++) {
                         			String s=str.get(i);
                         			StringBuilder s1 = new StringBuilder(s);
                         			if(s.equals(s1.reverse().toString())) {
                         				System.out.println("The INDEX is : "+ i +" and "+"the PALLINDROME string is : "+s+" ");
                         			}
                         		}
                         		System.out.println();
                         		System.out.println("the TOTAL number of NON PALLINDROME numbers are : "+ strnonpallincount);
                         		System.out.println("the LIST of NON PALLINDROME numbers is : ");
                         		for(int i=0;i<strsize;i++) {
                         			String s=str.get(i);
                         			StringBuilder s1 = new StringBuilder(s);
                         			if(!s.equals(s1.reverse().toString())) {
                         				System.out.println("The INDEX is : "+ i +" and "+"the NON PALLINDROME string is : "+s+" ");
                         			}
                         		}
                         		System.out.println();
                         		break;
                          		
                     		case 2:
                     			System.out.println("exit the code ");
                     			break;
                     		default:
                     			System.out.println("enter valid input");
                     			break;
                         }
                     }while(strop!=2);
                case 3:
                	System.out.println("exit complete code");
                	break;
            	default:
            		System.out.println("enter valid input");
                	
            }
            }while(ch!=3);
        }
}
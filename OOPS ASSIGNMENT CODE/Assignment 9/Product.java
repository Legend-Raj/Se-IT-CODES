import java.util.*;
public class Product {
Scanner sc=new Scanner(System.in);
String prName;
int costPrice,sellPrice,avStock;
static int totalSold=0;
void create() {
	System.out.println("enter PRODUCT NAME :");
	prName=sc.next();
	System.out.println("enter COST PRICE :");
	costPrice=sc.nextInt();
	System.out.println("enter SELL PRICE :");
	sellPrice=sc.nextInt();
	System.out.println("enter AVAILABLE STOCK :");
	avStock=sc.nextInt();
}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int ch,op1,op2,size,x;
		Product p=new Product();
		ArrayList<Product> arr=new ArrayList<Product>();
		ArrayList<Integer>pur=new ArrayList<Integer>();
		do {
			System.out.println("1. enter 1 for SELLER :");
			System.out.println("2. enter 2 for COSTUMER :");
			System.out.println("3. enter 3 to exit code :");
			System.out.print("enter your choice : ");
			ch=sc.nextInt();
			switch(ch) {
				case 1:
					do {
						System.out.println("1. enter 1 to ADD PRODUCTS :");
						System.out.println("2. enter 2 to BALANCE STOCK : ");
						System.out.println("3. enter 3 to CHECK PROFIT OR LOSS :");
						System.out.println("4. enter 4 to exit code :");
						System.out.print("enter your choice : ");
						op1=sc.nextInt();
						switch(op1) {
						
						case 1:
						    System.out.println("enter the NUMBER OF PRODUCTS in the list :");
						    size = sc.nextInt();
						    for (int i = 0; i < size; i++) {
						        Product newProduct = new Product();  
						        System.out.println("enter DETAILS OF PRODUCT :" + (i + 1));
						        newProduct.create();
						        arr.add(newProduct);
						        System.out.println("");
						    }
						    break;

				
						case 2:
						    System.out.println("*********BALANCE STOCK SHEET***********");
						    for (int i = 0; i < arr.size(); i++) {
						        Product product = arr.get(i);  // Get the product from the ArrayList
						        System.out.println("product: " + (i + 1) + ", product name: " + product.prName + ", its available stock: " + product.avStock);
						    }
						    System.out.println("");
						    break;

						
						case 3:
						    System.out.println("*******PROFIT/LOSS SHEET FOR PRODUCTS***********");
						    for (int i = 0; i < arr.size(); i++) {
						        Product product = arr.get(i);  // Get the product from the ArrayList
						        int loss = 100 * (product.costPrice - product.sellPrice) / product.costPrice;
						        int profit =  100 * (product.sellPrice - product.costPrice) / product.sellPrice;
						        System.out.println("for product number : " + (i + 1) + " product name :" + product.prName);
						        if (product.costPrice > product.sellPrice) {
						            System.out.println("it is LOSS case :");
						            System.out.println("LOSS PERCENTAGE is : " + loss);
						        } else if (product.costPrice < product.sellPrice) {
						            System.out.println("it is PROFIT case :");
						            System.out.println("PROFIT PERCENTAGE is : " + profit);
						        } else if (product.costPrice == product.sellPrice) {
						            System.out.println("NO profit or loss : ");
						        }
						    }
						    System.out.println("");
						    break;

							case 4:
								System.out.println("exit code!!!");
								break;
							default:
								System.out.println("enter valid choice : ");
								break;
						}
					}while(op1!=4);
				case 2 :
					do {
						System.out.println("**************COSTUMER MENU*************");
						System.out.println("1.enter 1 to see LIST OF PRODUCTS :");
						System.out.println("2.enter 2 to PURCHASE :");
						System.out.println("3.enter 3 to see BILL : ");
						System.out.print("enter your choice : ");
						op2=sc.nextInt();
						switch(op2) {
						case 1:
							System.out.println("******LIST OF PRODUCTS*******");
							for(int i=0;i<arr.size();i++) {
								Product pr=arr.get(i);
								System.out.println("product: "+(i+1)+", product name: "+pr.prName+", product cost: "+pr.sellPrice);
							}
							System.out.println("");
							break;
						case 2:
							System.out.println("enter the NUMBER OF items TO BE PURCHASED");
							x=sc.nextInt();
							for(int i=0;i<x;i++) {
								System.out.println("product: "+(i+1)+" to be purchased is PRODUCT NUMBER " );
								pur.add(sc.nextInt());
							}
							System.out.println("list of purchased items : ");
							for(int i=0;i<x;i++) {
								Product m=arr.get(pur.get(i)-1);
								System.out.println("product: "+(i+1)+", product name: "+m.prName);
							}
							System.out.println("");
							break;
							
						case 3:
							System.out.println("*********BILL*********");
							for(int i=0;i<pur.size();i++) {
								Product m=arr.get(pur.get(i)-1);
								System.out.println("product: "+(i+1)+", product name: "+m.prName+", product cost: "+m.sellPrice);
								totalSold+=m.sellPrice;
							}
							System.out.println("the TOTAL AMOUNT TO BE PAID: "+totalSold);
							System.out.println("");
							break;
						case 4:
							System.out.println("exit code");
						default:
							System.out.println("enter valid choice");

						}
						
					}while(op2!=4);
					

			}
			
		}while(ch!=3);

	}

}
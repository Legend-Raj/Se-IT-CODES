
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle();
        Bike bike = new Bike();
        Car car = new Car();
        int a;
        do{
            System.out.println("1)Bicycle\n2)Bike\n3)Car\n4)Exit");
            int choise;
            System.out.println("Enter your choise: ");
            Scanner sc=new Scanner(System.in);
            choise=sc.nextInt();
            switch(choise){
                case 1:{
                    System.out.println("1)changegear\n2)speedup\n3)applybrakes: ");
                    int ab;
                    ab=sc.nextInt();
                    if(ab==1){
                        int sp;
                        System.out.print("Enter new gear: ");
                        sp=sc.nextInt();
                        bicycle.changeGear(sp);

                    }
                    else if(ab==2){
                        int spe;
                        System.out.print("Enter new speed: ");
                        spe=sc.nextInt();
                        bicycle.speedUp(spe);
                        

                    }
                    else{
                        int br;
                        System.out.println("Amount for breaks: ");
                        br=sc.nextInt();
                        bicycle.applyBrakes(br);
                    }
                    break;
                }
                case 2:{
                    System.out.println("1)changegear\n2)speedup\n3)applybrakes: ");
                    int ab;
                    ab=sc.nextInt();
                    if(ab==1){
                        int sp;
                        System.out.print("Enter new gear: ");
                        sp=sc.nextInt();
                        bike.changeGear(sp);

                    }
                    else if(ab==2){
                        int spe;
                        System.out.print("Enter new speed: ");
                        spe=sc.nextInt();
                        bike.speedUp(spe);
                        

                    }
                    else{
                        int br;
                        System.out.println("Amount for breaks: ");
                        br=sc.nextInt();
                        bike.applyBrakes(br);
                    }
                    break;

                }
                case 3:{
                    System.out.println("1)changegear\n2)speedup\n3)applybrakes: ");
                    int ab;
                    ab=sc.nextInt();
                    if(ab==1){
                        int sp;
                        System.out.print("Enter new gear: ");
                        sp=sc.nextInt();
                        car.changeGear(sp);

                    }
                    else if(ab==2){
                        int spe;
                        System.out.print("Enter new speed: ");
                        spe=sc.nextInt();
                        car.speedUp(spe);
                        

                    }
                    else{
                        int br;
                        System.out.println("Amount for breaks: ");
                        br=sc.nextInt();
                        car.applyBrakes(br);
                    }
                    break;
                }
                default:{
                    System.out.println("Enter valid input");
                }
            }
            System.out.println("do you want to continue?");
            a=sc.nextInt();

        }while(a!=4);



        
    }
}

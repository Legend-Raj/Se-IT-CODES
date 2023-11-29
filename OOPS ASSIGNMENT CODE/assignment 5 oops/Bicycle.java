
public class Bicycle implements Vehicle {
    private int gear=0;
    private int speed=0;

    public void changeGear(int newGear) {
        gear = newGear;
        if(gear>6){
            System.out.println("gear cannot be greter than 6");
        }
        else{
            System.out.println("Bicycle: gear " + newGear);

        }

        
    }

    public void speedUp(int increment) {
        speed += increment;
        if(gear==0){
            System.out.println("First set the gear");

        }
        else if(gear==1 ){
            if(speed>10 && increment>10){
                System.out.println("spped cant reach this much higher");
            }
            else{
                System.out.println("Bicycle: Speeding up by " + increment + " units");
            }
        }
        else if(gear==2){
            if(speed>20 && increment>20){
                System.out.println("spped cant reach this much higher");
            }
            else{
                System.out.println("Bicycle: Speeding up by " + increment + " units");
            }
        }
        else if(gear==3){
            if(speed>30 && increment>30){
                System.out.println("spped cant reach this much higher");
            }
            else{
                System.out.println("Bicycle: Speeding up by " + increment + " units");
            }
        }
        else if(gear==4){
            if(speed>40 && increment>40){
                System.out.println("spped cant reach this much higher");
            }
            else{
                System.out.println("Bicycle: Speeding up by " + increment + " units");
            }
        }
        else if(gear==5){
            if(speed>50 && increment>50){
                System.out.println("spped cant reach this much higher");
            }
            else{
                System.out.println("Bicycle: Speeding up by " + increment + " units");
            }
        }
        else if(gear==6){
            if(speed>60 && increment>60){
                System.out.println("spped cant reach this much higher");
            }
            else{
                System.out.println("Bicycle: Speeding up by " + increment + " units");
            }
        }
        
    }

    public void applyBrakes(int decrement) {
        speed -= decrement;
        if(decrement>speed){
            System.out.println("speed in lesss");
        }
        else{
            System.out.println("Car: speed reduced by " + decrement + " units");

        }
        
    }
}

import java.util.*;
public class TollBooth {
    record Vehicle(String number, String type){}
    public static void main(String arg[])
    {
        Scanner sc=new Scanner(System.in);
        int car=0,bike=0,truck=0,t=0;
        while(true)
        {
            System.out.println("Enter vehicle number or done when you are done:");
            String number=sc.next();
            if(number.equalsIgnoreCase("done"))
            break;
        System.out.println("Enter vehicle type");
        String type=sc.next().toLowerCase();
        Vehicle v=new Vehicle(number,type);
        int toll=switch(v.type())
        {
            case "bike"->20;
            case "car"->50;
            case "truck"->150;
            default->0;
        };
        t+=toll;
        switch(v.type())
        {
            case "bike"->bike++;
            case "car"->car++;
            case "truck"->truck++;
        }
        }
        System.out.println("Total Tolls="+t);
        if(bike>car && bike>truck)
            System.out.println("Most frequent=Bike");
        else if(car>bike && car>truck)
            System.out.println("Most frequent=Car");
        else if(truck>car && truck>bike)
            System.out.println("Most frequent=Truck");
        sc.close();
    }

}

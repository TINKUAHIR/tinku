import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
 class Car {
    public String carid;
    public String brand;
    public String model;
    public int basepriceperday;
    public boolean isavailable;

    public Car(String carid, String brand, String model, int basepriceperday, boolean isavailable) {
        this.carid = carid;
        this.model = model;
        this.brand = brand;
        this.basepriceperday = basepriceperday;
        this.isavailable = true;
    }



    public String getCarid() {
        return carid;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double calculateprice(int renttalday) {
        return basepriceperday * renttalday;
    }

    public boolean isIsavailable() {
        return isavailable;
    }

    public void rent (){
        isavailable = false;
    }
    public void returncar(){
        isavailable = true;
    }

   // public void add(Car car) {
      //  car.add(car);
 //   }

   public boolean isavailable() {

        return true;
    }
}
class Custumber {
    public  String custumberid;
    public  String name;


    public  Custumber (String custumberid , String name){
        this.custumberid = custumberid;
        this.name = name;
    }

    public  String getCustumberid(){
        return custumberid;
    }
    public  String getName (){
        return  name ;
    }

    public void add(Custumber custumber) {
    }
}

class Rental {
    public Car car ;
    public  Custumber Custumber ;
    public int days;

    public  Rental (Car car ,Custumber Custumber , int days){
        this.car = car;
        this.Custumber=Custumber;
        this.days=  days;
    }
    public  Car getCar(){
        return car;
    }
    public  Custumber getCustumber(){
        return  Custumber;
    }
    public int getDays (){
        return  days;
    }
}
class Carrentalsystem {
    public List<Car> car;

    public List<Custumber> Custumbers;
    public List<Rental> Rentals;

    public Carrentalsystem() {
        car = new ArrayList<>();
        Custumbers = new ArrayList<>();
        Rentals = new ArrayList<>();
    }

    public void addcar(Car car1 ) {
        
        car.add(car1);
    }

    public void addCustumber(Custumber Custumber1) {
        Custumbers.add(Custumber1);
    }

    public void rentcar(Car car, Custumber Custumber, int days) {
        if (car.isavailable()) {
            car.rent();
            Rentals.add(new Rental(car, Custumber, days));

        } else {
            System.out.println("car is not available");
        }
    }

    public <Custumbers> void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=======car rental system=======");
            System.out.println("1...Rent a car ");
            System.out.println("2...Return a car");
            System.out.println("3... Exit");
            System.out.println("4... Enter your choise");

            int key = scanner.nextInt();
            scanner.nextLine();

            int Choice = 2;
            if (key == 1) {
                System.out.println("\n == rent a car \n");
                System.out.println("enter your name ");
                String custumbername = scanner.nextLine();


                System.out.println("\n avalible cars ");
                for (Car car : car) {
                    if (car.isavailable()) {
                        System.out.println(car.getCarid() + "---" + car.getBrand() + "---" + car.getModel());
                    }
                }
                System.out.println("\n enter the car id you want to rent ");
                String carId = scanner.nextLine();

                System.out.println("enter the number of day you rent ");
                int rentalday = scanner.nextInt();
                scanner.nextLine();


                Custumber newcustumber = new Custumber("CLUS" + (Custumbers.size() + 1), custumbername);
                addCustumber(newcustumber);

                Car selectdcar = null;
                for (Car car : car) {
                    if (car.getCarid().equals(carId) && car.isavailable()) {
                        selectdcar = car;
                        break;
                    }
                }
                if (selectdcar != null){
                    double totalprice = selectdcar.calculateprice(rentalday);
                    System.out.println("\n ==  Rental informatin == \n");
                    System.out.println("custumber id"+ newcustumber.getCustumberid());
                    System.out.println("custumber name "+ newcustumber.getName());
                    System.out.println("car" + selectdcar.getBrand()+"--"+ selectdcar.getModel());
                    System.out.println("Rental car "+ rentalday);
                    System.out.println(totalprice);


                    System.out.println("\ncar rental (y/n)");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("y")){
                        rentcar(selectdcar,newcustumber, rentalday);
                        System.out.println("\n Rental succesfully");
                    }

                    else {
                        System.out.println("\n rental cenceld ");
                    }
                }
                else {
                    System.out.println("\n invild car selection or car not avalilabe for rent");
                }
            } else if (Choice == 2) {
                break;
            }
            else {
                System.out.println("invaild choise pleses select currect key ");

            }
        }
        System.out.println("\n thanku for using car rental system \n");
    }


}
public class tinkuahir {
    public static void main(String[] args) {
        Carrentalsystem Rentalsystem = new Carrentalsystem();
        Car car1 = new Car("00012", "toyto", "carmry", 60, true);
        Car car2 = new Car("00025", "thar", "mahindra", 60, true);
        Rentalsystem.addcar(car1);
       // Rentalsystem.addcar(car2);
        Rentalsystem.menu();
    }
}
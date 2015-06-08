import java.util.ArrayList;
public class InventoryDemo {
        public static ArrayList<Product> p = new ArrayList<Product>();
                public static void main(String[] args){
                
                        
                        Car c1 = new Car("Jaguar", 1000000.00);
                        Car c2= new Car("Neon", 17000.00);
                        Tool t1 = new Tool("JigSaw", 149.18);
                        Car c3 = new Car("Jaguar", 110000.00);
                        Car c4 = new Car("Neon", 17500.00);
                        Car c5 = new Car("Neon", 17875.32);
                        Truck tr1 = new Truck("RAM", 35700.00);
                        Tool t2 = new Tool("CircularSaw", 200.00);
                        Tool t3 = new Tool("CircularSaw", 150.00);
                        
                        p.add(c1);
                        p.add(c2);
                        p.add(t1);
                        p.add(c3);
                        p.add(c4);
                        p.add(c5);
                        p.add(tr1);
                        p.add(t2);
                        p.add(t3);
                        
                        System.out.println("Name                   Cost");
                        takeInventory("JigSaw");
                        takeInventory("Neon");
                        takeInventory("Jaguar");
                        takeInventory("RAM");
                        takeInventory("CircularSaw");
                        if (t1.compareTo(t2) == 1){
                        	System.out.println("The first saw is more expensive");
                        }
                        	else if (t1.compareTo(t2) == 0){
                            System.out.println("The saws are the same price.");
                        		
                        	}
                        	else{
                        	System.out.println("The second saw is more expensive");
                        	}
                        			
                        	
                        }
                        
                        
                
                public static void takeInventory(String name){
                        int counter = 0;
                        double totalCost = 0.0;
                        for(Product pr : p){
                            if(pr.getName().equalsIgnoreCase(name)){
                                counter++;
                                totalCost += pr.getCost();
                                }
                        }
                        System.out.println(name + ": Quantity = " +counter + ", Total Cost = " + totalCost);
                        
                        
                        
                        
                }

                        

                        
}
                
                
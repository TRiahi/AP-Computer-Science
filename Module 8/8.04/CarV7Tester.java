public class CarV7Tester
{
    public static void main(String[] args)
    {
        String name;
        int startMiles, endMiles;
        double gallonsUsed, pricePerGallon;

        //CarV7 car1 = new CarV7(name, endMiles, startMiles, gallonsUsed, pricePerGallon);
        CarV7 carV7 = new CarV7();
        CarV7.Car car1 = carV7.new Car("10 Chevy Impala", 52678, 52992, 14.6, 3.5);
        CarV7.Car car2 = carV7.new Car("13 Cadillac Escalade", 45678, 45935, 16.2, 3.5);
        CarV7.Car car3 = carV7.new Car("10 Chevy Equinox", 35679, 36092, 13.5, 3.5);
        
        //Stats for cars
        int dist1 = CarV7.calcDistance(car1.startMiles,car1.endMiles), dist2 = CarV7.calcDistance(car2.startMiles,car2.endMiles), dist3 = CarV7.calcDistance(car3.startMiles,car3.endMiles);
        double mpg1 = CarV7.calcMPG(dist1,car1.gallonsUsed), mpg2 = CarV7.calcMPG(dist2,car2.gallonsUsed), mpg3 = CarV7.calcMPG(dist3,car3.gallonsUsed);
        double totalCost1 = CarV7.calcCost(car1.pricePerGallon,car1.gallonsUsed), totalCost2 = CarV7.calcCost(car2.pricePerGallon,car2.gallonsUsed), totalCost3 = CarV7.calcCost(car3.pricePerGallon,car3.gallonsUsed);
        double totalGPM1 = CarV7.calcGPM(dist1,car1.gallonsUsed), totalGPM2 = CarV7.calcGPM(dist2,car2.gallonsUsed), totalGPM3 = CarV7.calcGPM(dist3,car3.gallonsUsed);

        System.out.printf("%20s%20s%20s%20s%20s%20s%20s%20s%20s\n","Type of Car","Start Miles","End Miles","Distance","Gallons","Price","Cost","Miles/Gal","Gal/Mile");
        System.out.print("=========================================================================================================================================================================================\n");
        System.out.printf("%20s%20d%20d%20d%20.1f%20.1f%20.1f%20.1f%20.3f\n",car1.name,car1.startMiles,car1.endMiles,dist1,car1.gallonsUsed,car1.pricePerGallon,totalCost1,mpg1,totalGPM1);
        System.out.printf("%20s%20d%20d%20d%20.1f%20.1f%20.1f%20.1f%20.3f\n",car2.name,car2.startMiles,car2.endMiles,dist2,car2.gallonsUsed,car2.pricePerGallon,totalCost2,mpg2,totalGPM2);
        System.out.printf("%20s%20d%20d%20d%20.1f%20.1f%20.1f%20.1f%20.3f\n",car3.name,car3.startMiles,car3.endMiles,dist3,car3.gallonsUsed,car3.pricePerGallon,totalCost3,mpg3,totalGPM3);
    }
}
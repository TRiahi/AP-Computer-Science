public class Catapult
{
    
    double [] velocity;
    double [] degrees;
    
    Catapult(double [] v, double [] d){
        
       velocity = v;
       degrees = d;
        
    }
    
    public double [] calcDistance(){
        
        double [] total = {0,0,0,0,0,0,0};
        
        for (int i = 0; i < degrees.length; i++){
            
            total[i] = (Math.pow(velocity[i], 2) * Math.sin( 2 * Math.toRadians(degrees[i])) / 9.8);
            
        }
        
        return total;
    
    }
    
}
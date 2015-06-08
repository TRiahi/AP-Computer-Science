
/**
 * Winter Mountain terrain.
 * 
 * @author Bijan Tajmir
 * @version 3/1/2015
 */
public class WinterMountain extends Mountain
{
    private double temperature;
    public WinterMountain(int l, int w, int m, double temp)
    {
        super(l, w, m);
        temperature = temp;
    }
    
    public double getTemp()
    {
        return temperature;
    }
}
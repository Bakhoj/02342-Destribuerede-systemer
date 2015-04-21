package sensor;

	import java.rmi.registry.LocateRegistry;
	import java.rmi.registry.Registry;
	import rmi.RMISensor;
	import static server.Server.RMISENSOR;
	
public class TemperatureSensor {
	public static void main (String args[]){
		try {
            String name = RMISENSOR;
            Registry registry = LocateRegistry.getRegistry(7878);
            RMISensor comp = (RMISensor) registry.lookup(name);
            TemperatureGenerator task = new TemperatureGenerator();
            String temp = comp.executeTask();
            System.out.println(temp);
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
}

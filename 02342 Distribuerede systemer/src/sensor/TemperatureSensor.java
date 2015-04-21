package sensor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.RMISensor;
import static server.Server.RMISENSOR;

public class TemperatureSensor implements Runnable{

	public void run(){
		RMISensor comp = null;
		TemperatureGenerator task = null;
		Thread t;
		try {
			String name = RMISENSOR;
			Registry registry = LocateRegistry.getRegistry(7878);
			comp = (RMISensor) registry.lookup(name);
			task = new TemperatureGenerator();
			//            String temp = comp.executeTask();
			//            System.out.println(temp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		t = new Thread(this, "whatevs");

		while(true){
			try{
				String temp = comp.executeTask();
				System.out.println(temp);
				//				comp.getAvg();
				//				comp.printTemp(task.temperatureGen());
			} catch(Exception e){
				System.err.println(e);
			}
			try {
				t.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//
			//	}
			//	public static void main (String args[]){
			//		RMISensor comp = null;
			//		TemperatureGenerator task = null;
			//		Thread t;
			//		try {
			//			String name = RMISENSOR;
			//			Registry registry = LocateRegistry.getRegistry(7878);
			//			comp = (RMISensor) registry.lookup(name);
			//			task = new TemperatureGenerator();
			//			//            String temp = comp.executeTask();
			//			//            System.out.println(temp);
			//		} catch (Exception e) {
			//			e.printStackTrace();
			//		}
			//		Thread z = new Thread(t, "whatevs");
			//		
			//		while(true){
			//			try{
			//				String temp = comp.executeTask();
			//				System.out.println(temp);
			////				comp.getAvg();
			////				comp.printTemp(task.temperatureGen());
			//			} catch(Exception e){
			//				System.err.println(e);
			//			}
			//			try {
			//				t.sleep(1000);
			//			} catch (InterruptedException e) {
			//				e.printStackTrace();
			//			}
			//		}
		}
	}
}

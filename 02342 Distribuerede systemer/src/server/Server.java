package server;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import rmi.RMISensor;

public class Server implements RMISensor{
	public static final String RMISENSOR = "SensorPart";
	public static final String RMIOTHER = "OtherPart";
	int read = 0;
	double sum = 0;
	double amount = 0;
	double avg = 0;

	public Server(){
		super();
	}
	public static void main(String[] args) throws IOException{
		try{
			String name = RMISENSOR;
//			System.out.println(Naming.lookup(name));
			//#########################
			//Valg af interface
			RMISensor engine = new Server();
			RMISensor stub = (RMISensor) UnicastRemoteObject.exportObject(engine, 0);
			//#################
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind(name, stub);
			System.out.println("Server bound");
		} catch (Exception e) {
			System.out.println("Server exception");
			System.out.println("or maybe not?");
			e.printStackTrace();
		}		
	}
	
//	public void run(){
//		try{
//			String name = RMISENSOR;
//			//#########################
//			//Valg af interface
//			RMISensor engine = new Server();
//			RMISensor stub = (RMISensor) UnicastRemoteObject.exportObject(engine, 0);
//			//#################
//			Registry registry = LocateRegistry.getRegistry();
//			registry.rebind(name, stub);
//			System.out.println("Server bound");
//		} catch (Exception e) {
//			System.out.println("Server exception");
//			e.printStackTrace();
//		}
//	}
	@Override
	public double getAvg() {
		avg = (sum/amount);
		return avg;
	}
	@Override
	public String executeTask() {

		return null;
	}
}

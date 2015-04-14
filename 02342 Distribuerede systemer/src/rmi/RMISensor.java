package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMISensor extends Remote{
	String executeTask() throws RemoteException;
	double getAvg() throws RemoteException;
}

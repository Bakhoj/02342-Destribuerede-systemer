import java.io.IOException;
import sensor.TemperatureSensor;

public class RunTempSensor {
	public static void main(String[] args) throws IOException{
		TemperatureSensor client = new TemperatureSensor();
		client.run();
	}
}

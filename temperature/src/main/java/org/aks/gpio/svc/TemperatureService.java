/**
 * 
 */
package org.aks.gpio.svc;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.pi4j.io.w1.W1Device;
import com.pi4j.io.w1.W1Master;

/**
 * @author Akshay
 *
 */
@Service
public class TemperatureService {
	public String getTemperature() throws IOException{
        W1Master w1Master = new W1Master();
        String tempString = null;
       // System.out.println(w1Master);

        for (W1Device device : w1Master.getDevices()) {
          //  System.out.printf("%-20s %3.1f°C %3.1f°F\n", device.getName(), device.getTemperature(),
                   // device.getTemperature(TemperatureScale.CELSIUS));
            if(device.getName().contains("28-011"))
            	tempString = device.getValue();
        }
		return tempString;
	}
	
}

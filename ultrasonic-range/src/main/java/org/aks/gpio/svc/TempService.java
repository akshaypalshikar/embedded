/**
 * 
 */
package org.aks.gpio.svc;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.pi4j.component.temperature.TemperatureSensor;
import com.pi4j.component.temperature.impl.TmpDS18B20DeviceType;
import com.pi4j.io.w1.W1Device;
import com.pi4j.io.w1.W1Master;

/**
 * @author Akshay
 *
 */
@Service
public class TempService {
	
	 W1Master w1Master = new W1Master();
	 
	public String getTemperature() throws IOException{
        Double tempString = null;
        if(w1Master!=null){
        	System.out.println("w1Master.getDevices() : " + w1Master.getDevices(TmpDS18B20DeviceType.FAMILY_CODE));
       	    for (W1Device device : w1Master.getDevices(TmpDS18B20DeviceType.FAMILY_CODE)) {
	            	tempString = ((TemperatureSensor) device).getTemperature();
	        }
        }
		return tempString.toString();
	}
	
}

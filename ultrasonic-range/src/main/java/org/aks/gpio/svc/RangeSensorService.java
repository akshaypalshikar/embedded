/**
 * 
 */
package org.aks.gpio.svc;

import org.springframework.stereotype.Service;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;

/**
 * @author Akshay
 *
 */
@Service
public class RangeSensorService {
	Boolean isVibrating = false;
	final GpioController gpioController = GpioFactory.getInstance();
	final GpioPinDigitalInput echo = gpioController.provisionDigitalInputPin(RaspiPin.GPIO_02,PinPullResistance.PULL_DOWN);
	final GpioPinDigitalOutput trigger = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_00);
	
	public Double getRange() {
		Double range = 0.0;
		System.out.println("Inside getRange service");
		try {
			Thread.sleep(2000);
			trigger.high(); // Make trigger pin HIGH
			Thread.sleep((long) 0.01);// Delay for 10 microseconds
			trigger.low(); //Make trigger pin LOW
		
			while(echo.isLow()){ //Wait until the ECHO pin gets HIGH
				Thread.sleep((long) 0.00001);
				System.out.println("echo.isLow() : " + echo.isLow());
			}
			long startTime= System.nanoTime(); // Store the surrent time to calculate ECHO pin HIGH time.
			while(echo.isHigh()){ //Wait until the ECHO pin gets LOW
				Thread.sleep((long) 0.00001);
				System.out.println("echo.isHigh() : " + echo.isHigh());
			}
			long endTime= System.nanoTime(); // Store the echo pin HIGH end time to calculate ECHO pin HIGH time.
			System.out.println("Time :"+(endTime-startTime));
			range = ((((endTime-startTime)/1e3)/2) / 29.1);
			System.out.println("range :"+range+" cm"); //Printing out the distance in cm  
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return range;
	}
}

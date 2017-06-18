/**
 * 
 */
package org.aks.gpio.svc;

import org.springframework.stereotype.Service;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

/**
 * @author Akshay
 *
 */
@Service
public class PirSensorService {

	Boolean isMotionDetected=false;
	final GpioController gpioController = GpioFactory.getInstance();          
	final GpioPinDigitalInput pirMotionsensor = gpioController.provisionDigitalInputPin(RaspiPin.GPIO_04, PinPullResistance.PULL_DOWN);
	
	public Boolean isMotionDetected() {
		pirMotionsensor.addListener(new GpioPinListenerDigital() {
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				if (event.getState().isHigh()) {
					System.out.println("Motion Detected!");
					isMotionDetected = true;
				}
				if (event.getState().isLow()) {
					System.out.println("No Motion Detected.");
					isMotionDetected = false;
				}
			}
		});
		return isMotionDetected;
	}
}

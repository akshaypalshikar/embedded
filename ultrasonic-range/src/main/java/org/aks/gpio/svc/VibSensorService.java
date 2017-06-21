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
public class VibSensorService {
	Boolean isVibrating = false;
	final GpioController gpioController = GpioFactory.getInstance();
	final GpioPinDigitalInput pirMotionsensor = gpioController.provisionDigitalInputPin(RaspiPin.GPIO_04,
			PinPullResistance.PULL_DOWN);
	int tmp = 0;

	public Boolean isVibrating() {
		pirMotionsensor.addListener(new GpioPinListenerDigital() {
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				if (event.getState().isHigh()) {
					System.out.println("Vibration Detected!");
					isVibrating = isVibrationDetected(1);
				}
				if (event.getState().isLow()) {
					System.out.println("No Vibration Detected.");
					isVibrating = isVibrationDetected(0);
				}
			}
		});
		return isVibrating;
	}

	public Boolean isVibrationDetected(int state) {
		Boolean isVibrationDetected = false;
		if (state != tmp) {
			isVibrationDetected = true;
			tmp = state;
		}
		return isVibrationDetected;
	}
}

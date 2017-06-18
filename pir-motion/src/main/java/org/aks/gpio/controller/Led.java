/**
 * 
 */
package org.aks.gpio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 * @author Akshay
 *
 */
@RestController
public class Led {

	private static GpioPinDigitalOutput gpioOutputPin;

	@RequestMapping("/light")
	public String light() {
		GpioController gpioController = GpioFactory.getInstance();
		if (gpioOutputPin==null) {
			gpioOutputPin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);
		}
		gpioOutputPin.toggle();
		return null;
	}
}

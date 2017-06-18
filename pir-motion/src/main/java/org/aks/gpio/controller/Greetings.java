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
public class Greetings {

	@RequestMapping("/")
	public String greeting() {
		return "Hello world!";
	}
}

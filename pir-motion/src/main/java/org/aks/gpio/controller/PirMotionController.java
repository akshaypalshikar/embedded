/**
 * 
 */
package org.aks.gpio.controller;

import org.aks.gpio.svc.PirSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Akshay
 *
 */
@RestController
public class PirMotionController {

	@Autowired
	PirSensorService pirSensor;
	
	@RequestMapping("/")
	public String greeting() {
		return "Hello world!";
	}

	@RequestMapping("/isMotionDetected")
	public String light() {
		return pirSensor.isMotionDetected().toString();
	}
}

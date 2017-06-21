/**
 * 
 */
package org.aks.gpio.controller;

import java.io.IOException;

import org.aks.gpio.svc.VibSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Akshay
 *
 */
@RestController
public class VibrationSensor {

	@Autowired
	VibSensorService vibSensorService;

	@RequestMapping("/isVibrating")
	public String isVibrating() throws IOException {
		return vibSensorService.isVibrating().toString();
	}
}

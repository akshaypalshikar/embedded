/**
 * 
 */
package org.aks.gpio.controller;

import java.io.IOException;

import org.aks.gpio.svc.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Akshay
 *
 */
@RestController
public class Temperature {

	@Autowired
	TemperatureService temperatureService;
	
	@RequestMapping("/getTemp")
	public String getTemp() throws IOException {
		return temperatureService.getTemperature().toString();
	}
}

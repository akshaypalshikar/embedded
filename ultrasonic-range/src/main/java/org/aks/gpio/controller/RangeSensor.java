/**
 * 
 */
package org.aks.gpio.controller;

import java.io.IOException;

import org.aks.gpio.svc.RangeSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Akshay
 *
 */
@RestController
public class RangeSensor {

	@Autowired
	RangeSensorService rangeSensorService;

	@RequestMapping("/getRange")
	public String getRange() throws IOException {
		return rangeSensorService.getRange().toString();
	}
}

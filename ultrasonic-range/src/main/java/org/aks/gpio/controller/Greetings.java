/**
 * 
 */
package org.aks.gpio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

package org.aks.gpio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pi4j.wiringpi.GpioUtil;


@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
    	GpioUtil.enableNonPrivilegedAccess();
        SpringApplication.run(Application.class, args);
    }
}
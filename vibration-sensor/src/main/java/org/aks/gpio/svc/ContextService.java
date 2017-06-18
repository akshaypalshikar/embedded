package org.aks.gpio.svc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ContextService implements CommandLineRunner {

@Autowired
ApplicationContext applicationContext;

@Override
public void run(String... args) throws Exception {
    System.out.println("-------------> just checking!");
        System.out.println("getBeanDefinitionNames : "+Arrays.asList(applicationContext.getBeanDefinitionNames()));

}}
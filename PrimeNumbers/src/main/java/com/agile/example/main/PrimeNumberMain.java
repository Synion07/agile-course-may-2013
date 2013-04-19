package com.agile.example.main;

import java.util.Scanner;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.agile.example.PrimeNumberCalculator;

public class PrimeNumberMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Load our actual context into the program
		try(
				FileSystemXmlApplicationContext appContext = new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/spring/root-context.xml");
				Scanner input = new Scanner(System.in);
				){
		
			// Get our class from the Spring IoC container
			PrimeNumberCalculator calculator = appContext.getBean("primeNumberCalculator", PrimeNumberCalculator.class);
			
			System.out.println("Escriba el número que quiere factorizar.");
			System.out.println("Escriba un número negativo para finalizar.");
			
			// Please note a non-integer will throw an exception
			// this could obviously be improved 
			Integer userNumber = input.nextInt();
			
			while (userNumber > 0){
				// Read input from user and decompose
				System.out.println("Descomposición: " + calculator.decompose(userNumber));
				userNumber = input.nextInt();
			}
		}
	}

}

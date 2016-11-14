package core;

import java.util.Scanner;

public class Console extends Thread{

	private Scanner inputReader;

	public void run(){
		inputReader = new Scanner(System.in);
		while (true) {
			System.out.println("Waiting for input...");
			if (inputReader.hasNext()) {
				String input = inputReader.next();
				if (input.equalsIgnoreCase("pause")) {
					System.out.println("pause");
					Core.running = false;
				} else if (input.equalsIgnoreCase("play")) {
					System.out.println("play");
					Core.running = true;
				} else if (input.equalsIgnoreCase("Q")) {
					System.exit(0);
				}
			}
		}
	}
}

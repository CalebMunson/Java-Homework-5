package assignment5;

//Prompt 2: Write a program to create two threads:
//				1st thread prints even numbers
//				2nd thread prints odd numbers

//This file contains 2 different classes which extend thread
//one of them is used for the odd counter, the other for the even counter
//the counters take in a variable allowing to count from 0 to whatever end number

public class Prompt2 {
	public static void main(String[] args) {
		oddCounter oddThread = new oddCounter(50);
		evenCounter evenThread = new evenCounter(50);
		
		oddThread.start();
		evenThread.start();
		
		try {
			oddThread.join();
			evenThread.join();
		} catch(Exception e) {
			System.out.println("Interrupted.");
		}

	}
}

class oddCounter extends Thread {
	int index;
	Thread t;
	
	oddCounter(int index) {
		this.index = index;
	}
	
	public void start() {
		System.out.println("Starting an odd thread");
		if (t == null) {
			t = new Thread(this);
			t.start();
		}
	}
	
	public void run() {
		countOdd();
		System.out.println("Odd thread exiting.");
	}
	
	void countOdd() {
		for(int i = 1; i <= index / 2; i++) {
			System.out.println(i * 2 - 1);
		}
	}
}

class evenCounter extends Thread {
	int index;
	Thread t;
	
	evenCounter(int index) {
		this.index = index;
	}
	
	public void start() {
		System.out.println("Starting an even thread");
		if (t == null) {
			t = new Thread(this);
			t.start();
		}
	}
	
	public void run() {
		countEven();
		System.out.println("Even thread exiting.");
	}
	
	void countEven() {
		for(int i = 1; i <= index /  2; i++) {
			System.out.println(i * 2);
		}
	}
}
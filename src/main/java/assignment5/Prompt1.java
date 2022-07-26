package assignment5;

//Prompt 1: Write a program for printing 1 to 50 from a thread

//This file has a main counter class which extends the thread class
//It counts from 1 to 50 via a for loop which is only called when the thread starts
//The counting occurs in the count method which is then called in run which is called by start

//I initially wrote it wrong and the threads actually did nothing but it works now lol

public class Prompt1 {

	public static void main(String[] args) {
		counter thread = new counter(50);
		thread.start();
	}
}

class counter extends Thread {
	int index;
	Thread t;
	
	counter(int index) {
		this.index = index;
	}
	
	void count() {
		for (int i = 0; i < index; i++) {
			System.out.println(i + 1);
		}
	}
	
	public void start() {
		System.out.println("Starting the thread.");
		if (t == null) {
			t = new Thread(this);
			t.start();
		}
	}
	
	public void run() {
		count();
		System.out.println("Thread exiting.");
	}
}

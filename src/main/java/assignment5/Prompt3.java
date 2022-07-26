package assignment5;

//Prompt 3: Write a program for synchronization example

//This file contains an alphabet class, and a synchronized thread class which utilizes this alphabet
//The alphabet class contains the ability to print out all lower case or upper case letters
//The thread class then allows for an additional variable which accepts 0 or 1 for lower or upper respectively

//One observation was that while the threads are synchronized, they don't necessarily exit in a synchronized way
//There is probably a way to change this, but I am curious if there is a built in method for this or not

public class Prompt3 {
	public static void main(String[] args) {
		alphabet alpha = new alphabet();
		//alpha.printUpper(26);
		//alpha.printLower(26);
		
		synchroThread thread1 = new synchroThread(alpha, "thread 1", 0);
		synchroThread thread2 = new synchroThread(alpha, "thread 2", 1);
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (Exception e) {
			System.out.println("interrupted");
		}
	}
}

class alphabet {
	void printUpper(int index) {
		try {
			for (int i = 0; i < index; i++) {
				char alpha = (char) (i + 65);
				System.out.println(alpha);
			}
		} catch (Exception e) {
			System.out.println("Thread interrupted.");
		}
	}
	
	void printLower(int index) {
		try {
			for (int i = 0; i < index; i++) {
				char alpha = (char) (i + 97);
				System.out.println(alpha);
			}
		} catch (Exception e) {
			System.out.println("Thread interrupted.");
		}
	}
}

class synchroThread extends Thread {
	Thread t;
	alphabet alpha;
	String name;
	int mode;
	
	synchroThread(alphabet alpha, String name, int mode) {
		this.alpha = alpha;
		this.name = name;
		this.mode = mode;
	}
	
	public void run() {
		synchronized(alpha) {
			if (mode == 1) {
				alpha.printUpper(26);	
			} else if (mode == 0) {
				alpha.printLower(26);
			}
			System.out.println("Process complete.");
		}
		System.out.println("Thread " + name + " exiting.");
	}
	
	public void start() {
		System.out.println("Starting a thread");
		if (t == null) {
			t = new Thread(this, name);
			t.start();
		}
	}
}
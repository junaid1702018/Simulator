import java.io.*;
import java.net.*;
import java.util.Random;

//import java.util.Scanner;
public class SGLD {
	public static int waitTime = 3000;
	public static boolean running = false;

	private String id, lgt, alt;

	public void start() {
		running = true;
		String serverHostname = new String("127.0.0.1");
		// running=true;
		DeviceInfo info = new DeviceInfo();
		// info.color="Yellow";
		info.ID = id;
		info.longitude = lgt;
		info.latitude = alt;
		// Threading work defined here
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (running) {
					Socket echoSocket = null;
					try {
						echoSocket = new Socket("127.0.0.1", 10082);

					} catch (UnknownHostException e) {
						System.out.println("Don't know about host: " + serverHostname);
						System.exit(1);
					} catch (IOException e) {
						System.out.println("Couldn't get I/O for " + "the connection to: " + serverHostname);
						System.exit(1);
					}
					try {
						ObjectOutputStream objectOutput = new ObjectOutputStream(echoSocket.getOutputStream());
						Random rand = new Random();
						info.data1 = rand.nextInt(9700) + 300;
						info.data2 = rand.nextInt(9700) + 300;
						objectOutput.writeObject(info);
						objectOutput.close();
						echoSocket.close();

						Thread.sleep(waitTime);
					} catch (InterruptedException e) { // TODO
						// Auto-generated catch block
						e.printStackTrace();

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		// start the thread.
		thread.start();
	}

	public SGLD(String id, String lgt, String alt) {

		this.id = id;
		this.lgt = lgt;
		this.alt = alt;

	}

	public void stopSendingData() {
		running = false;
	}
}
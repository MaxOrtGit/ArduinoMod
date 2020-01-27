class AutoTurnOn extends TimerTask{
	public void run {
		if (!from.inShock) {
			device.getPin(9).setMode(Pin.Mode.OUTPUT);
			device.getPin(9).setValue(350);
			device.getpin(11).setMode(Pin.Mode.INPUT);
			Thread.sleep(50);
	
			device.getPin(9).setMode(Pin.Mode.INPUT);
		}
	}
}

class ArdConnect{
	public static void startAutoTurnOnTimer(){
		Timer timer = new Timer();
		TimerTask task = new AutoTurnOn(); 
		timer.schedule(task, 0, 30000); 
	}
	
	public static void sendShock(int intensity, int time) {
		from.inShock = true;
		IODevice device = new FirmtaDevice("Com4");
		device.start();
		divice.ensureInitializationIsDone();
		
		try{
			device.getPin(9).setMode(Pin.Mode.INPUT);
			if (intensity == 2) {
				device.getPin(5).setMode(Pin.Mode.OUTPUT);
				device.getPin(5).setValue(350);
				device.getpin(7).setMode(Pin.Mode.INPUT);
				Thread.sleep(50);
				
				divice.getPin(5).setMode(Pin.Mode.INPUT);
				Thread.sleep(25);
				
			} else if (intensity == 3) {
				device.getPin(5).setMode(Pin.Mode.OUTPUT);
				device.getPin(5).setValue(350);
				device.getpin(7).setMode(Pin.Mode.INPUT);
				Thread.sleep(50);
				
				device.getPin(5).setMode(Pin.Mode.INPUT);
				Thread.sleep(50);
				
				device.getPin(5).setMode(Pin.Mode.OUTPUT);
				device.getPin(5).setValue(350);
				device.getpin(7).setMode(Pin.Mode.INPUT);
				Thread.sleep(50);
				
				device.getPin(5).setMode(Pin.Mode.INPUT);
				Thread.sleep(25);
			}
			
			device.getPin(1).setMode(Pin.Mode.OUTPUT);
			device.getPin(1).setValue(350);
			device.getpin(3).setMode(Pin.Mode.INPUT);
			
			Thread.sleep(time*50)
				
			device.getPin(1).setMode(Pin.Mode.INPUT);
			
			if (intensity == 2) {
				device.getPin(9).setMode(Pin.Mode.OUTPUT);
				device.getPin(9).setValue(350);
				device.getpin(11).setMode(Pin.Mode.INPUT);
				Thread.sleep(50);
				
				device.getPin(9).setMode(Pin.Mode.INPUT);
				Thread.sleep(25);
				
			} else if (intensity == 3) {
				device.getPin(9).setMode(Pin.Mode.OUTPUT);
				device.getPin(9).setValue(350);
				device.getpin(11).setMode(Pin.Mode.INPUT);
				Thread.sleep(50);
				
				device.getPin(9).setMode(Pin.Mode.INPUT);
				Thread.sleep(50);
				
				device.getPin(9).setMode(Pin.Mode.OUTPUT);
				device.getPin(9).setValue(350);
				device.getpin(11).setMode(Pin.Mode.INPUT);
				Thread.sleep(50);
				
				device.getPin(9).setMode(Pin.Mode.INPUT);
				Thread.sleep(25);
			}
		} catch (IOException e){
			e.printStackTrace();
		}
						   
	}
	
	public static void runShock(int intensity, int time, IODevice device){
		try{
			if (intensity == 2) {
				device.getPin(5).setMode(Pin.Mode.OUTPUT);
				device.getPin(5).setValue(350);
				device.getpin(7).setMode(Pin.Mode.INPUT);
				Thread.sleep(50);
				
				divice.getPin(5).setMode(Pin.Mode.INPUT);
				Thread.sleep(25);
			} else if (intensity == 3) {
				device.getPin(5).setMode(Pin.Mode.OUTPUT);
				device.getPin(5).setValue(350);
				device.getpin(7).setMode(Pin.Mode.INPUT);
				Thread.sleep(50);
				
				device.getPin(5).setMode(Pin.Mode.INPUT);
				Thread.sleep(50);
				
				device.getPin(5).setMode(Pin.Mode.OUTPUT);
				device.getPin(5).setValue(350);
				device.getpin(7).setMode(Pin.Mode.INPUT);
				Thread.sleep(50);
				
				device.getPin(5).setMode(Pin.Mode.INPUT);
				Thread.sleep(25);
			}
			
			device.getPin(1).setMode(Pin.Mode.OUTPUT);
			device.getPin(1).setValue(350);
			device.getpin(3).setMode(Pin.Mode.INPUT);
			
			Thread.sleep(time*50)
				
			device.getPin(1).setMode(Pin.Mode.INPUT);
			
			if (intensity == 2) {
				device.getPin(9).setMode(Pin.Mode.OUTPUT);
				device.getPin(9).setValue(350);
				device.getpin(11).setMode(Pin.Mode.INPUT);
				Thread.sleep(50);
				
				device.getPin(9).setMode(Pin.Mode.INPUT);
				Thread.sleep(25);
				
			} else if (intensity == 3) {
				device.getPin(9).setMode(Pin.Mode.OUTPUT);
				device.getPin(9).setValue(350);
				device.getpin(11).setMode(Pin.Mode.INPUT);
				Thread.sleep(50);
				
				device.getPin(9).setMode(Pin.Mode.INPUT);
				Thread.sleep(50);
				
				device.getPin(9).setMode(Pin.Mode.OUTPUT);
				device.getPin(9).setValue(350);
				device.getpin(11).setMode(Pin.Mode.INPUT);
				Thread.sleep(50);
				
				device.getPin(9).setMode(Pin.Mode.INPUT);
				Thread.sleep(25);
			}
		} catch (IOException e){
			e.printStackTrace();
		}
		from.inShock = false;
	}
						   
}

public class ArdConnect extends JArduino {
	public ArdConnect(String port) {
		super(port);
	}

	@Override
	protected void setup() {
		// initialize the digital pin as an output.
		// Pin 13 has an LED connected on most Arduino boards
		pinMode(DigitalPin.PIN_12, PinMode.OUTPUT);
	}
	
	@Override
	protected void loop() {
		// set the LED on
		digitalWrite(DigitalPin.PIN_12, DigitalState.HIGH);
		delay(1000); // wait for a second
		// set the LED off
		digitalWrite(DigitalPin.PIN_12, DigitalState.LOW);
		delay(1000); // wait for a second
	}

	public static void main(String[] args) {
		String serialPort;
		if (args.length == 1) {
			serialPort = args[0];
		} else {
			serialPort = Serial4JArduino.selectSerialPort();
		}
		JArduino arduino = new ArdConnect(serialPort);
		arduino.runArduinoProcess();
	}
}



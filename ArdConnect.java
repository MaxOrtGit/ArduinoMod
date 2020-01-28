class AutoTurnOn extends TimerTask{
	public void run {
		if (!from.inShock) {
			from.inWakeUp = true;
			digitalWrite(DigitalPin.PIN_5, DigitalState.HIGH);
			delay(50);
			
			digitalWrite(DigitalPin.PIN_5, DigitalState.LOW);
			delay(25);
			from.inWakeUp = false;
			
		}
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
		pinMode(DigitalPin.PIN_1, PinMode.OUTPUT);
		pinMode(DigitalPin.PIN_3, PinMode.OUTPUT);
		pinMode(DigitalPin.PIN_5, PinMode.OUTPUT);
	}
	
	
	public static void startAutoTurnOnTimer(){
		Timer timer = new Timer();
		TimerTask task = new AutoTurnOn(); 
		timer.schedule(task, 0, 30000); 
	}
	
	public static void sendShock(int intensity, int time){
		String serialPort;
		if (args.length == 1) {
			serialPort = args[0];
		} else {
			serialPort = Serial4JArduino.selectSerialPort();
		}
		JArduino arduino = new ArdConnect(serialPort);
		arduino.runArduinoProcess();
		
		if(!from.inShock){
		if (from.inWakeUp){
			delay(75);
		}
		from.inShock = true;
		if (intensity == 2){
			digitalWrite(DigitalPin.PIN_3, DigitalState.HIGH);
			delay(50);
			digitalWrite(DigitalPin.PIN_3, DigitalState.LOW);
			delay(25);
		} else if (intensity ==3) {
			digitalWrite(DigitalPin.PIN_3, DigitalState.HIGH);
			delay(50);
			digitalWrite(DigitalPin.PIN_3, DigitalState.LOW);
			delay(50);
			
			digitalWrite(DigitalPin.PIN_3, DigitalState.HIGH);
			delay(50);
			digitalWrite(DigitalPin.PIN_3, DigitalState.LOW);
			delay(25);
		}
		
		digitalWrite(DigitalPin.PIN_1, DigitalState.HIGH);
		delay(time*50); 
		
		digitalWrite(DigitalPin.PIN_1, DigitalState.LOW);
		delay(50);
		
		if (intensity == 2){
			digitalWrite(DigitalPin.PIN_5, DigitalState.HIGH);
			delay(50);
			digitalWrite(DigitalPin.PIN_5, DigitalState.LOW);
			delay(25);
		} else if (intensity ==3) {
			digitalWrite(DigitalPin.PIN_5, DigitalState.HIGH);
			delay(50);
			digitalWrite(DigitalPin.PIN_5, DigitalState.LOW);
			delay(50);
			
			digitalWrite(DigitalPin.PIN_5, DigitalState.HIGH);
			delay(50);
			digitalWrite(DigitalPin.PIN_5, DigitalState.LOW);
			delay(25);
		}
		from.inShock = false;
		}
	}
	
	
}



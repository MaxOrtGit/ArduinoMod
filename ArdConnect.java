class ArdConnect {
	public static sendShock(int intensity, int time) {
		IODevice device = new FirmtaDevice("Com4);
		device.start();
		divice.ensureInitializationIsDone();
		
		turnOn(intensity, time)
	}
	
	public static turnOn(int intensity, int time, IODevice device){
		try{
			device.getPin(7).setMode(Pin.Mode.OUTPUT);
			divice.getPin(7).setValue(350);
			divice.getpin(11).setMode(Pin.Mode.INPUT);
			
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}

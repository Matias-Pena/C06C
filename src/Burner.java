
public class Burner {
	public enum Temperature{HOT, WARM, COLD, BLAZING};
	private Temperature myTemperature;
	private Setting mySetting;
	private int timer;
	public final int TIME_DURATION = 2;
	
	public Burner(){
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
		
	}
	public Temperature getTemperature() {
		return myTemperature;
	}
	
	
	public void plusButton() {
		
		timer = TIME_DURATION;
		
		switch(mySetting) {
		
			case OFF:
				mySetting = Setting.LOW;
				break;
			
			case LOW:
				mySetting = Setting.MEDIUM;
				break;
			
			case MEDIUM:
				mySetting = Setting.HIGH;
				break;
				
			case HIGH:
				break;
				
			default:
				break;
		}
		
	}
	
	public void minusButton() {
		
		timer = TIME_DURATION; 
		
		switch(mySetting) {
		
			case OFF:
				break;
			
			case LOW:
				mySetting = Setting.OFF;
				break;
			
			case MEDIUM:
				mySetting = Setting.LOW;
				break;
				
			case HIGH:
				mySetting = Setting.MEDIUM;
				break;
				
			default:
				break;
		}
		
	}
	
	public void updateTemperature() {

		if(timer > 0) {
			timer--;
		}
		if(timer > 0) {
			return;
		}
		switch(myTemperature) {
		
			case BLAZING:
				if(mySetting != Setting.HIGH)
					myTemperature = Temperature.HOT;
				break;
			case COLD:
				if(mySetting == Setting.HIGH || mySetting == Setting.LOW || mySetting == Setting.MEDIUM)
					myTemperature = Temperature.WARM;
				break;
			case HOT:
				if(mySetting == Setting.HIGH)
					myTemperature = Temperature.BLAZING;
				else if(mySetting == Setting.MEDIUM)
					myTemperature = Temperature.HOT;
				else {
					myTemperature = Temperature.WARM;
				}
				break;
			case WARM:
				if(mySetting == Setting.HIGH ||mySetting == Setting.MEDIUM)
					myTemperature = Temperature.HOT;
				else if(mySetting == Setting.OFF)
					myTemperature = Temperature.COLD;
				break;
			default:
				break;
			
		}
	}
	
	public void display() {
		
		String displayString = "";
		
		switch(mySetting) {
		
		case OFF:
			displayString = "[---]";
			break;
		
		case LOW:
			displayString = "[--+]";
			break;
		
		case MEDIUM:
			displayString = "[-++]";
			break;
			
		case HIGH:
			displayString = "[+++]";
			break;
			
		default:
			break;
	}
		
		String displayMessage = "";
		
		switch(myTemperature) {
		
			case BLAZING:
				displayMessage = "VERY HOT DONT TOUCH";
				break;
			case COLD:
				displayMessage = "cool";
				break;
			case HOT:
				displayMessage = "Careful";
				break;
			case WARM:
				displayMessage = "warm";
			default:
				break;
		
		}
		
		
		
		System.out.println(displayString + "....." + displayMessage);
	}
}

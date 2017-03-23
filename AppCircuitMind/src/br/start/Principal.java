package br.start;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Iniciando sensor de cor...");
		br.tools.ColorSensor Cs = new br.tools.ColorSensor();
		Cs.start();
		
		Motor.B.rotate(35);
		br.tools.Router rt = new br.tools.Router();
		rt.first();
		
		if(Cs.getColor()==3){
			LCD.drawString("Cor amarela encontrada", 1, 1);
			Button.LEDPattern(3);
			rt.second();
			
		}
		
		if(Cs.getColor()==0){
			LCD.drawString("Cor vermelha encontrada", 1, 1);
			Button.LEDPattern(2);
			rt.third();
			
		}
	
		rt.turnRight();
		
		lejos.hardware.sensor.EV3TouchSensor toq;
		toq = new lejos.hardware.sensor.EV3TouchSensor(lejos.hardware.port.SensorPort.S1);
		br.tools.SimpleTouch touch=new br.tools.SimpleTouch(toq);
		if(Cs.getColor()==2){		
			while (!touch.isPressed()) {
				System.out.println("DESTINO OK!!");
				System.out.println("Aperte o sensor de toque....\n");				
				lejos.utility.Delay.msDelay(1000);
			}
		}else{
			while (!touch.isPressed()) {
				System.out.println("NAO ENCONTREI");
				System.out.println(" O DESTINO!");
				System.out.println("Aperte o sensor de toque....\n");				
				lejos.utility.Delay.msDelay(1000);
			}
		}
		
		Cs.TurnOff();

		
	}

}

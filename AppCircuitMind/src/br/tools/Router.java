package br.tools;

public class Router {
	
	public void first(){
		new br.tools.Truck().forward(340, 80);		
	}
	
	public void second(){
		new br.tools.Truck().forward(240, 80);	
	}
	
	public void third(){
		new br.tools.Truck().forward(1000, 150);	
	}
	
	public void turnRight(){	
		new br.tools.Truck().turnRight(670, 50);
	}
}

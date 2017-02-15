package com.sviatlana.shapeCalculation.model;

import com.sviatlana.shapeCalculation.circle.CircumferenceCalc;
import com.sviatlana.shapeCalculation.circle.CircleAreaCalc;

public class Circle {

	private double radius;
	
	public Circle(double r){
		radius = r;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double r) {
		this.radius = r;
	}
	
	public double circumference(double radius) {
		return CircumferenceCalc.circumference(radius);
	}
	
	public double circleArea(double radius) {
		return CircleAreaCalc.circleArea(radius);
	}
	
}

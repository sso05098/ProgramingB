package fourweek;

public class Circle {
	final double PI = 3.14;
	double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return PI*radius*radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
}

class Ball extends Circle {
	public Ball(double radius) {
		super(radius);
	}
	
	@Override
	public double getArea() {
		return 4*PI*radius*radius;
	}
}

class Cylinder extends Circle{
	double height;
	public Cylinder(double radius, double height) {
		super(radius);
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public double getArea() {
		return 2*PI*radius*radius + 2*PI*radius*height;
	}
}
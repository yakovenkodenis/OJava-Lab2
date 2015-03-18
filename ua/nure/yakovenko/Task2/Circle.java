package ua.nure.yakovenko.Task2;

/**
 * Class that represents a circle
 * @author Yakovenko Denis
 *
 */
public class Circle {
	
	private double x, y, r;

	/**
	 * Constructor of the circle.
	 * @param x xOffSet
	 * @param y yOffSet
	 * @param r Radius
	 */
	public Circle(double x0, double y0, double r0) {
		x = x0;
		y = y0;
		r = r0;
	}

	/**
	 * Moves the circle on the plane
	 * @param dx axis x movement
	 * @param dy axis y movement
	 */
	public void move(double dx, double dy) {
		x += dx;
		y += dy;
	}

	public void print() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Circle [x = " + x + ", y = " + y + ", r = " + r + "]";
	}

	/**
	 * Checks if the dot is inside the circle.
	 * @param x x coordinate
	 * @param y y coordinate
	 * @return boolean value that represents presence 
	 * of the dot inside the circle.
	 */
	public boolean isInside(double x, double y) {
		return (Math.sqrt(Math.pow(this.x - x, 2)	+ Math.pow(this.y - y, 2))) < r;

	}

	/**
	 * Checks if the circle is inside another circle
	 * @param c the circle that is checked to be inside
	 * @return boolean value that represents presence
	 * if the circle in the circle.
	 */
	public boolean isInside(Circle c) {
		return (Math.sqrt(Math.pow(this.x - c.x, 2 + Math.pow(this.y - c.y, 2)))) + c.r < r;
	}

	/**
	 * Main method that represents the capabilities of the class.
	 */
	public static void main(String[] args) {
		System.out.println("===Circle===");
		Circle circle = new Circle(1, 1, 2);
		circle.print();

		System.out.println("Move circle: ");
		circle.move(5, 5);
		circle.print();
		
		System.out.println("(0,0) is inside in circle " 
				+ circle + " --> " + circle.isInside(0, 0));
		System.out.println("(5,5) is inside in circle " 
				+ circle + " --> " + circle.isInside(5, 5));
		System.out.println("===END Circle===");
		

	}
}
package svg.parser;



import java.awt.geom.Point2D;
import com.badlogic.gdx.math.Vector2;



public class Vertex extends Vector2 implements Comparable<Vertex> {
	public final String TAG = this.getClass().getSimpleName();
	
	public float x;
	public float y;


	
	
	
	public Vertex(float x, float y) {
		this.x = x;
		this.y = y;
	}
	public Vertex(Vector2 v) {
		this.x = v.x;
		this.y = v.y;
	}
	public Vertex(double x, double y) {
		this.x = (float) x;
		this.y = (float) y;
	}
	

	@Override
	public int compareTo(Vertex v) {
		
		if(v.x>x )
			return -1;
		else if(v.x<x)
			return 1;
		
		if(v.x==x) {
			if(v.y >y)
				return -1;
			if(v.y <y)
				return 1;
		}
		return 0;
	}
	
	public Vector2 toVector2() {
		return new Vector2(x,y);
	}
	
	public Vector2 distance(Vertex v) {
		float distanceX = Math.abs(x-v.x);
		float distanceY = Math.abs(y-v.y);
		return new Vector2(distanceX, distanceY);
	}
	
	public String toString() {
		return "x:"+x+", y:"+y;
	}
	
	public Vertex add(Vertex v) {
		//x += v.x;
		//y += v.y;
		return add(v.x, v.y);
	}
	public Vertex add(float x, float y) {
		//this.x += x;
		//this.y += y; 
		return new Vertex(this.x+x, this.y+y);
	}
	public Vertex sub(Vertex v) {
		return sub(v.x, v.y);
	}
	public Vertex sub(float x, float y) {
		//this.x -= x;
		//this.y -= y; 
		return new Vertex(this.x-x, this.y-y);
	}
	
	public Vertex clone () {
		return new Vertex(x,y);
	}
	

	
	public Vertex transform(AffineTransformation at) {
		Coordinate c = new Coordinate(x, y);
		//LogMessage.log(TAG, "transform", "before:"+c.toString());
		at.transform(c, c);
		//LogMessage.log(TAG, "transform", "after:"+c.toString());
		return new Vertex(c.x, c.y);

	}
	
	public boolean equals(Vertex v) {
		if(x == v.x && y == v.y)
			return true;
		return false;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setLocation(double x, double y) {	
		this.x = (float) x;
		this.y = (float) y;
	}

}

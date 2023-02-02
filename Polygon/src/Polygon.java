import java.text.DecimalFormat;

/**
 * @file Ractangle.java
 * @date 2/2/2023
 * @author Ashton Guvenir
 *
 * @description Creates a polygon object with desired number of sides, length of sides, and shape of polygon.
 * Calculates the perimeter and area of the polygon and prints all the information about said polygon.
 */
public class Polygon {

    //instance variables

    private int numSides;
    private double sideLength;
    private String shapeType;
    private double perimeter;
    private double area;

    //default constructor

    public Polygon(){
        numSides = 3;
        sideLength = 1.0;
        shapeType = "triangle";
        perimeter = calculatePerimeter();
        area = calculateArea();
    }

    //overloaded constructor (with parameters)

    /**
     * Creates a polygon with the specified number of sides, side length, and shape.
     * @param s number of sides on the polygon
     * @param l length of sides on the polygon
     * @param t type of shape  of the polygon
     */
    public Polygon(int s, double l, String t){
        numSides = s;
        sideLength = l;
        shapeType = t;
        perimeter = calculatePerimeter();
        area = calculateArea();
    }

    //accessors

    /**
     * @return the number of sides of the polygon
     */
    public int getNumSides(){
        return numSides;
    }

    /**
     * @return the length of sides of the polygon
     */
    public double getSideLength(){
        return sideLength;
    }

    /**
     * @return the shape of the polygon
     */
    public String getShapeType(){
        return shapeType;
    }

    //mutators

    /**
     *Allows the user to change the number of sides on the polygon.
     * @param newNumSides desired number of sides
     */
    public void setNumSides(int newNumSides){
        numSides = newNumSides;
    }

    /**
     * Allows the user to change the length of the sides on the polygon.
     * @param newSideLength desired side length
     */
    public void setSideLength(double newSideLength){
        sideLength = newSideLength;
    }

    /**
     * Allows the user to change the shape of the polygon.
     * @param newShapeType desired shape
     */
    public void setShapeType(String newShapeType){
        shapeType = newShapeType;
    }

    //calculator methods

    /**
     * @return the perimeter of the polygon
     */
    public double calculatePerimeter(){
        return numSides * sideLength;
    }

    /**
     * @return the area of the polygon
     */
    public double calculateArea(){
        double angle = 360.0 / (2.0 * numSides);
        double radian = Math.toRadians(angle);
        double line = (sideLength / 2) / (Math.tan(radian));
        return ((sideLength / 2) * line * numSides);
    }

    //valid check methods

    /**
     * Checks if the number of sides is valid or not
     */
    public boolean sidesValid(){
        if(numSides > 2){
            return true;
        } else{
            return false;
        }
    }

    /**
     * Checks if the length of the sides are valid or not
     */
    public boolean lengthsValid(){
        if(sideLength > 0){
            return true;
        } else{
            return false;
        }
    }

    //toString method

    /**
     * Prints the type of shape, number of sides, side lengths, perimeter, and area to 3 decimal places
     * if the polygon passes the valid checks, otherwise prints invalid polygon
     */
    public String toString(){
        if(sidesValid() && lengthsValid()) {
            DecimalFormat df = new DecimalFormat("#.###");
            return "Your shape is a " + shapeType + " and it has " + numSides + " sides.\n" +
                    "It has a side length of " + df.format(sideLength) + ".\n" +
                    "It has a perimeter of " + df.format(perimeter) + " units.\n" +
                    "It has a area of " + df.format(area) + ".";
        } else{
            return "Not a valid polygon";
        }
    }
}
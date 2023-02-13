import java.text.DecimalFormat;

/**
 * @file Polygon.java
 * @date 2/8/2023
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

    /**
     * @description Creates a polygon with default values of 3 sides, 1 length, and triangle shape.
     */
    public Polygon(){
        numSides = 3;
        sideLength = 1.0;
        shapeType = "triangle";
        perimeter = calculatePerimeter();
        area = calculateArea();
    }

    //overloaded constructor (with parameters)

    /**
     * @description Creates a polygon with the specified number of sides, side length, and shape.
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
     * @description Allows the user to change the number of sides on the polygon.
     * @param newNumSides desired number of sides
     */
    public void setNumSides(int newNumSides){
        numSides = newNumSides;
        perimeter = calculatePerimeter();
        area = calculateArea();
    }

    /**
     * @description Allows the user to change the length of the sides on the polygon.
     * @param newSideLength desired side length
     */
    public void setSideLength(double newSideLength){
        sideLength = newSideLength;
        perimeter = calculatePerimeter();
        area = calculateArea();
    }

    /**
     * @description Allows the user to change the shape of the polygon.
     * @param newShapeName desired shape
     */
    public void setShapeName(String newShapeName){
        shapeType = newShapeName;
    }

    //calculator methods

    /**
     * @description calculates the perimeter of the polygon and rounds it to 3 decimal places
     * @return the perimeter of the polygon
     */
    public double calculatePerimeter(){
        perimeter = Math.round(numSides * sideLength * 1000) / 1000.0;
        return perimeter;
    }

    /**
     * @description calculates the area of the polygon and rounds it to 3 decimal places
     * @return the area of the polygon
     */
    public double calculateArea(){
        area = Math.round(sideLength * numSides * sideLength / Math.tan(Math.toRadians(180.0 / numSides)) * 250) / 1000.0;
        return area;
    }

    //valid check methods

    /**
     * @description Checks if the number of sides is valid or not
     * If numSides is not greater than 2, then reassigns the polygon to default values of
     * 3 sides, triangle shape, 1 length, and recalculates the perimeter and area
     * @return true if there's more than 2 sides, false if less
     */
    public boolean sidesValid(){
        if(numSides > 2){
            return true;
        } else{
            numSides = 3;
            shapeType = "triangle";
            sideLength = 1.0;
            perimeter = calculatePerimeter();
            area = calculateArea();
            return false;
        }
    }
    
    /**
     * @description Checks if the length of the sides are valid or not
     * If sideLength is not greater than 0, then reassigns the polygon to default values of
     * 3 sides, triangle shape, 1 length, and recalculates the perimeter and area
     * @return true if side length is more than 0, false if not
     */
    public boolean lengthsValid(){
        if(sideLength > 0){
            return true;
        } else{
            numSides = 3;
            shapeType = "triangle";
            sideLength = 1.0;
            perimeter = calculatePerimeter();
            area = calculateArea();
            return false;
        }
    }

    //toString method

    /**
     * @description Prints the type of shape, number of sides, side lengths, perimeter, and area to 3 decimal places
     * if the polygon passes the valid checks, otherwise prints invalid polygon
     */
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.###");
        if(sidesValid() && lengthsValid()) {
            return "Your shape is a " + shapeType + " and it has " + numSides + " sides.\n" +
                    "It has a side length of " + df.format(sideLength) + ".\n" +
                    "It has a perimeter of " + perimeter + " units.\n" +
                    "It has a area of " + area + ".";
        } else{
            return "Not a valid polygon. Your polygon was given a default of " + numSides + " sides, " +
                    "was named \"" + shapeType + "\", and each side has a length of " + sideLength + " units" +
                    "\nand recalculated the perimeter to " + perimeter + " and area to " + area;
        }
    }
}

public class PolygonTester {
    public static void main(String[] args){
        System.out.println("Example of output for default.\n");
        Polygon testDefault = new Polygon();
        System.out.println(testDefault);

        System.out.println("\n-----\n");

        System.out.println("Example of output with 5 sides, 12.43 side length, and pentagon name.\n");
        Polygon testAll = new Polygon(5, 12.43, "pentagon");
        System.out.println(testAll);

        System.out.println("\n-----\n");

        System.out.println("Example of output being invalid.\n");
        Polygon testInvalid = new Polygon(-7, 15, "triangle");
        System.out.println(testInvalid);
    }
}

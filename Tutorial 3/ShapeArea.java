abstract class Shape {
    abstract void area(int x, int y);
}
class Triangle extends Shape{
    void area(int x, int y){
        System.out.println("area is: " + (0.5 * x * y));
    }
}
class Rectangle extends Shape{
    void area(int x, int y){
        System.out.println("area is: " + (x * y));
    }
}
class Circle extends Shape{
    void area(int x, int y){
        System.out.println("area is: " + (3.14 * x * x));
    }    
}
class ShapeArea{
    public static void main(String args[]){
        if(args.length!=3)
        {
           System.out.println("ERROR::: TOO FEW ARGUMENTS");
           System.out.println("i.e. java Shape <Choice> <Value 1> <Value 2>");
           System.out.println("<Choice> - \n1.Triangle \n2.Rectangle \n3.Circle");
           System.out.println("<Value 1>, <Value 2> - Enter Value for corresponding choice");
           System.exit(0);
        }
        Triangle T = new Triangle();
        Rectangle R = new Rectangle();
        Circle C = new Circle();
        int choice = Integer.parseInt(args[0]);
        int a = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        switch(choice){
            case 1: T.area(a, b);
                    break;
            case 2: R.area(a, b);
                    break;
            case 3: C.area(a, b);
                    break;
            default:System.out.println("Invlaid choice!");
        }
    }
}

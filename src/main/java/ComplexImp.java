public class ComplexImp implements Complex {

    private final double real;

    private final double image;

    private ComplexImp(double real, double image){
        this.real = real;
        this.image = image;
    }

    public static Complex createComplex(double real, double image) {
        return new ComplexImp(real,image);
    }

    @Override
    public Complex sum(Complex other) {
        return null;
    }

    @Override
    public Complex sub(Complex other) {
        return null;
    }

    @Override
    public Complex mul(Complex other) {
        return null;
    }

    @Override
    public double getReal() {
        return 0;
    }

    @Override
    public double getImage() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%.2f+%.2fi", real, image);
    }

    public static void main(String[] args) {
        Complex complex = createComplex(0.2345, 0.6543);
        System.out.println(complex);
    }
}

import java.util.Objects;

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
    public Complex sum(Complex other) {     // (x1 + iy1) + (x2 + iy2) = (x1 + x2) + (y1 + y2)i
        double newReal = real + other.getReal();
        double newImage = image + other.getImage();
        return new ComplexImp(newReal, newImage);
    }

    @Override
    public Complex sub(Complex other) {     // (x1 + iy1) - (x2 + iy2) = (x1 - x2) + (y1 - y2)i
        double newReal = real - other.getReal();
        double newImage = image - other.getImage();
        return new ComplexImp(newReal, newImage);
    }

    @Override
    public Complex mul(Complex other) {     //(x1 + iy1)*(x2 + iy2) = x1x2 - y1y2 + (x1y2 + x2y1)i
        double newReal = real * other.getReal() -  image * other.getImage();
        double newImage = real * other.getImage() + other.getReal() * image;
        return new ComplexImp(newReal, newImage);
    }

    @Override
    public double getReal() {
        return real;
    }

    @Override
    public double getImage() {
        return image;
    }

    @Override
    public int hashCode() {
        String realString = String.format("%.2f", real);
        String imageString = String.format("%.2f", image);
        return Objects.hash(realString, imageString);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        ComplexImp other = (ComplexImp) obj;
        String realString = String.format("%.2f", real);
        String imageString = String.format("%.2f", image);
        String realOther = String.format("%.2f", other.getReal());
        String imageOther = String.format("%.2f", other.getImage());
        return realString.equals(realOther) && imageString.equals(imageOther);
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

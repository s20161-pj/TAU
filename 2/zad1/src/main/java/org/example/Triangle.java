package org.example;

public class Triangle {
    public double a;
    public double b;
    public double c;
    private double perimeter;
    private double h;

    public void setPerimeter() {
        if (this.a > 0 && this.b > 0 && this.c > 0) {
            this.perimeter = (1 / 2) * (this.a + this.b + this.c);
        }
        else{
            throw new IllegalArgumentException();
        }
    }
    public double getPerimeter() {
        return this.perimeter;
    }

    public void seth() {
        if(this.c > 0 && this.a > 0) {
            this.h = Math.sqrt(c * c - ((1 / 2) * a * (1 / 2) * a));
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public double geth() {
        return this.h;
    }

    public double getArea() {
        return this.area();
    }
    double area() {
        this.seth();
        if (this.isEquilateral()) {
            return (this.a * this.a * Math.sqrt(3)) / 4;
        }
        if (this.isScalene()) {
            return Math.sqrt(
                    this.perimeter * (this.perimeter - this.a) * (this.perimeter - this.b) * (this.perimeter - this.c));
        }
        if (this.isIsosceles()) {
            return (1 / 2) * this.c * this.h;
        }

        return -1;
    }

    private boolean isEquilateral() {
        return this.a == this.b && this.b == this.c && this.a == this.c;
    }

    private boolean isIsosceles() {
        return this.a == this.b && this.a != this.c && this.b != this.c;
    }

    private boolean isScalene() {
        return this.a != this.b && this.b != this.c && this.a != this.c;
    }
}

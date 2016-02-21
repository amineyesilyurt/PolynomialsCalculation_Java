package com.yesilyurt.amine.polynomial;


import static java.lang.Math.abs;
import java.util.Arrays;

/**
 * HW09_131044004
 *
 * Definition: This is a class that represents a polynomial equations Polynomial
 * represents a polynomial from algebra: e.g. 4x^3 + 3x^2 - 5x + 2 Class will
 * keep the coefficients of the polynomial which are double
 *
 * @author Amine Yesilyurt
 */
public class Polynomial {

    private double[] coefficient; // the coefficients of the polynomial.
    private int degree; //degree of the polynomial

    /**
     * No-parameter constructor returns a polynomial of degree 0, with value 0
     *
     */
    public Polynomial() {

        double[] coef = {0.0};
        setCoefficientArray(coef);
        setDegree(0);

    }

    /**
     * Construct polynomial from double array of coefficients
     * The coefficients are listed in order from highest to lowest degree
     * The degree is the size of the array - 1.
     * Example: 7.1x^3 + 2.8x^2 + 3.4 would be represented as {7.1,2.8,3.4}
     * 
     * @param coefficient double array of coefficients from largest degree 
     *                    down to smallest degree
     */
    public Polynomial(double[] coefficient) {

        setCoefficientArray(coefficient);
        this.degree = coefficient.length - 1;

    }

    
    /**
     *  Returns the i-th coefficient of the polynomial
     * @param index  i-th coefficient 
     * @return the i-th coefficient of the polynomial
     */
    public double getCoefficient(int index) {
        return coefficient[index];
    }

    /**
     * Returns an array containing the coefficients of the polynomial
     * @return the array of coefficients
     */
    public double[] getCoefficientArray() {

        return coefficient;
    }

    
    /**
     * Returns the degree of this polynomial
     * @return the degree of polynomial
     */
    public int getDegree() {

        return degree; 
    }

    
    /**
     * Sets the array of coefficients of this polynomial to coefficient.
     * @param coefficient the array of coefficients 
     */
    public void setCoefficientArray(double[] coefficient) {

        this.coefficient = new double[coefficient.length];
        System.arraycopy(coefficient, 0, this.coefficient, 0, coefficient.length);
    }

    /**
     * Sets the coefficient to i-th index of the array
     * @param index i-th index of the array
     * @param coefficient the double value which will 
     *                    set i-th index of coefficient array
     */
    public void setCoefficient(int index, double coefficient) {
        this.coefficient[index] = coefficient;
    }

    /**
     * Sets degree to this polynomial
     * @param degree the degree which will set
     */
    public void setDegree(int degree) {
        this.degree = degree;
    }

    
    /**
     * Returns the value of the function evaluated at x
     * @param x value at which the function is evaluated
     * @return function evaluated at x
     */
    public double evaluate(double x) {

        double result = 0.0;
        int deg = getDegree();

        if (deg == 0) {
            return getCoefficient(0) ;
        }

        for (int i = 0; i < getCoefficientArray().length; i++) {
            result += getCoefficient(i) * Math.pow(x, deg);
            --deg;
        }

        return result;
    }

     /**
     * Return string representation of Polynomial 
     * @return string representation of Polynomial
     */
    @Override
    public String toString() {

        String equation = "";
        int deg = getDegree();

        for (int i = 0; i <= degree; i++) {
            if (coefficient[i] != 0.0 || deg == 0) {

                equation += String.format("%.2f", coefficient[i]);

                if (deg != 0)//if end of the equation, "+" won't add
                {
                    equation += "x^" + deg + " + ";
                }

            }
            --deg;
        }
        return equation;

    }

    /**
     * Determine whether two polynomials are equal (same degree, same coefficients) 
     * @param other arbitrary Polynomial to test for equality
     * @return true if objects are equal, otherwise false
     */
    public boolean equals(Polynomial other) {

        return Arrays.equals(getCoefficientArray(), other.getCoefficientArray());

    }

    /**
     * Add two polynomials
     * @param other polynomial to add to this polynomial
     * @return new Polynomial representing this polynomial plus other
     */
    public Polynomial plus(Polynomial other) {

        if (getDegree() < other.getDegree()) {

            double[] sumCoef = new double[other.getDegree() + 1];
            for (int i = 0; i <= other.getDegree(); i++) {
                sumCoef[i] = other.getCoefficient(i);
            }
            for (int i = other.getDegree(), j = getDegree(); j >= 0; --i, j--) {
                sumCoef[i] += this.getCoefficient(j);
            }
            Polynomial sumOfPolynoms = new Polynomial(sumCoef);
            return sumOfPolynoms;

        } else {

            double[] sumCoef = new double[getDegree() + 1];
            for (int i = 0; i <= getDegree(); i++) {
                sumCoef[i] = this.getCoefficient(i);
            }
            for (int i = getDegree(), j = other.getDegree(); j >= 0; --i, j--) {
                sumCoef[i] += other.getCoefficient(j);
            }
            Polynomial sumOfPolynoms = new Polynomial(sumCoef);
            return sumOfPolynoms;
        }

    }

    /**
     * Subtract two polynomials
     * If the polynomial are equals,returns default constructor ,Polynomial()
     * @param other polynomial to subtract from this polynomial
     * @return new Polynomial representing this polynomial minus other
     */
    public Polynomial minus(Polynomial other) {

        if (this.equals(other)) {
            Polynomial diffirentOfPolynoms = new Polynomial();
            return diffirentOfPolynoms;
        }
        if (getDegree() < other.getDegree()) {

            double[] sumCoef = new double[other.getDegree() + 1];
            for (int i = 0; i <= other.getDegree(); i++) {
                sumCoef[i] = -other.getCoefficient(i);
            }
            for (int i = other.getDegree(), j = getDegree(); j >= 0; --i, j--) {
                sumCoef[i] += this.getCoefficient(j);
            }
            Polynomial sumOfPolynoms = new Polynomial(sumCoef);
            return sumOfPolynoms;

        } else {

            double[] sumCoef = new double[getDegree() + 1];
            for (int i = 0; i <= getDegree(); i++) {
                sumCoef[i] = this.getCoefficient(i);
            }
            for (int i = getDegree(), j = other.getDegree(); j >= 0; --i, j--) {
                sumCoef[i] -= other.getCoefficient(j);
            }
            Polynomial sumOfPolynoms = new Polynomial(sumCoef);
            return sumOfPolynoms;
        }

    }

    /**
     * Multiply two polynomials
     * @param other polynomial to multiply this polynomial by
     * @return new Polynomial representing this polynomial times other
     */
    public Polynomial times(Polynomial other) {

        double[] coef = new double[getDegree() + other.getDegree() + 1];
        for (int i = 0; i < coef.length; i++) {
            coef[i] = 0.0;
        }

        for (int i = 0; i <= getDegree(); i++) {
            for (int j = 0; j <= other.getDegree(); j++) {
                coef[i + j] += (this.getCoefficient(i) * other.getCoefficient(j));
            }
        }
        Polynomial multiplication = new Polynomial(coef);
        return multiplication;

    }

}

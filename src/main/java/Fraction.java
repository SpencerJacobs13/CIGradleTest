public class Fraction implements Comparable{
    int denominator;
    int numerator;


    public Fraction() {
        this.denominator = 1;
        this.numerator = 0;
    }

    public Fraction(int denominator, int numerator) {
        if(denominator != 0 && denominator < Integer.MAX_VALUE && denominator > Integer.MIN_VALUE) {
            this.denominator = denominator;
        }else {
            if(denominator > Integer.MAX_VALUE)
                System.out.println("Error. Denominator is invalid (too big)");
            else if(denominator < Integer.MIN_VALUE)
                System.out.println("Error. Denominator is invalid (too small)");
            else
                System.out.println("Error. Denominator cannot be 0.");

            this.denominator = 1;
        }

        if(numerator > Integer.MAX_VALUE) {
            System.out.println("Error. Numerator is too large.");
            this.numerator = 1;
        }else if(numerator < Integer.MIN_VALUE) {
            System.out.println("Error. Numerator is too small.");
            this.numerator = 1;
        }
        this.numerator = numerator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public double getRealValue(){
        double denom = (double) denominator;
        double numer = (double) numerator;

        return numer / denom;
    }

    public Fraction reduce(Fraction fraction){
        int gcd = gcd(fraction.numerator, fraction.denominator);
        int numer = fraction.numerator %= gcd;
        int denom = fraction.denominator %= gcd;

        return new Fraction(numer, denom);
    }

    public int gcd(int num1, int num2){
        int remainder = 0;
        while(num2 != 0){
            remainder = num1 % num2;
            num1 = num2;
            num2 = remainder;
        }
        return num1;
    }

    public Fraction add(Fraction fraction){
        int newDenom = this.denominator * fraction.denominator;
        int lhsNewNumer = this.numerator * fraction.denominator;
        int rhsNewNumer = fraction.numerator * this.denominator;
        int addedNumer = lhsNewNumer + rhsNewNumer;

        return reduce(new Fraction(addedNumer, newDenom));
    }

    public boolean equals(Fraction fraction){
        Fraction left = reduce(this);
        Fraction right = reduce(fraction);

        return left == right;
    }

    @Override
    public int compareTo(Object o) {
        Fraction right = reduce((Fraction) o);
        Fraction left = reduce(this);

        return left.numerator/left.denominator - right.numerator/right.denominator;
    }
}

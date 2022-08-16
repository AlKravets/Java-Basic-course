 
public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object object){
        if (this == object){
            return true;
        }

        if (object instanceof ComplexNumber){
            ComplexNumber other = (ComplexNumber) object;
            return re == other.getRe() & im == other.getIm();
        }
        return false;
    }

    @Override
    public int hashCode(){
        return (int) (im+re);
    }
}


// Variant from comments
// @Override
// public int hashCode() {
//     return Objects.hash(getRe(), getIm());
// }

//  @Override
// public boolean equals(Object o) {
//     if (this == o) return true;
//     if (!(o instanceof ComplexNumber)) return false;
//     ComplexNumber that = (ComplexNumber) o;
//     return getRe() == that.getRe() &&
//             getIm() == that.getIm() &&
//             hashCode() == that.hashCode();
// }
// }


// Or
// @Override
// public int hashCode() {
//     final int prime = 31;
//     int result = 1;
//     result = prime * result + (int) Double.doubleToLongBits(re);
//     result = prime * result + (int) Double.doubleToLongBits(im);
//     return result;
// }

// @Override
// public boolean equals(Object obj) {
//     if (this == obj) return true;
//     if (obj == null) return false;
//     if (getClass() != obj.getClass()) return false;
//     ComplexNumber tempObj = (ComplexNumber) obj;
//     return Double.compare(re, tempObj.re) == 0 && Double.compare(im, tempObj.im) == 0;
// }
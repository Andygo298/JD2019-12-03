package by.it.tarasevich.jd01_08;


import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String str) {
        String string = str.replace("{", "").replace("}", "");
        String[] s1 = string.split(",");
        value = new double[s1.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(s1[i]);
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];
            }
            return new Vector(res);
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).value[i];
            }
            return new Vector(res);
        } else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        if (other instanceof Vector) {
            double res = 0;
            for (int i = 0; i < this.value.length; i++) {
                res += this.value[i] * ((Vector) other).value[i];
            }
            return new Scalar(res);
        } else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] res = new double[this.value.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = this.value[i] / ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        String delimeter = "";
        for (double element : value) {
            sb.append(delimeter).append(element);
            delimeter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}


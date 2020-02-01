package by.it.lozouski.calc;

class Matrix extends Var {

    public double[][] getValue() {
        return value;
    }

    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = new double[matrix.value.length][];
        System.arraycopy(matrix.value, 0, this.value, 0, matrix.value.length);
    }

    Matrix(String strMatrix) {
        String temp1 = strMatrix.replaceAll("[\\s]|[{}]{2,}", "");
        String[] temp2 = temp1.replaceAll("[},{]{2,}", "}").replaceAll(",", " ").split("}");
        String[][] tempMatrix = new String[temp2.length][];
        for (int i = 0; i < temp2.length; i++) {
            tempMatrix[i] = temp2[i].split(" ");
        }

        this.value = new double[temp2.length][];
        for (int i = 0; i < value.length; i++) {
            value[i] = new double[tempMatrix[i].length];
            for (int j = 0; j < tempMatrix[i].length; j++) {
                value[i][j] = Double.parseDouble(tempMatrix[i][j]);
            }
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        return other.add(this);
    }

    @Override
    Var add(Scalar otherScalar) {
        double[][] sum = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[0].length; j++) {
                sum[i][j] = this.value[i][j] + otherScalar.getValue();
            }
        }
        return new Matrix(sum);
    }

    @Override
    Var add(Matrix otherMatrix) {
        double[][] sum = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[0].length; j++) {
                sum[i][j] = this.value[i][j] + otherMatrix.value[i][j];
            }
        }
        return new Matrix(sum);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        return other.sub(this);
    }

    @Override
    Var sub(Matrix otherMatrix) throws CalcException {
        try {
            return otherMatrix.add(this.mul(new Scalar(-1)));
        }catch (Exception e){
            throw new CalcException("Operation Matrix-Matrix impossible");
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        return other.mul(this);
    }

    @Override
    Var mul(Scalar otherScalar) {
        double[][] mul = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value.length; j++) {
                mul[i][j] = value[i][j] * otherScalar.getValue();
            }
        }
        return new Matrix(mul);
    }

    @Override
    Var mul(Matrix otherMatrix) throws CalcException{
        try{
        double[][] result = new double[otherMatrix.value.length][this.value[0].length];
        for (int i = 0; i < otherMatrix.value.length; i++) {
            for (int j = 0; j < this.value[0].length; j++) {
                for (int k = 0; k < otherMatrix.value[0].length; k++) {
                    result[i][j] = result[i][j] + otherMatrix.value[i][k] * this.value[k][j];
                }
            }
        }
        return new Matrix(result);
        }catch (Exception e){
            throw new CalcException("NO");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb1 = new StringBuilder();
        String joiner = "";
        sb1.append("{");
        for (int i = 0; i < value.length; i++) {
            sb1.append("{");
            for (int j = 0; j < value[i].length; j++) {
                if (j != value[i].length - 1) {
                    sb1.append(joiner).append(value[i][j]).append(", ");
                } else sb1.append(value[i][j]).append("}");
            }
            if (i != value.length - 1) {
                sb1.append(", ");
            } else sb1.append(joiner);
        }
        sb1.append("}");
        return sb1.toString();
    }
}

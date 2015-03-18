package ua.nure.yakovenko.Task2;

/**
 * Class that represents the Matrix 
 * and several actions with it.
 * @author Yakovenko Denis
 *
 */
public class Matrix {
    private double[][] ar;
    private int col, row;

    public Matrix() {
        col = 0;
        row = 0;
        ar = new double[row][col];
    }

    public Matrix(int c, int r) {
        col = c;
        row = r;
        ar = new double[row][col];
    }

    /**
     * Creates new matrix from two-dimension array
     * @param m
     */
    public Matrix(double[][] m) {
        if(m == null) {
            throw new IllegalArgumentException("Cannot obtain null value");
        }
        row = m.length;
        col = m[0].length;
        ar = new double[row][col];
        for(int i = 0; i < m.length; ++i) {
            System.arraycopy(m[i], 0, ar[i], 0, m[i].length);
        }
    }

    /**
     * Multiplies the matrix by a number
     * @param n a number to multiply the matrix by.
     */
    public void mul(double n) {
        for(int i = 0; i < ar.length; ++i) {
            for(int j = 0; j < ar[i].length; ++j) {
                ar[i][j] *= n;
            }
        }
    }

    /**
     * Multiplies the matrix by another matrix.
     * A compulsory condition: [m,n]*[n,q]
     * @param m the matrix to be multiplied by.
     */
    public void mul(Matrix m) {
        if(col != m.row) {
            throw new ArithmeticException("You can multiply only matrix like this: [m,n]*[n,q]");
        }
        double[][] res = new double[row][m.col];
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < m.col; ++j) {
                for(int k = 0; k < m.row; ++k) {
                    res[i][j] += ar[i][k] * m.ar[k][j];
                }
            }
        }
        ar = res;
        row = ar.length;
        col = ar[0].length;
    }

    /**
     * Transposes the matrix
     */
    public void transpose() {
        double[][] res = new double[col][row];
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < col; ++j) {
                res[j][i] = ar[i][j];
            }
        }
        ar = res;
    }

    /**
     * Matrix addition
     * @param m the matrix to be added to this.
     */
    public void add(Matrix m) {
        if(col == m.col && row == m.row) {
            for(int i = 0; i < ar.length; ++i) {
                for(int j = 0; j < ar[i].length; ++j) {
                    ar[i][j] += m.ar[i][j];
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (double[] anAr : ar) {
            for (double anAnAr : anAr) {
                res.append(anAnAr).append(" ");
            }
            res.append("\n");
        }
        return res.toString();
    }

    public void print() {
        System.out.println(this);
    }

    /**
     * Shows the capabilities of the class
     */
    public static void main(String[] args) {
        double[][] a = new double[][]
                {
                        {1,2,3,4,5},
                        {6,7,8,9,0},
                        {1,2,3,4,5}
                };

        double[][] b = new double[][]
                {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9},
                        {7,6,5},
                        {4,5,6}
                };

        Matrix m = new Matrix(a);
        System.out.println("===Matrix===");
        System.out.println(m.toString());
        System.out.println("Matrix + Matrix:");
        m.add(m);
        m.print();
        System.out.println("Matrix * 4:");
        m.mul(4);
        m.print();
        System.out.println("Matrix * Matrix :");
        Matrix n = new Matrix(b);
        n.print();
        System.out.println("Result: ");
        m.mul(n);
        m.print();
        System.out.println("Transpose Matrix: ");
        m.transpose();
        m.print();
        System.out.println("===END Matrix===");
    }
}

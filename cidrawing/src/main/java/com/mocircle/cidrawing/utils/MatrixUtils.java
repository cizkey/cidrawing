package com.mocircle.cidrawing.utils;

import android.graphics.Matrix;

/**
 * Matrix utility class.
 */
public final class MatrixUtils {

    private MatrixUtils() {
    }

    /**
     * Gets invert matrix.
     *
     * @param matrix original matrix
     * @return invert matrix
     */
    public static Matrix getInvertMatrix(Matrix matrix) {
        Matrix invertMatrix = new Matrix();
        matrix.invert(invertMatrix);
        return invertMatrix;
    }

    /**
     * Calculates the delta matrix according to M(delta) * M(source) = M(target).
     *
     * @param source source matrix
     * @param target target matrix
     * @return delta matrix
     */
    public static Matrix getDeltaMatrix(Matrix source, Matrix target) {
        Matrix delta = new Matrix();
        source.invert(delta);
        delta.postConcat(target);
        return delta;
    }
}

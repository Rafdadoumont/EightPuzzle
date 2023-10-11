package model.algorithms;

import java.lang.reflect.Constructor;

/**
 * A factory class for creating algorithm instances based on the specified algorithm type.
 */
public class AlgorithmFactory {

    /**
     * Creates an instance of an algorithm based on the specified algorithm type.
     *
     * @param algorithm The type of algorithm to create.
     * @return An instance of the specified algorithm or null if an error occurs.
     */
    public AlgorithmStrategy createAlgorithm(AlgorithmEnum algorithm) {
        AlgorithmStrategy out = null;

        try {
            Class<?> algorithmStrategyClass = Class.forName(algorithm.getClassName()) ;
            Constructor<?> algorithmStrategyConstructor = algorithmStrategyClass.getConstructor();
            out = (AlgorithmStrategy) algorithmStrategyConstructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }
}

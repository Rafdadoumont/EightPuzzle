package model.algorithms;

public enum AlgorithmEnum {
    A_STAR("model.algorithms.AStarAlgorithmStrategy");

    private final String className;

    AlgorithmEnum(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}

package main.utilityClasses.AbstractClasses.Interfaces;

// temporary interface, should be switched for Annotation + Aspect
public interface Measurable {
    default void StartMeasure(String message) {
        // not implemented
    }

    default void StopMeasure(String message) {
        // not implemented
    }
}

package model;

public interface Validatable<T> {

    void validate();

    default boolean isNull(T value) {
        return value == null;
    }

    static void require(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }
}

package cse360assignment02;

import java.util.LinkedList;
import java.util.List;

/**
 * Tracks arithmetic operations performed on a single held value.
 */
public class AddingMachine {

    /**
     * An enumeration of all possible operations that can be performed on an {@link AddingMachine}.
     */
    private enum OperationType {
        /** Addition (+). */
        ADDITION('+'),
        /** Subtraction (-). */
        SUBTRACTION('-');

        private char symbol;

        OperationType(char symbol) {
            this.symbol = symbol;
        }
    }

    /**
     * Databag class for an operation performed on an {@link AddingMachine}.
     */
    private class Operation {

        /** The kind of operation performed. */
        public final OperationType type;
        /** The value associated with the operation. */
        public final int value;

        public Operation(
                OperationType type,
                int value
        ) {
            this.type = type;
            this.value = value;
        }

    }

    private int total;
    private List<Operation> history = new LinkedList<>();

    /**
     * Creates a new AddingMachine with a default value of 0 and an empty history.
     */
    public AddingMachine() {
        this.clear();
    }

    /**
     * Returns the current value held by this AddingMachine.
     */
    public int getTotal() {
        return total;
    }

    /**
     * Performs addition on the value held by this AddingMachine.
     *
     * @param value the value to add
     */
    public void add(int value) {
        this.history.add(new Operation(OperationType.ADDITION, value));
        this.total += value;
    }

    /**
     * Performs subtraction on the value held by this AddingMachine.
     *
     * @param value the value to subtract
     */
    public void subtract(int value) {
        this.history.add(new Operation(OperationType.SUBTRACTION, value));
        this.total -= value;
    }

    /**
     * Returns a string representation of the operations performed on this AddingMachine.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("0");
        for (Operation op : this.history)
            sb.append(' ')
                    .append(op.type.symbol)
                    .append(' ')
                    .append(op.value);

        return sb.toString();
    }

    /**
     * Clears the history of this AddingMachine and resets its value to 0.
     */
    public void clear() {
        this.total = 0;
        this.history.clear();
    }

}

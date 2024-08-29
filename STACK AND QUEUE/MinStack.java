import java.util.Stack;

// Class to implement Minimum Stack
class MinStack {
    private Stack<Integer> st;
    private int mini;

    // Empty Constructor
    public MinStack() {
        st = new Stack<>();
    }

    // Method to push a value in stack
    public void push(int value) {
        // If stack is empty
        if (st.isEmpty()) {
            // Update the minimum value
            mini = value;

            // Push current value as minimum
            st.push(value);
            return;
        }

        // If the value is greater than the minimum
        if (value > mini) {
            st.push(value);
        } else {
            // Add the modified value to stack
            st.push(2 * value - mini);
            // Update the minimum
            mini = value;
        }
    }

    // Method to pop a value from stack
    public void pop() {
        // Base case
        if (st.isEmpty()) return;

        // Get the top
        int x = st.pop();

        // If the modified value was added to stack
        if (x < mini) {
            // Update the minimum
            mini = 2 * mini - x;
        }
    }

    // Method to get the top of stack
    public int top() {
        // Base case
        if (st.isEmpty()) return -1;

        // Get the top
        int x = st.peek();

        // Return top if minimum is less than the top
        if (mini < x) return x;

        // Otherwise return mini
        return mini;
    }

    // Method to get the minimum in stack
    public int getMin() {
        // Return the minimum
        return mini;
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();

        // Function calls
        s.push(-2);
        s.push(0);
        s.push(-3);
        System.out.print(s.getMin() + " ");
        s.pop();
        System.out.print(s.top() + " ");
        s.pop();
        System.out.print(s.getMin());
    }

}


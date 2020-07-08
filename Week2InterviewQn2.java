import java.util.EmptyStackException;

/**
 * Stack with max. Create a data structure that efficiently supports the stack
 * operations (push and pop) and also a return-the-maximum operation. Assume the
 * elements are real numbers so that you can compare them.
 */
public class Week2InterviewQn2 {

    private Stack<Integer> s;
    private int max;

    public Week2InterviewQn2() {
        s = new Stack<>();
        max = 0;
    }

    public void push(int x) {
        if (s.isEmpty()) {
            s.push(x);
            max = x;
        } else if (x <= max) {
            s.push(x);
        } else {
            s.push(x * 2 - max);
            max = x;
        }
    }

    public int pop() {
        if (s.isEmpty())
            throw new EmptyStackException();
        int temp = max;
        max = max * 2 - s.pop();
        return temp;
    }

    public int max() {
        return max;
    }

}
import java.util.EmptyStackException;

import edu.princeton.cs.algs4.Stack;

/**
 * Queue with two stacks. Implement a queue with two stacks so that each
 * queue operations takes a constant amortized number of stack operations.
 */
public class Week2InterviewQn1 {

    private Stack<Integer> stack1, stack2;

    public Week2InterviewQn1(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int x) {
        stack1.push(x);
    }

    public int dequeue() {
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                throw new EmptyStackException();
            }
            else if(stack1.size() == 1){
                return stack1.pop();
            }
            else{
                moveElements(stack1, stack2);
                return stack2.pop();
            }
        }
        else{
            return stack2.pop();
        }
    }

    private void moveElements(Stack<Integer> source, Stack<Integer> dest) {
        while (!source.isEmpty()) {
            dest.push(source.pop());
        }
    }

    public static void main(String[] args) {
        Week2InterviewQn1 q = new Week2InterviewQn1();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.dequeue();
        q.enqueue(4);
        q.enqueue(5);
    }
    
}
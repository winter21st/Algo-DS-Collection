public class DijkstraTwoStack {

    private Stack<Integer> valueStack;
    private Stack<Character> operatorStack;

    public DijkstraTwoStack() {
        valueStack = new Stack<>();
        operatorStack = new Stack<>();
    }

    public int calculate(String input) {
        for (Character c : input.toCharArray()) {
            if (Character.isDigit(c))
                valueStack.push(Integer.parseInt(c.toString()));
            else if (c == '+' || c == '-' || c == '*' || c == '/')
                operatorStack.push(c);
            else if (c == ')') {
                valueStack.push(result());
            }
        }
        return valueStack.pop();
    }

    private int result() {
        if (valueStack != null) {
            int rval = valueStack.pop();
            int lval = valueStack.pop();
            switch (operatorStack.pop()) {
                case '+':
                    return lval + rval;
                case '-':
                    return lval - rval;
                case '*':
                    return lval * rval;
                case '/':
                    return rval != 0 ? lval / rval : 0;
                default:
                    return 0;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        DijkstraTwoStack dj = new DijkstraTwoStack();
        int s=dj.calculate("(((1+2)*3)*4)");
        System.out.println(s);
    }

}
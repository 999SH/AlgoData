package Lab2;

public class Calculator {
    Item[] expr;
    int ip;
    Stack stack;

    public Calculator(Item[] expr) {
        this.expr = expr;
        this.ip = 0;
        this.stack = new Stack();
    }

    public int run() {
        while (ip < expr.length) {
            step();
        }
        return stack.pop();
    }

    public void step() {
        Item nxt = expr[ip++];

        switch (nxt.getType()) {
            case ADD: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x + y);
                break;
            }
            case SUB: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x - y);
                break;
            }
            case MUL: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x * y);
                break;
            }
            case DIV: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x / y);
                break;
            }
            case VALUE: {
                stack.push(nxt.getValue());
                break;
            }
            case MOD: {
                int y = stack.pop();
                stack.push(y%10);
                break;
            }
            case STRANGE: {
                int y = stack.pop();
                int x = stack.pop();
                int z = x*y;
                if (z>9){
                    x = z%10;
                    y=z/10;
                    stack.push(x+y);
                }
                else {
                    stack.push(z);
                }
                break;
            }
        }
    }
}


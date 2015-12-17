import java.util.Scanner;

public class BracketsChecker {
    private String input;

    public BracketsChecker(String in) {
        input = in;
    }

    public void check() {
        StringBuilder sb = new StringBuilder();
        int stackSize = input.length();
        StackX stack = new StackX(stackSize);
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '{':
                case '(':
                case '[':
                    stack.push(ch);
                    sb.append(ch);
                    break;
                case '}':
                case ')':
                case ']':
                    if (!stack.isEmpty()) {
                        char chx = stack.pop();
                        if ((ch == '}' && chx != '{') ||
                                (ch == ')' && chx != '(') ||
                                (ch == ']' && chx != '[')) {

                            if (ch == '}') {
                                sb.append('{');
                            }
                            if (ch == ')') {
                                sb.append('(');
                            }
                            if (ch == ']') {
                                sb.append('[');
                            }

                        }
                        sb.append(ch);

                    } else {

                        if (ch == '}') {
                            sb.append('{');
                        }
                        if (ch == ')') {
                            sb.append('(');
                        }
                        if (ch == ']') {
                            sb.append('[');
                        }
                        sb.append(ch);
                    }

                    break;
                default:
                    break;

            }

        }
        if (!stack.isEmpty()) {

            while (!stack.isEmpty()) {
                char chx = stack.pop();
                if (chx == '{') {
                    sb.append('}');
                }
                if (chx == '(') {
                    sb.append(')');
                }
                if (chx == '[') {
                    sb.append(']');
                }
            }

            System.out.println((checkT(sb.toString()) ? sb.toString() : "IMPOSSIBLE"));
        }
        else
        System.out.println((checkT(sb.toString()) ? sb.toString() : "IMPOSSIBLE"));

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        BracketsChecker checker = new BracketsChecker(input);
        checker.check();

    }

    public boolean checkT(String s) {
        int stackSize = s.length();
        StackX stack = new StackX(stackSize);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '{':
                case '(':
                case '[':
                    stack.push(ch);
                    break;
                case '}':
                case ')':
                case ']':
                    if (!stack.isEmpty()) {
                        char chx = stack.pop();
                        if ((ch == '}' && chx != '{') ||
                                (ch == ')' && chx != '(') ||
                                (ch == ']' && chx != '['))
                            System.out.println("Error " + ch + " at " + i);

                    } else {
                        System.out.println("Error " + ch + " at " + i);
                    }
                    break;
                default:
                    break;

            }

        }
        return stack.isEmpty();
    }
}

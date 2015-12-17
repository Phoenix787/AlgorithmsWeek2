/**
 * Created by Ксения on 17.12.2015.
 */
public class BracketsChecker {
    private String input;

    public BracketsChecker(String in){
        input = in;
    }

    public void check(){
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
                    if (!stack.isEmpty()){
                        char chx = stack.pop();
                        if( (ch == '}' && chx != '{') ||
                            (ch == ')' && chx != '(') ||
                            (ch == ']' && chx != '[')) {
                            System.out.println("Error " + ch + " at " + i);
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
                        sb.append(ch);

                    } else{
                        System.out.println("Error " + ch + " at " + i );
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
            System.out.println("Error: missing right delimeter");
            System.out.println(sb.toString());
        }
        else
            System.out.println(sb.toString());

    }

    public static void main(String[] args) {
        String input = "}({[]})(";

        BracketsChecker checker = new BracketsChecker(input);
        checker.check();

    }
}

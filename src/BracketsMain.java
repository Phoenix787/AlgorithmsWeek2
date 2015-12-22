import java.util.Scanner;

/**
 * Created by Ксения on 21.12.2015.
 * РЕШЕНО ПРАВИЛЬНО
 */
public class BracketsMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        check(input);
    }

    public static boolean isRight(String s){
        boolean res = true;
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
                            //res = false;
                        //return false;
                        ;

                    } else {
                        //System.out.println("Error " + ch + " at " + i);
                        res = false;
                    }
                    break;
                default:
                    break;

            }

        }
        return res;
    }

    public static void check(String input) {
        int length = input.length();
        StackX stack = new StackX(length);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
                switch (ch) {
                    case '(':
                    case '{':
                    case '[':
                        stack.push(ch);
                        sb.append(ch);
                        break;
                    case ')':
                    case '}':
                    case ']':
                        if (!stack.isEmpty()) {
                            char chx = stack.pop();
                            if(chx == '{' && ch != '}' )
                                sb.append('}');
                            if(chx == '(' && ch != ')' )
                                sb.append(')');
                            if(chx == '[' && ch != ']' )
                                sb.append(']');
                            sb.append(ch);
                        }else{
                            if (ch == '}'){
                                sb.insert(0, '{');
                                //sb.append('{');
                                sb.append(ch);
                            }
                            if (ch == ')'){
                                sb.insert(0, '(');
                                //sb.append('(');
                                sb.append(ch);
                            }
                            if (ch == ']'){
                                sb.insert(0, '[');
                                //sb.append('[');
                                sb.append(ch);
                            }
                        }

                        break;
                }
            }
        while (!stack.isEmpty()){
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

        System.out.println(sb.toString());

        System.out.println(isRight(sb.toString()) ? sb.toString() : "IMPOSSIBLE");
        }

}

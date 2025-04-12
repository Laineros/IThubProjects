import java.util.Scanner;
import java.util.Stack;
public class StackRealization {
    public static void main(String[] args) {
        //stackEx1();
        stackEx2();
    }
    public static void stackEx1() {
        Stack<Character> stack = new Stack<>();
        stack.push('a');
        stack.push('b');
        stack.push('c');
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.push('c');
        stack.push('d');
        System.out.println("Перевёрнутая строка: ");
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }

    public static void stackEx2() {
        Stack<Character> stack = new Stack<>();
        try {
            Scanner sc = new Scanner(System.in);
            String st = sc.nextLine();
            for (int i = 0; i < st.length(); i++) {
                if (st.charAt(i) == '[' || st.charAt(i) == '{' || st.charAt(i) == '(') {
                    stack.push(st.charAt(i));
                } else {
                    if (st.charAt(i) == ']' || st.charAt(i) == '}' || st.charAt(i) == ')') {
                        if (stack.isEmpty()) {
                            throw new Exception();
                        } else {
                            char ch = stack.pop();
                            if (ch == '{' && st.charAt(i) == '}') {
                            } else if (ch == '[' && st.charAt(i) == ']') {
                            } else if (ch == '(' && st.charAt(i) == ')') {
                            } else {
                                throw new Exception();
                            }
                        }
                    }
                }
            }
            System.out.println("Корректная");
        } catch (Exception e) {
            System.out.println("Некорректная");
        }
    }
}

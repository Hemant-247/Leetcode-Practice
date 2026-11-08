class Solution {
    public String decodeString(String s) {

        Stack<Integer> numberStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        String curr = "";
        String num = "";

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                num += ch;
            }

            else if (ch == '[') {
                numberStack.push(Integer.parseInt(num));
                num = "";

                stringStack.push(curr);
                curr = "";
            }

            else if (ch == ']') {
                int count = numberStack.pop();
                String prev = stringStack.pop();

                String temp = "";

                for (int i = 0; i < count; i++) {
                    temp += curr;
                }

                curr = prev + temp;
            }

            else {
                curr += ch;
            }
        }

        return curr;
    }
}
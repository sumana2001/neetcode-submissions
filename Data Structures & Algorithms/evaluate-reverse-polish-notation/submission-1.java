class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> s=new ArrayDeque<>();
        for(String token: tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int int1=s.pop();
                int int2=s.pop();
                int calc=0;
                switch(token){
                    case "+":
                        calc=int2+int1;
                        break;
                    case "-":
                        calc=int2-int1;
                        break;
                    case "*":
                        calc=int2*int1;
                        break;
                    case "/":
                        calc=int2/int1;
                        break;
                }
                s.push(calc);
            } else {
                s.push(Integer.parseInt(token));
            }
        }
        return s.peek();
    }
}

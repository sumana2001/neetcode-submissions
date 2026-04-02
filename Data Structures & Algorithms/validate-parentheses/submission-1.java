class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            Character c=s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            } else {
                if(stack.size()==0) return false;
                else if(c==')'){
                    if(stack.peek()!='(') return false;
                    stack.pop();
                } else if(c=='}'){
                    if(stack.peek()!='{') return false;
                    stack.pop();
                } else {
                    if(stack.peek()!='[') return false;
                    stack.pop();
                }
            }
        }
        if(stack.size()!=0) return false;
        return true;
    }
}

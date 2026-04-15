class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> sLeft=new Stack<>();
        Stack<Integer> sStar=new Stack<>();
        for(int i=0;i<s.length();i++){
            Character c=s.charAt(i);
            if(c=='('){
                sLeft.push(i);
            } else if(c=='*'){
                sStar.push(i);
            } else{
                if(!sLeft.isEmpty()){
                    sLeft.pop();
                } else if(!sStar.isEmpty()) {
                    sStar.pop();
                } else {
                    return false;
                }
            }
        }
        while(!sLeft.isEmpty() && !sStar.isEmpty()){
            int left=sLeft.pop();
            int star=sStar.pop();
            if(left>star) return false;
        }
        if(sLeft.isEmpty()) return true;
        return false;

    }
}

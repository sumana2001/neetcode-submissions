class Solution {
    private List<String> res;
    private String[] digitToChar={
        "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return new ArrayList<>();
        res=new ArrayList<>();
        backtrack(digits,0,new StringBuilder());
        return res;
    }
    private void backtrack(String digits, int start, StringBuilder sb){
        if(start==digits.length()){
            String curr=sb.toString();
            res.add(curr);
            return;
        }
        char digit=digits.charAt(start);
        String chars=digitToChar[digit-'0'];
        for(int i=0;i<chars.length();i++){
            sb.append(chars.charAt(i));
            backtrack(digits,start+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

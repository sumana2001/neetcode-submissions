class Solution {
    class State{
        String word;
        int level;
        State(String w, int l){
            this.word=w;
            this.level=l;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        int n=beginWord.length();
        Map<String,List<String>> mp=new HashMap<>();
        for(String word: wordList){
            for(int i=0;i<n;i++){
                String pattern=word.substring(0,i)+"*"+word.substring(i+1);
                mp.computeIfAbsent(pattern,k->new ArrayList<>()).add(word);
            }
        }
        Queue<State> q=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        q.add(new State(beginWord,1));
        visited.add(beginWord);
        while(!q.isEmpty()){
            State cur=q.poll();
            String word=cur.word;
            int level=cur.level;
            if(word.equals(endWord)) return level;
            for(int i=0;i<word.length();i++){
                String pattern=word.substring(0,i)+"*"+word.substring(i+1);
                List<String> list=mp.getOrDefault(pattern,new ArrayList<>());
                for(String s: list){
                    if(!visited.contains(s)) {
                        q.add(new State(s,level+1));
                        visited.add(s);
                    }
                }
            }
        }
        return 0;
    }
}

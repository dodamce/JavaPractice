import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length!=popped.length){
            return false;
        }
        Stack<Integer> st=new Stack<>();
        int popPos=0;
        for(int i=0;i<pushed.length;i++){
            if(pushed[i]!=popped[popPos]){
                st.push(pushed[i]);
            }
            else{
                while(true){
                    popPos++;
                    if(st.empty()||st.peek()!=popped[popPos]){
                        break;
                    }
                    else if(st.peek()==popped[popPos]){
                        st.pop();
                    }
                }
            }
        }
        return st.empty();
    }
}
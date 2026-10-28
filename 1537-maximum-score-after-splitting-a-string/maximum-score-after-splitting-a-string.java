class Solution {
    public int maxScore(String s) {
        int tone=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                tone++;
            }
            
        }
        int zero=0;
        int result=0;
        int rone;
        int one=0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='0'){
                zero++;
            }
            else{
                one++;
            }
        rone=tone-one;
        result=Math.max(result,rone+zero);

        
        }
       
        return result;
    }
}
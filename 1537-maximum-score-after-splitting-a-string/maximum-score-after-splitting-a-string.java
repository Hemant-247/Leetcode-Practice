class Solution {
    public int maxScore(String s) {
        int co=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                co++;
            }
            
        }
        int z=0;
        int r=0;
        int rv;
        int v=0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='0'){
                z++;
            }
            else{
                v++;
            }
             rv=co-v;
        r=Math.max(r,rv+z);
        
        
        }
       
        return r;
    }
}
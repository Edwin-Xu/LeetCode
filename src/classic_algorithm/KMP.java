package classic_algorithm;

/**
 * Created by Edwin Xu on 9/15/2020 11:59 PM
 */
public class KMP{
    int[] getNext(String pat){
        int j = 0;
        int k = -1;
        int [] next = new int[pat.length()];
        next[0] = -1;

        while( j<pat.length()-1 ){
            if(k==-1 || pat.charAt(k)==pat.charAt(j)){
                j++;
                k++;
                next[j] = k;
            }
            else k = next[k];
        }
        return next;
    }

    int kmp(String pat,String s){
        int i = 0;
        int j = 0;
        int slen = s.length();
        int plen = pat.length();
        int [] next = getNext(pat);

        while( i<slen && j<plen ){
            if(s.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }
            else{
                if(next[j]==-1){
                    i++;
                    j=0;
                }
                else j = next[j];
            }

            if(j == plen) return i-j;
        }
        return -1;
    }


    public static void main(String[] args) {

    }
}

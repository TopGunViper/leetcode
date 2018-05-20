package edu.ouc.contest84;

public class _833_Find_And_Replace_in_String {

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {

        sort(indexes, sources, targets);
        StringBuilder sb = new StringBuilder();
        int lastIndex = 0;
        for (int i = 0; i < indexes.length; i++) {
            if(lastIndex < indexes[i]){
                sb.append(S.substring(lastIndex, indexes[i]));
            }
            if (S.substring(indexes[i]).startsWith(sources[i])) {
                sb.append(targets[i]);
                lastIndex = indexes[i] + sources[i].length();
            }else {
                lastIndex = indexes[i];
            }
        }
        if(lastIndex < S.length()){
            sb.append(S.substring(lastIndex, S.length()));
        }
        return sb.toString();
    }
    private void sort(int[] indexes, String[] sources, String[] targets){
        for(int i = 0; i < indexes.length; i++){
            int k = i;
            for(int j = i; j < indexes.length;j++){
                if(indexes[j] < indexes[k]){
                    k = j;
                }
            }
            if(k != i){
                swap(indexes, i,k);
                swap(sources, i,k);
                swap(targets, i,k);
            }
        }
    }
    private void swap(int[] indexes, int i, int k){
        int tmp = indexes[i];
        indexes[i] = indexes[k];
        indexes[k] = tmp;
    }
    private void swap(String[] strArr, int i, int k){
        String tmp = strArr[i];
        strArr[i] = strArr[k];
        strArr[k] = tmp;
    }
    public static void main(String args[]) {
        //test case1
        _833_Find_And_Replace_in_String
                tester = new _833_Find_And_Replace_in_String();
        String S = "abcd";
        int[] indexes = {0, 2};
        String[] sources = {"a", "cd"};
        String[] targets = {"eee", "ffff"};
//        System.out.println(tester.findReplaceString(S, indexes, sources, targets));

        S = "vmokgggqzp";
        int[] indexes2 = {3,5,1};
        String[] sources2 = {"kg","ggq","mo"};
        String[] targets2 = {"s","so","bfr"};
        System.out.println(tester.findReplaceString(S, indexes2, sources2, targets2));
    }
}

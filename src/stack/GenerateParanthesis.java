package stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public void dfsCreate(List<String> resList, StringBuilder sb, int left, int right, int n){
        if(left == n && right == n){
            resList.add(sb.toString());
            return;
        }
        if(left < n){
            sb.append("(");
            dfsCreate(resList, sb, left+1, right, n);
            sb.setLength(sb.length()-1);
        }
        if(right < left){
            sb.append(")");
            dfsCreate(resList, sb, left, right+1, n);
            sb.setLength(sb.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>();
        dfsCreate(resList, new StringBuilder(), 0, 0, n);
        return resList;
    }
    public static void main(String[] args){
        GenerateParanthesis g = new GenerateParanthesis();
        System.out.println(g.generateParenthesis(3));
    }
}

import java.util.*;

class AllParenthesis{
    // static String s = "";
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        
        solve(4,4,list,"");
        System.out.println(list);
    }

    static void solve(int o,int c,ArrayList<String> list,String s){
            if(o == 0 && c == 0){
                // list.add(s);
                System.out.println(s);
                return;
            }
            if(o  ==  c){
                // list.add('(');
                // s = ;
                solve(o-1,c,list,new String(s+'('));
                // list.remove(list.size()-1);
            }
            else{
                if(o>0){
                    // list.add('(');
                    // s = ;
                    solve(o-1,c,list,new String(s+'('));
                    // list.remove(list.size()-1);
                }
                // list.add(')');
                
                solve(o,c-1,list,new String(s+')'));
                // list.remove(list.size()-1);
            }
            //   System.out.println("finish :"+o+" "+c);  
    }
}

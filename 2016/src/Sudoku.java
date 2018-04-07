import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sudoku {
    int[][] unit=new int[9][9];
    public Sudoku(String[] s){
       int i=0;
       int j;
       String[] sunit;
       for(String row:s){
           sunit=row.split(" ");
           j=0;
           for(String su:sunit){
               unit[i][j]=Integer.parseInt(su);
               j++;
           }
           i++;
       }
    }
    public boolean solve(){
        boolean changed=false;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(unit[i][j]==0){
                    List<Integer> l=new ArrayList<>();
                    for(int n=1;n<=9;n++){
                        l.add(n);
                    }
                    for(int x=0;x<9;x++){
                        if(l.contains(unit[i][x])&& x!=j)
                            l.remove((Integer) unit[i][x]);
                        if(l.contains(unit[x][j])&& x!=i)
                            l.remove((Integer) unit[x][j]);
                    }
                    int U=i/3;
                    int V=j/3;
                    for(int u=U*3;u<U*3+3;u++){
                        for (int v=V*3;v<V*3+3;v++){
                            if(l.contains(unit[u][v])&& u!=i && v!=j)
                                l.remove((Integer) unit[u][v]);
                        }
                    }
                    if(l.size()==1) {
                        unit[i][j] = l.get(0);
                        changed = true;
                    }
                }
            }
        }
        return changed;
    }
    public String[] output(){
        String[] s=new String[9];
        for(int i=0;i<9;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<9;j++){
                sb.append(unit[i][j]);
                if(j!=8)
                    sb.append(" ");
            }
            s[i]=sb.toString();
        }
        return s;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] s=new String[9];
        int i=0;
        for(int n=0;n<9;n++) {
            if (sc.hasNextLine()) {
                s[i] = sc.nextLine();
                i++;
            }
        }
        Sudoku sdk=new Sudoku(s);
        while (sdk.solve()){
        }
        s=sdk.output();
        for(String string:s){
            System.out.println(string);
        }
    }
}

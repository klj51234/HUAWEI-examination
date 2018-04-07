import java.util.*;

public class Main {
    /*
    第一题：约瑟夫环
     */
    public static int shanshu(int n){
        if(n>1000)
            n=1000;
        int deleted=2;
        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(i);
        }
        while(arr.size()>1){
            arr.remove(deleted);
            deleted=(deleted+2) % (n-1) ;
            n=arr.size();
        }
        return  arr.get(deleted).intValue();
    }
    /*
    第二题：删去重复字符
     */
    public static String stringCollection(String s){
        List<Character> carr=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(carr.contains(s.charAt(i)))
                continue;
            else
                carr.add(s.charAt(i));
        }
        StringBuilder sb=new StringBuilder();
        for(Character c:carr){
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
            System.out.println(stringCollection(sc.next()));
    }
}

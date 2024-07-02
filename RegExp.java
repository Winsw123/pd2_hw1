
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RegExp {
    public static void Palindrome(String line){
                int left = 0;
                int right = line.length()-1;
                    while(left<right){
                        if(line.charAt(left)!=line.charAt(right))
                        {
                            System.out.print("N,");
                            return;
                        }
                        else{
                            left++;
                            right--;
                        }
                    }
                    System.out.print("Y,");
                    return;
                }
            
    
    public static void SameStr(String line , String string1){
        boolean check = line.contains(string1);
        if(check==true){
            System.out.print("Y,");
        }else{
            System.out.print("N,");
        }
    }

    public static void nStr(String line , String string2 , int cnt){
        int count = 0;
        int pos1=0;
        int pos=0;
        while(pos>=0){
        pos = line.indexOf(string2,pos1);
        if(pos>=0){
            pos1=pos+1;
            count++;
            //System.out.println(pos);
        }
        }
        if(count>=cnt){
            System.out.print("Y,");
        }else{
            System.out.print("N,");
        }
    }

    public static void AmB2m(String line){
        int begin = line.indexOf("a",0);
        if(begin>=0){
            if(line.indexOf("bb",(begin+1))>=0){
                System.out.println("Y");
            }else{
                System.out.println("N");
            }
        }else{
            System.out.println("N");
        }
    }

    public static void main(String[] args) {
        String str1 = args[1];
        String str2 = args[2];
        int s2Count = Integer.parseInt(args[3]);

        //For your testing of input correctness
        //System.out.println("The input file:"+args[0]);
        //System.out.println("str1="+str1);
        //System.out.println("str2="+str2);
        //System.out.println("num of repeated requests of str2 = "+s2Count);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line;
            while ((line = reader.readLine()) != null) {
                //You main code should be invoked here
                line = line.replaceAll("//s+","").toLowerCase();
                Palindrome(line);
                SameStr(line,str1);
                nStr(line,str2,s2Count);
                AmB2m(line);
                //System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


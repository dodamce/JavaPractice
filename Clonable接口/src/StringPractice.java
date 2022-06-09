public class StringPractice {
    public static void main(String[] args) {
//        String str="123456";
//        System.out.println(isNumString(str));
        //StringBuilder与Stringbuff相比，Stringbuff线程安全
        String str="abcabc";
        String soc="def";
        System.out.println(str.indexOf(soc));
    }

    public static boolean isNumString(String Str){
        char[]arr=Str.toCharArray();
        int size=arr.length;
        if(size==0){
            return false;
        }
        int pos=0;
        if(arr[0]=='+'||arr[0]=='-'){
            pos++;
        }
        for(int i=pos;i<size;i++){
            if(arr[i]<'0'||arr[i]>'9'){
                return false;
            }
        }
        return true;
    }
}

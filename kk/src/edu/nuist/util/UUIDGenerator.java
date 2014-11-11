package edu.nuist.util;
import java.util.UUID;

public class UUIDGenerator { 
    public UUIDGenerator() { 
    } 
    
    public static String getUUID(){ 
        String s = UUID.randomUUID().toString(); 
        //去掉“-”符号
        System.out.println(s);
        return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
    }
    public static String[] getUUID(int number){ 
        String[] ss = new String[number]; 
        for(int i=0;i<number;i++){ 
            ss[i] = getUUID(); 
        } 
        return ss; 
    } 
    public static void main(String[] args){ 
        String[] ss = getUUID(2); 
        for(int i=0;i<ss.length;i++){ 
            System.out.println(ss[i]); 
        } 
    } 
}   
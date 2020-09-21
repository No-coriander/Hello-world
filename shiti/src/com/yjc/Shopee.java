package com.yjc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shopee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String matchStr = sc.nextLine();
        ifMatch(str,matchStr);
    }

    private static void ifMatch(String str, String matchStr) {
        if(!str.contains("*")){
            if(str.equals(matchStr)){
                System.out.println("0 "+str.length());
            }else {
                System.out.println("-1 0");
            }
            return;
        }
        String[] split = str.split("\\*");
        String prefix = split[0];
        String suffix = split[1];
        List<Integer> containPrefixArr = new ArrayList();
        List<Integer> containSuffixArr = new ArrayList();
        if(prefix.equals("")){
            int j = 0;
            while(j<matchStr.length()-1){
                if(matchStr.indexOf(suffix, j)==-1){
                    break;
                }else {
                    int index = matchStr.indexOf(suffix, j);
                    containSuffixArr.add(index);
                    j = index+suffix.length();
                }
            }
            if(containSuffixArr.size()!=0){
                for(int h : containSuffixArr){
                    for (int k = 0; k <= h; k++) {
                        System.out.println(k+" "+ (h-k+suffix.length()));
                    }
                }
            }
        }else {
            if(suffix.equals("")){
                int i = 0;
                while(i<matchStr.length()-1){
                    if(matchStr.indexOf(prefix, i)==-1){
                        break;
                    }else {
                        int index = matchStr.indexOf(prefix, i);
                        containPrefixArr.add(index);
                        i = index+prefix.length();
                    }
                }
                if(containPrefixArr.size()!=0){
                    for (int k : containPrefixArr){
                        for (int l = 0; l <= k; l++) {
                            System.out.println(l+" "+ (k-l+prefix.length()));
                        }
                    }
                }
            }else {
                int i = 0;
                while(i<matchStr.length()-1){
                    if(matchStr.indexOf(prefix, i)==-1){
                        break;
                    }else {
                        int index = matchStr.indexOf(prefix, i);
                        containPrefixArr.add(index);
                        i = index+prefix.length();
                    }
                }
                int j = 0;
                while(j<matchStr.length()-1){
                    if(matchStr.indexOf(suffix, j)==-1){
                        break;
                    }else {
                        int index = matchStr.indexOf(suffix, j);
                        containSuffixArr.add(index);
                        j = index+suffix.length();
                    }
                }
                if(containPrefixArr.size()!=0&&containSuffixArr.size()!=0){
                    for (int k : containPrefixArr){
                        for(int h : containSuffixArr){
                            if(k<=h){
                                System.out.println(k+" "+ (h-k+suffix.length()));
                            }
                        }
                    }
                }else {
                    System.out.println("-1 0");
                    return;
                }
            }
        }
        if(containPrefixArr.size()==0&&containSuffixArr.size()==0){
            System.out.println("-1 0");
        }

    }
}

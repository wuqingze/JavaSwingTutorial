package com.wqz.test;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ExpressionTest {

    @Before
    public void before(){
        System.out.println("hello world before");
    }

    @Test
    public void test(){
        System.out.println("hello world test");
    }

    public static int calculate(String expression){

        return 0;

    }

    @Test
    public void testStr2Array(){
        String ex = "12+2-45*3455/34.3";

        ArrayList<String> l = new ArrayList<String>();
        int len = ex.length();
        int i=0;
        StringBuilder sb = new StringBuilder();
        while (i<len){
            if(ex.charAt(i) == '+' || ex.charAt(i)=='-' || ex.charAt(i)=='*' || ex.charAt(i) =='/'){
                if(!"".equals(sb.toString())){
                    l.add(sb.toString());
                    sb.delete(0,sb.toString().length());
                }
                l.add(ex.charAt(i)+"");
            }else{
                sb.append(ex.charAt(i));
            }
            i += 1;
            if(i == len){
                l.add(sb.toString());
            }
        }
        System.out.println(Arrays.toString(l.toArray()));
    }


    @Test
    public void testMiddle2Post(){
        ArrayList<String> l = new ArrayList<String>();
        l.add("12");
        l.add("+");
        l.add("2");
        l.add("*");
        l.add("24");
//        l.add("-");
//        l.add("45");
//        l.add("*");
//        l.add("3455");
//        l.add("/");
//        l.add("34.3");

        ArrayList<String> stack = new ArrayList<String>();
        ArrayList<String> result = new ArrayList<String>();

        for(int i=0;i<l.size();i++){
            if(!("+".equals(l.get(i)) || "-".equals(l.get(i)) || "*".equals(l.get(i)) || "/".equals(l.get(i)))){
                result.add(l.get(i));
            }else{
                String operator = l.get(i);
                int index = stack.size()-1;
                if("*".equals(operator) || "/".equals(operator)){
                    while (index > -1){
                        result.add(stack.get(index));
                        stack.remove(index);
                        index -= 1;
                    }
                }else{
                    while (index>-1 && ("+".equals(operator) || "-".equals(operator))){
                        result.add(stack.get(index));
                        stack.remove(index);
                        index -= 1;
                    }
                }
                stack.add(operator);
            }
        }
        while (stack.size()>0){
            result.add(stack.get(stack.size()-1));
            stack.remove(stack.size()-1);
        }
        System.out.println(Arrays.toString(result.toArray()));
    }
}

package com.ll.baekjoon.Baekjoon4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

//오른쪽은 무조건 짝이 있으니까 뒤에서부터 와서 오른쪽이 먼저면 yes 왼쪽이 먼저면 no
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        while(true){
            String str = br.readLine();
            if(str.equals("."))
                break;
            list.add(str);
        }

        for(String s : list){
            Stack<Character> stack = new Stack<>();
            boolean isSuccess = true;
            for(int i=0; i<s.length(); i++) {
                char ch = s.charAt(i);

                if(ch=='(' || ch=='[')
                    stack.add(ch);
                else if(ch==')'){
                    if(!stack.isEmpty() && stack.peek()=='(')
                        stack.pop();
                    else{
                        isSuccess = false;
                        break;
                    }
                }
                else if(ch==']'){
                    if(!stack.isEmpty() && stack.peek()=='[')
                        stack.pop();
                    else{
                        isSuccess = false;
                        break;
                    }
                }
            }
            if(stack.isEmpty() && isSuccess)
                sb.append("yes\n");
            else
                sb.append("no\n");
        }

        System.out.println(sb);


    }
}

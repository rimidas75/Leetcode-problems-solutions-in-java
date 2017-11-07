package edu.buffalo.liveramp;

import java.util.Stack;

public class BalanceParen {
	public static void main(String[] args) {
		BalanceParen bp = new BalanceParen();
		bp.balanced("(])");
	}

	private void balanced(String string) {
		char[] c  = string.toCharArray();
		if(c.length==1)
			System.out.println("no");
		Stack<Character> s = new Stack<Character>();
		for(int i = 0;i<c.length;i++)
		{
			if(c[i]=='(' || c[i]=='[' || c[i]=='{')
			{
				s.push(c[i]);
			}
			if(c[i]==')' || c[i]==']' || c[i]=='}')
			{
				if(!s.isEmpty() && ((s.peek()=='('  && c[i]==')') || (s.peek()=='{'  && c[i]=='}') || (s.peek()=='['  && c[i]==']')))
				{
					s.pop();
				}
				else
				{
					//no
				}
			}
		}
		
		if(s.isEmpty())
			System.out.println("yes");
		else
			System.out.println("no");
		
	}

}

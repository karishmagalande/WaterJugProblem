/*
 * Water jug problem: two jugs with given capacities, an unlimited water
 * supply, and a target amount to end up with in one jug (the other empty).
 * Allowed moves: fill a jug, empty a jug, or pour one jug into the other.
 * Prints each (jug1,jug2) state from (0,0) to the goal.
 */

import java.util.*;
public class WaterJugProblem {

	public static void main(String[] args) {
		problem p=new problem();
		Scanner sc=p.s;               // share one Scanner so input is not split between two readers
		int ch;
		System.out.println("WATER JUG PROBLEM SOLUTION ");
		System.out.println("======================================");
		do
		{
			System.out.println("\nMenu :\n1.Water-Jug Problem Solution\n2.Exit");
			System.out.println("Enter your choice :");
			ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				p.solution();
				break;
				
			case 2:
				System.out.println("THANK YOU!!");
				break;
				
			default:
				System.out.println("Invalid choice!!");
			}
			
		}while(ch!=2);
	}
}
class problem
{
	Scanner s=new Scanner(System.in);
	int m,n,m_max,n_max;
	int goal1, goal2;
	public problem()
	{
		m=0;
		n=0;
		m_max=0;
		n_max=0;
		goal1=0;
		goal2=0;
	}
	public void solution()
	{
		System.out.print("Enter maximum amount of water in first jar:");
		m_max=s.nextInt();
		System.out.print("Enter maximum amount of water in second jar:");
		n_max=s.nextInt();
		System.out.print("Enter goal state 1:");
		goal1=s.nextInt();
		System.out.print("Enter goal state 2:");
		goal2=s.nextInt();
		int g=gcd(m_max,n_max);
		if(goal1!=0 && goal2!=0)
		{
			System.out.println("\nOne goal must be 0: the target amount ends up in one jug, the other jug empty.");
		}
		else if(goal1>m_max || goal2>n_max || (goal1+goal2)%g!=0)
		{
			// a target is reachable only if it fits in its jug and is a multiple of gcd(capacities)
			System.out.println("\nGoal is not reachable");
		}
		else
		{
			m=0;
			n=0;
			System.out.println(m+","+n);
			int flag=0;
			if(goal2==0)
			{
				while(flag!=1)
				{
					if((m==goal1) && (n==goal2))
					{
						flag=1;
					}
					else if(this.m==0)
					{
						fillM();
					}

					else if ((this.m > 0) && (this.n != this.n_max)) {
						transferMtoN();

					}
					else if(this.n==0)
					{
						fillN();
					}
					else if ((this.m > 0) && (this.n == this.n_max)) {
						emptyN();
					}
				}
			}
			int f=0;
			if(goal1==0)
			{
				while(f!=1)
				{
					if((m==goal1) && (n==goal2))
					{
						f=1;
					}
					else if(this.n==0)
					{
						fillN();
					}

					else if ((this.n > 0) && (this.m != this.m_max)) {
						transferNtoM();

					}
					else if(this.m==0)
					{
						fillM();
					}
					else if ((this.n > 0) && (this.m == this.m_max)) {
						emptyM();
					}
				}
			}
		}
	}
	int gcd(int a,int b)
	{
		return b==0 ? a : gcd(b,a%b);
	}
	void fillM()
	{
		m=m_max;
		System.out.println(m+","+n);

	}
	void fillN()
	{
		n=n_max;
		System.out.println(m+","+n);

	}
	void transferMtoN()
	{
		int fin = 0;

		while(fin != 1) {

			n += 1;
			m -= 1;

			if((n == n_max) || (m == 0)) { fin = 1;}

		}

		System.out.println(m + "," + n );
	}
	void transferNtoM()
	{
		int fin = 0;

		while(fin != 1) {

			m += 1;
			n -= 1;

			if((m == m_max) || (n == 0)) { fin = 1;}

		}

		System.out.println(m + "," + n );
	}
	private void emptyN()
	{
		n=0;
		System.out.println(m+","+n);
	}
	private void emptyM()
	{
		m=0;
		System.out.println(m+","+n);
	}
}

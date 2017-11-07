package edu.buffalo.liveramp;

public class Triangle {
	public static void main(String[] args) {
		Triangle t = new Triangle();
		t.checkType(13,5,12);
	}

	private void checkType(int i, int j, int k) {
		if(i==j && j==k)
			System.out.println("Equi");
		else
			if(i==j || j==k || k==i)
			{
				System.out.println("iso");
			}
			else
				if(i>=(j+k) || j>= (i+k) || k>=(i+j))
				{
					System.out.println("Not possible");
				}
				else
				{
					// find min  and mx
					int max = Math.max(i, Math.max(j, k));
					System.out.println("nothing");
				}
	}

	
}

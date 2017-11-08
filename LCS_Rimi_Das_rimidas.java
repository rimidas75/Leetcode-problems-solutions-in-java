
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LCS_Rimi_Das_rimidas {
	
	int[][] opt = new int[1000][1000];
	char[][] optChar = new char[1000][1000];
	char[] finalCharArr  = new char[1000];
	static String string1;
	static String string2;
	static File outputFile = null;
	private static BufferedWriter bw;
	
	public void FileWriter() {

		outputFile = new File("output.txt");
		if (!outputFile.exists()) {
			try {
				outputFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {

			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void fileReader(String filePath) {

		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));

			String sCurrentLine;
			
			int line_num = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				String lineText = sCurrentLine;
				if(line_num == 0)
					string1 = lineText;
				else
					string2 = lineText;
				line_num++;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void writeToFile(BufferedWriter bw2, String string) {
		try {
			bw.write(string);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public enum optChar_Symbols {
		SideUp('s'), Left('l'), Up('u');

	    public char asChar() {
	        return asChar;
	    }

	    private final char asChar;

	    private optChar_Symbols(char asChar) {
	        this.asChar = asChar;
	    }
	}
	public void getLongestSubSequence(String a, String b){
		StringBuilder str = new StringBuilder();
		int n = a.length();
		int m = b.length();
		char[] array_A = a.toCharArray();
		char[] array_B = b.toCharArray();
		 for(int j =0;j<=m; j++)
		 {
			 opt[0][j] = 0;
		 }
		 for(int i = 1;i<=n;i++)
		{
			 opt[i][0] = 0;
			 for(int j =1;j<=m; j++)
			 {
				 if(array_A[i-1]== array_B[j-1])
				 {
					 opt[i][j] = opt[i-1][j-1] +1;
					 optChar[i][j] = optChar_Symbols.SideUp.asChar;
				 }
				 else if(opt[i][j-1] >= opt[i-1][j])
				 {
					 opt[i][j] = opt[i][j-1];
					 optChar[i][j] = optChar_Symbols.Left.asChar;
				 }
				 else
				 {
					 opt[i][j] = opt[i-1][j];
					 optChar[i][j] = optChar_Symbols.Up.asChar;
				 }
			 }
		}
		
		//final traversal
		 int c = 0;
		 int i=a.length();
		 int j=b.length();
		 while(i>=1 && j>=1)
		 {
			 
			 if(optChar[i][j]==optChar_Symbols.SideUp.asChar)
				 {
					//If equal,the add that character to a final rray of characters
					 finalCharArr[c] = array_A[i-1];
					 i--;
					 j--;
					 c++;
				 }
				 else if(optChar[i][j]==optChar_Symbols.Left.asChar)
				 {
					 j--;
				 }
				 else if(optChar[i][j]==optChar_Symbols.Up.asChar)
				 {
					 i--;
				 }
			 
		 }
		
		//reversing the final charcter rray and building String
		 writeToFile(bw, Integer.toString(c));
		 writeToFile(bw, "\n");
		 for(i = c-1; i>=0;i--)
			 str.append(finalCharArr[i]);
		 writeToFile(bw, str.toString());
		//return str.toString();
	}

	public static void main(String[] args) {
		LCS_Rimi_Das_rimidas lcs  = new LCS_Rimi_Das_rimidas();
		lcs.fileReader("input.txt");
		lcs.FileWriter();
		lcs.getLongestSubSequence(string1,string2);
		try {
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}


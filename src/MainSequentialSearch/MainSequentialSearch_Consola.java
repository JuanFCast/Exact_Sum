package MainSequentialSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
//import java.io.BufferedWriter;
import java.io.IOException;
//import java.io.OutputStreamWriter;
import java.util.Arrays;

public class MainSequentialSearch_Consola {
	public static int n;
	public static int[] booksPrice;
	public static int money;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/data/InPut_32_Casos.txt"));	
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/data/OutPut_Sequential.txt"));
		
		System.out.println("Bienvenid@ a Exact Sum con Busqueda Secuencial");
		
		
		String line= br.readLine();
		int c = 0;
		while(line!=null) {
			c++;
			
			n = Integer.parseInt(line);
			booksPrice = new int[n];
			
			
			line=br.readLine();
			String[] parts= line.split(" ");
			
			for(int i=0; i<n; i++) {
				booksPrice[i]= Integer.parseInt(parts[i]);
			}
			
			Arrays.sort(booksPrice);
			
			line=br.readLine();
			money=Integer.parseInt(line);
			
			int book1=0;
			int book2=0;
			int count=0;
			for(int i=0; i<n;i++) {

				int numb=money-booksPrice[i];
				int pos= secuencialSearch(numb, i);
				//System.out.println(pos);
				int temp1=0;
				int temp2=0;
				if(pos>=0) {
					if(booksPrice[i]<booksPrice[pos]) {
						temp1=booksPrice[i];
						temp2=booksPrice[pos];
					}else {
						temp1=booksPrice[pos];
						temp2=booksPrice[i];
					}

					count++;

					if(count==1) {
						book1=temp1;
						book2=temp2;			
					}else if(count>1) {
						if((temp2-temp1)<(book2-book1)) {
							book1=temp1;
							book2=temp2;	
						}
					}
				}

			}
			bw.write(c + ". Peter should buy books whose prices are "+book1+" and "+book2+".\n\n");
			//System.out.println("Peter should buy books whose prices are "+book1+" and "+book2+".\n\n");
			line=br.readLine();
			line=br.readLine();
		}
		
		br.close();
		bw.close();
		System.out.println("OutPut_Sequential.txt actualizado con " + c + " casos");
		
	}
	
	public static int secuencialSearch(int num, int a){

		int pos = -1;
		for (int i=0; i < booksPrice.length; i++) {
			if (i!=a && booksPrice[i]==num){
                pos=i;
                
            }
		}
		return pos;

	}
	
}

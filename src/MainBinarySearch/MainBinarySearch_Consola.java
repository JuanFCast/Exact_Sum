package MainBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MainBinarySearch_Consola {
	public static int n;
	public static int[] booksPrice;
	public static int money;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("data/InPut_32_Casos.txt"));	
		BufferedWriter bw = new BufferedWriter(new FileWriter("data/OutPut_Binary.txt"));
		
		System.out.println("Bienvenid@ a Exact Sum con Busqueda Binaria");
		
		
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
				int pos= binarySearch(numb, i);
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
		System.out.println("OutPut_Binary.txt actualizado con " + c + " casos");
		
	}

	public static int binarySearch(int num, int a){
		int pos = -1;
		int i=0;
		int j=booksPrice.length-1;
		
		while(i<=j && pos<0){
	
			int m= (i+j)/2;
			
			if(m!=a && booksPrice[m]==num){
				pos =m;
			}else if(booksPrice[m]>num){
				j=m-1;
			}else{
				i=m+1;
			}
		}
		return pos;
	}
	
	
	

}

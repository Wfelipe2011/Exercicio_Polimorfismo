package Aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		
		System.out.print("Quantos Produtos v�o ser registrados?: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Produto "+ i + "�: ");
			System.out.print("O Produto � Novo, Usado ou Importado (n/u/i)?: ");
			char ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Pre�o: ");
			double price = sc.nextDouble();
			if(ch == 'i') {
				System.out.print("Pre�o do Frete?: ");
				double frete = sc.nextDouble();
				list.add(new ImportedProduct(name, price, frete));
			}
				else {
					if(ch == 'u') {
						System.out.print("Data Aquisi��o?: ");
						Date date = sdf.parse(sc.next());
						list.add(new UsedProduct(name, price, date));	
					}
						else {
								if (ch == 'n') {
									list.add(new Product(name, price));
								}
						}		
				}		
		}	//Final for();
		System.out.println();
		System.out.println("Etiqueta de Pre�o:");
		for (Product pdt : list) {
		System.out.println(pdt.priceTag());
		}
		sc.close();
	}
}

package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.model.Product;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Product> products = new ArrayList<>();

		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		try (BufferedReader bReader = new BufferedReader(new FileReader(strPath))) {			
			String line = bReader.readLine();
			
			while (line != null) {
				String[] productStr = line.split(",");
				Product product = new Product(productStr[0], Double.parseDouble(productStr[1]), Integer.parseInt(productStr[2]));
				products.add(product);
				
				line = bReader.readLine();
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		File path = new File(strPath);
		strPath = path.getParent() + "\\out";
		
		boolean sucess = new File(strPath).mkdir();
		if(sucess) {
			strPath += "\\summary.csv";
			
			try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(strPath, true))) {
				for(Product product : products) {
					bWriter.write(product.toString());
					bWriter.newLine();
				}
			}
			catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}			
		} else {
			System.out.println("Error trying to create a directory");
		}
		
		System.out.println("Done!");
		sc.close();

	}

}

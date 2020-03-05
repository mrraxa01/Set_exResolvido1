package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter file full path: ");
		String path = sc.nextLine();
		
		//abre o arquivo 
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		
			
			Set <LogEntry> set = new HashSet<>();
			//cria uma string para salvar os dados, username na posição 0 e data na pos 1
			String line = br.readLine();
			while (line != null) {
				
				String[] fields = line.split(" ");
				String username = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));
				
				set.add(new LogEntry(username, moment)); //como o SET não aceita repetição, cada registro será contado uma vez
				
				line = br.readLine();
			}
			System.out.println("Total users: " + set.size());
			
		}catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
		
	}

}

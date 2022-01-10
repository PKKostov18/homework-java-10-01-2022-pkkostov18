package homework.java.pkkostov18;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		List<Integer> list = readListOfIntegers(scanner);
		
		String command = scanner.nextLine();
		
		while (!command.equals("End")) 
		{
			String[] tokens = command.split(" ");

			if (tokens[0].equals("Add")) 
			{
				list.add(Integer.parseInt(tokens[1]));
			} 
			else if(tokens[0].equals("Insert"))
			{
				if(Integer.parseInt(tokens[2]) < list.size())
				{
					list.add(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[1]));
				}
				else
				{
					System.out.println("Invalid index");
				}
			}
			else if(tokens[0].equals("Remove"))
			{
				if(Integer.parseInt(tokens[1]) < list.size())
				{
					list.remove(Integer.parseInt(tokens[1]));
				}
				else
				{
					System.out.println("Invalid index");
				}
			}
			else if(tokens[1].equals("left"))
			{
				int count = Integer.parseInt(tokens[2]);
				
				for(int i = 0; i < count; i++)
				{
					int temp = list.get(0);
					
					for(int j = 0; j < list.size() - 1; j++)
					{
						list.set(j, list.get(j+1));
					}
					
					list.set(list.size() - 1, temp);
				}
			}
			else if(tokens[1].equals("right"))
			{
				int count = Integer.parseInt(tokens[2]);
				
				for(int i = 0; i < count; i++)
				{
					int temp = list.get(list.size() - 1);
					
					for(int j = list.size() - 2; j >= 0; j--)
					{
						list.set(j + 1, list.get(j));
					}
					
					list.set(0, temp);
				}
			}
			command = scanner.nextLine(); 
		}
		
		for (Integer elements : list) {
			System.out.print(elements + " ");
		}
	}
	
	private static List<Integer> readListOfIntegers(Scanner scanner) {

		return Arrays.stream(scanner.nextLine().split(" "))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

}

package ContactList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		String fileName = "ContactList.txt";
		Scanner scanner = new Scanner(System.in);
		boolean newContact = true;
		List<String> contactList = new ArrayList<String>();
		int infoCount = 3;

		while (newContact) {
			// List<String> info = new ArrayList<String>();
			System.out.print("Name: ");
			String name = "Name: " + scanner.next();
			contactList.add(name);
			System.out.print("Email: ");
			String email = "Email: " + scanner.next();
			contactList.add(email);
			System.out.print("Facebook: ");
			String facebook = "Facebook: " + scanner.next();
			contactList.add(facebook);

			System.out.print("Add new contact? (1/2): ");
			int check = scanner.nextInt();
			if (check == 1) {
				newContact = true;
			} else if (check == 2) {
				newContact = false;
			}

		}

		try {
			FileWriter fileWriter = new FileWriter(fileName, true);
			FileReader fileReader = new FileReader(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			int count = 0;
			for (int i = 0; i < contactList.size(); i++) {
				bufferedWriter.write(contactList.get(i));
				bufferedWriter.newLine();
				count++;
				if (count == infoCount) {
					bufferedWriter.newLine();
					count = 0;
				}
			}

			bufferedWriter.close();
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error writing to file '" + fileName + "'");
		}
	}
}

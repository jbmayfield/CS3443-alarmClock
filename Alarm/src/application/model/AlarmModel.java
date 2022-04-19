package application.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AlarmModel {

	public void createFile(String fileName) throws IOException {
		File inventory = new File(fileName);
		if (inventory.createNewFile()) {
			System.out.println("Created new file: " + fileName);
		}
	}

	public void saveAlarm(int hour, int minute, boolean when, String fileName) throws IOException {
		createFile(fileName);

		File f1 = new File(fileName);
		Scanner infile = new Scanner(f1);
		ArrayList<String> alarms = new ArrayList<String>();
		while (infile.hasNext()) {
			alarms.add(infile.nextLine());
		}
		infile.close();

		if (alarms.size() >= 20) {
			System.out.println("Maximum amount of alarms reached.");
		} else {
			FileWriter fw = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.append(hour + " " + minute + " " + ((when) ? "AM" : "PM"));
			bw.newLine();
			bw.close();
		}
	}

	public void removeAlarm(int count, String fileName) throws IOException {
		createFile(fileName);

		File f1 = new File(fileName);
		Scanner infile = new Scanner(f1);
		ArrayList<String> alarms = new ArrayList<String>();
		while (infile.hasNext()) {
			alarms.add(infile.nextLine());
		}
		infile.close();

		if (alarms.isEmpty()) {
			System.out.println("No alarms to remove.");
		} else {
			new FileWriter(fileName, false).close();

			alarms.remove(count);
			FileWriter fw = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < alarms.size(); i++) {
				bw.append(alarms.get(i));
				bw.newLine();
			}

			bw.close();

		}
	}

	public ArrayList<String> loadAlarms1(String fileName) throws IOException {
		createFile(fileName);

		File f1 = new File(fileName);
		Scanner infile = new Scanner(f1);
		ArrayList<String[]> alarms = new ArrayList<String[]>();
		while (infile.hasNext()) {
			String split[] = infile.nextLine().split(" ");
			alarms.add(split);
		}
		infile.close();

		ArrayList<String> alarms1 = new ArrayList<String>();
		for (int i = 0; i < alarms.size(); i++) {
			if ((i < 10)) {
				alarms1.add((alarms.get(i)[0].length() < 2 ? "0" + alarms.get(i)[0] : alarms.get(i)[0]) + ":"
						+ (alarms.get(i)[1].length() < 2 ? "0" + alarms.get(i)[1] : alarms.get(i)[1]) + " "
						+ alarms.get(i)[2]);
			}
		}

		return alarms1;
	}

	public ArrayList<String> loadAlarms2(String fileName) throws IOException {
		createFile(fileName);

		File f1 = new File(fileName);
		Scanner infile = new Scanner(f1);
		ArrayList<String[]> alarms = new ArrayList<String[]>();
		while (infile.hasNext()) {
			String split[] = infile.nextLine().split(" ");
			alarms.add(split);
		}
		infile.close();

		ArrayList<String> alarms2 = new ArrayList<String>();
		for (int i = 0; i < alarms.size(); i++) {
			if (!(i < 10)) {
				alarms2.add((alarms.get(i)[0].length() < 2 ? "0" + alarms.get(i)[0] : alarms.get(i)[0]) + ":"
						+ (alarms.get(i)[1].length() < 2 ? "0" + alarms.get(i)[1] : alarms.get(i)[1]) + " "
						+ alarms.get(i)[2]);
			}
		}

		return alarms2;
	}

}

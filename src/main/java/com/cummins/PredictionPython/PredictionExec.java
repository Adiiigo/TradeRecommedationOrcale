package com.cummins.PredictionPython;

public class PredictionExec {

	public void ExecFile() {
		try {
			// create a new array of 2 strings
			String[] cmdArray = new String[2];

			String cmdExe="cmd.exe";
			// first argument is the program we want to open
			cmdArray[0] = "python";

			// second argument is a txt file we want to open with notepad
			cmdArray[1] = "C:\\Users\\aditi\\git\\BreadNBucks\\src\\main\\java\\com\\cummins\\PredictionPython\\predict.py";

			// print a message
			System.out.println("Executing notepad.exe and opening example.txt");

			// create a process and execute cmdArray and currect environment
			Process process = Runtime.getRuntime().exec(cmdExe,cmdArray);

			// print another message
			System.out.println("example.txt should now open.");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}

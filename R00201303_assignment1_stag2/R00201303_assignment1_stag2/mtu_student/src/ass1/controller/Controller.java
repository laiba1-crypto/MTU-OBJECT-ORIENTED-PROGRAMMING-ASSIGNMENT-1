package ass1.controller;


import ass1.model.Student;
import ass1.view.View;
import ass1.model.Module;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.Serializable;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller extends View implements Serializable {
	private static final long serialVersionUID = 1L;
	public ArrayList<Student> studentList = new ArrayList<>();
	public ArrayList<Module> modulesList = new ArrayList<>();
	String file_name = "studentDetails.txt";
	String module_file_name = "moduleDetails.txt";
	String studentName;
	String studentID;
	String studentDOB;
	String moduleName1;
	String moduleName2;
	String moduleName3;
	String moduleName4;
	String moduleName5;
	String moduleName6;
	int moduleGrade1;
	int moduleGrade2;
	int moduleGrade3;
	int moduleGrade4;
	int moduleGrade5;
	int moduleGrade6;
	Module moduleDetails = new Module(studentID, moduleName1, moduleName2, moduleName3, moduleName4, moduleName5,
			moduleName6, moduleGrade1, moduleGrade2, moduleGrade3, moduleGrade4, moduleGrade5, moduleGrade6);

	/**
	   *
	   * The method adds student name information information.
	   *@param studentName
	   *@param studentID
	   *@param studentDOB
	*/
	public void addStudentInfo(String studentName, String studentID, String studentDOB) {
		studentList.add(new Student(studentName, studentID, studentDOB));
		return;
	}
	
	/**
	   *
	   * The method shows the user information in the dropdown bar in the students tab
	   *
	   *
	*/
	// Adds info from user in the dropdown bar
	public ObservableList<String> dropDown() {
		ObservableList<String> studentsNames = FXCollections.observableArrayList();
		int i = 0;
		for (i = 0; i < studentList.size(); i++) {
			studentsNames.add(studentList.get(i).getStudentName().toString());
		}
		return studentsNames;
	}
	
	/**
	   *
	   * The method shows the student info to the text area once you click update
	   *
	*/
	
	public String listStudents() {
		StringBuilder string = new StringBuilder();
		String tab = "\t\t\t\t";
		for (int i = 0; i < studentList.size(); i++) {
			string.append(studentList.get(i).getStudentName() + tab);
			string.append(studentList.get(i).getStudentID() + tab);
			string.append(studentList.get(i).getStudentDOB() + tab + "\n");
		}
		return string.toString().trim();
	}
	
	/**
	   *
	   * The method saves the student info to a text area
	   *
	*/

	public String saveFile() {
		FileWriter fileNameToWrite = null;

		try {
			fileNameToWrite = new FileWriter(file_name, false); // opens connection to file, appending data

			for (int i = 0; i < studentList.size(); i++) {
				// Adding student details
				fileNameToWrite.write(studentList.get(i).getStudentName());
				fileNameToWrite.write(studentList.get(i).getStudentID());
				fileNameToWrite.write(studentList.get(i).getStudentDOB() + ",\n");
			}
			return "Saved";
		} catch (Exception saveError) {
			return "General error";
		} finally {

			if (fileNameToWrite != null) {
				try {
					fileNameToWrite.close(); // Close connection to file
				} catch (IOException saveError) {
					saveError.printStackTrace();
				}
			}
		}
	}
	
	/**
	   *
	   * The method saves the student module info to a text file
	   *
	*/
	
	public String saveModulesFile() {
		FileWriter ModuleInfoToSave = null;
		try {
			ModuleInfoToSave = new FileWriter(module_file_name, false); // append to the file
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ModuleInfoToSave.write(
					modulesList.get(0).getStudentID() + "," + modulesList.get(1).getModule1() + " "
							+ modulesList.get(1).getGrade1() + "," + modulesList.get(2).getmodule2() + " "
							+ modulesList.get(2).getGrade2() + "," + modulesList.get(3).getModule3() + " "
							+ modulesList.get(3).getGrade3() + "," + modulesList.get(4).getModule4() + " "
							+ modulesList.get(4).getGrade4() + "," + modulesList.get(6).getModule5() + " "
							+ modulesList.get(6).getGrade6() + ",\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (ModuleInfoToSave != null) {
			try {
				ModuleInfoToSave.close(); // Close connection to file
			} catch (IOException saveM) {
				saveM.printStackTrace();
			}
		}
		return "Saved";
	}
	
	/**
	   *
	   * The method saves the student module info to a text file
	   *
	*/
	
	public void loadModulesFile() {
		ArrayList<String> throwAwayArray = new ArrayList<>();
		FileReader fileRead = null;
		String item = "";

		try (BufferedReader bufferRead = new BufferedReader(new FileReader(module_file_name))) {

			if (bufferRead.readLine() != null) {
				for (int y = 0; y < bufferRead.readLine().length(); y++) {
					if (bufferRead.readLine().charAt(y) == ',') {
						item = item + bufferRead.readLine().charAt(y); // fill line 
					} else {
						throwAwayArray.add(item);
						item = "";
						continue;
					}
				}
			}

			for (int i = 0; i < throwAwayArray.size(); i += 13)  
			{
				studentID = throwAwayArray.get(i); 
				
				moduleName1 = throwAwayArray.get(i + 1); 
				moduleGrade1 = Integer.parseInt(throwAwayArray.get(i + 2)); 

				moduleName2 = throwAwayArray.get(i + 3);
				moduleGrade2 = Integer.parseInt(throwAwayArray.get(i + 4));

				moduleName3 = throwAwayArray.get(i + 5);
				moduleGrade3 = Integer.parseInt(throwAwayArray.get(i + 6));

				moduleName4 = throwAwayArray.get(i + 7);
				moduleGrade4 = Integer.parseInt(throwAwayArray.get(i + 8));

				moduleName5 = throwAwayArray.get(i + 9);
				moduleGrade5 = Integer.parseInt(throwAwayArray.get(i + 10));

				moduleName6 = throwAwayArray.get(i + 11);
				moduleGrade6 = Integer.parseInt(throwAwayArray.get(i + 12));

				// Creates and Adds new Students to ArrayList

				modulesList.add(moduleDetails);

			}

		} catch (FileNotFoundException fileNotFound) {
			System.out.println("No file found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fileRead != null) {
				try {
					fileRead.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
	/**
	   *
	   * The method loads the student info to an arraylist
	   * 
	   *
	*/
	public void loadFile() {
		ArrayList<String> throwAwayArray = new ArrayList<>();
		FileReader fileRead = null;
		String item = "";

		try {
			try (BufferedReader b = new BufferedReader(new FileReader(file_name))) {
				int i = 0;
				String line = b.readLine();
				if (line == null) {
					throwAwayArray.add(item);
				} else {
					for (i = 0; i < b.readLine().length(); i++) {
						if (b.readLine().charAt(i) == ',') {
							item = item + b.readLine().charAt(i);
						}
					}
				}
			}
			for (int y = 0; y < throwAwayArray.size(); y++) // Reads file size by lines (three because of the student
															// name, ID and DOB)
			{
				studentName = throwAwayArray.get(y) + " ";
				studentID = throwAwayArray.get(y+1) + " ";
				studentDOB = throwAwayArray.get(y+2) + " ";

				// Creates new students

				studentList.add(new Student(studentName, studentID, studentDOB));
				continue;

			}

		} catch (FileNotFoundException fileNotFound) {
			System.out.println("No file to Load");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fileRead != null)
				try {
					fileRead.close(); // Close connection to file
				} catch (IOException e) {
					e.printStackTrace();
				} 		}
	}


	/**
	   *
	   * The method saves the module info
	   * @param studentID
	   * @param module1
	   * @param module2 
	   * @param module3
	   * @param module4 
	   * @param module5
	   * @param module6
	   * @param grade1
	   * @param grade2
	   * @param grade3
	   * @param grade4
	   * @param grade5
	   * @param grade6
	   * 
	   * 
	   *
	*/
	public void saveModules(String studentID, String module1, String module2, String module3, String module4,
			String module5, String module6, int grade1, int grade2, int grade3, int grade4, int grade5, int grade6) 
	{
		Module studentsModules = new Module(studentID, module1, module2, module3, module4, module5, module6, grade1,
				grade2, grade3, grade4, grade5, grade6);

		modulesList.add(studentsModules);
		return;
	}

	/**
	   *
	   * The method lists the modules + grades in the third tab
	   * 
	   *
	*/
	public String listModulesGrades(int index) {

		StringBuilder moduleInfo = new StringBuilder();
		String tab = "\t\t\t\t";
		
		moduleInfo.append("Modules" + tab + "Grade\n");
		moduleInfo.append(modulesList.get(index).getModule1() + tab + modulesList.get(index).getGrade1() + "\n");
		moduleInfo.append(modulesList.get(index).getmodule2() + tab + modulesList.get(index).getGrade2() + "\n");
		moduleInfo.append(modulesList.get(index).getModule3() + tab + modulesList.get(index).getGrade3() + "\n");
		moduleInfo.append(modulesList.get(index).getModule4() + tab + modulesList.get(index).getGrade4() + "\n");
		moduleInfo.append(modulesList.get(index).getModule5() + tab + modulesList.get(index).getGrade5() + "\n");
		moduleInfo.append(modulesList.get(index).getModule6() + tab + modulesList.get(index).getGrade6() + "\n");
		moduleInfo.append("\n");

		return moduleInfo.toString();

	}

	/**
	   *
	   * The method removes the student info to an arraylist
	   * @param studentID
	*/	
	
	public String rmStudents(String studentID) {
		String result;
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getStudentID().contains(studentID)) {
				studentList.remove(i);
				return "Student Removed";
			} else {
				continue;
			}
		}

		result = "No ID found";
		return result;
	}

	/**
	   *
	   * Error check - does the input match requirements
	   * @param studentName
	   * @param studentID
	   * @param studentDOB
	   * @return the flag that matches with the error checking in view
	   * 
	*/	
	public int studDetailsErrorCheck(String studentName, String studentID, String studentDOB) {
		ArrayList<String> idList = new ArrayList<>();

		for (int i = 0; i < studentList.size(); i++) {
			idList.add(studentList.get(i).getStudentID());
		}

		if (studentName.length() > 2 && (studentID.charAt(0) == 'R' || studentID.charAt(0) == 'r')) { // input validation
			if (idList.contains(studentID)) {
				int flag = 1;
				return flag;
			} else {
				int flag = 1;
				return flag;
			}
		} else {
			int flag = 2;
			return flag;
		}
	}

}
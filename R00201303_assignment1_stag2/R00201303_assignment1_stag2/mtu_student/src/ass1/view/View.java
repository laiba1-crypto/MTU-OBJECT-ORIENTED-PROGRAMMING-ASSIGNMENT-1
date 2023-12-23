package ass1.view;



import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Group;

import java.time.format.DateTimeFormatter;
import java.util.Optional;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import ass1.controller.Controller;

public class View extends Application  {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Controller cont = new Controller();
			cont.loadFile();
			cont.loadModulesFile();
			primaryStage.setTitle("Student Record System MTU ");
			primaryStage.show();

			// Creating Layout
			Group group = new Group();
			TabPane tabPane = new TabPane();

			// STUDENT VIEW Boxes
			VBox VBox = new VBox();
			HBox HBox1 = new HBox();
			HBox HBox2 = new HBox();
			HBox HBox3 = new HBox();
			HBox HBox4 = new HBox();
			HBox HBox5 = new HBox();
			HBox HBox6 = new HBox();

			// MODULE VIEW Boxes
			VBox moduleVBox = new VBox();
			HBox moduleHBox1 = new HBox();
			HBox moduleHBox2 = new HBox();
			HBox moduleHBox3 = new HBox();
			HBox moduleHBox4 = new HBox();
			HBox moduleHBox5 = new HBox();
			HBox moduleHBox6 = new HBox();
			HBox moduleHBox7 = new HBox();
			HBox moduleHBox8 = new HBox();
			HBox moduleHBox9 = new HBox();
			HBox moduleHBox10 = new HBox();

			// Details Tab
			VBox detailVBox = new VBox();
			HBox detailHBox1 = new HBox();
			HBox detailHBox2 = new HBox();
			HBox detailHBox3 = new HBox();

			// Buttons & Button Labels
			Button addBTN = new Button();
			addBTN.setText("Add");
			Button rmBTN = new Button();
			rmBTN.setText("Remove");
			Button lsBTN = new Button();
			lsBTN.setText("List Contents");
			Button loadBTN = new Button();
			loadBTN.setText("Load");
			Button saveBTN = new Button();
			saveBTN.setText("Save");
			Button exitBTN = new Button();
			exitBTN.setText("Exit");
			Button modGradesAdd = new Button();
			modGradesAdd.setText("Add");
			Button modGradesSave = new Button();
			modGradesSave.setText("Save");
			Button modGradesUpdate = new Button();
			modGradesUpdate.setText("Refresh");
			Button studDetailsUpdate = new Button();
			studDetailsUpdate.setText("Refresh");
			Button loadModulesBTN = new Button();
			loadModulesBTN.setText("Load");
			Button modulesExitBTN = new Button();
			modulesExitBTN.setText("Exit");
			Button detailsExitBTN = new Button();
			detailsExitBTN.setText("Quit");

			// Labels
			Label studNameLabel = new Label("Enter Name ");
			Label idLabel = new Label("Enter Student ID ");
			Label dobLabel = new Label("Date of Birth");
			Label moduleNameLabel = new Label("Module Name");
			Label moduleStudentLabel = new Label("Students ");
			Label moduleGradeLabel = new Label("Grade");
			Label studRecordLabel = new Label("Details (click refresh)");
			Label statusTextField = new Label();

			// Tabs
			Tab studentsTab = new Tab("Students");
			studentsTab.setClosable(false);
			Tab modulesTab = new Tab("Modules");
			modulesTab.setClosable(false);
			Tab detailsTab = new Tab("Student Records");
			detailsTab.setClosable(false);

			// Text Fields
			TextField nameTextField = new TextField();
			TextField idEntryField = new TextField();
			TextField studName1Entry = new TextField();
			TextField studName2Entry = new TextField();
			TextField studName3Entry = new TextField();
			TextField name4TextField = new TextField();
			TextField studName4Entry = new TextField();
			TextField studName5Entry = new TextField();
			TextField grade1Entry = new TextField();
			TextField grade2Entry = new TextField();
			TextField grade3Entry = new TextField();
			TextField grade4TextField = new TextField();
			TextField grade4Entry = new TextField();
			TextField grade5Entry = new TextField();

			nameTextField.setEditable(true);
			idEntryField.setEditable(true);

			// Prompt text
			studName1Entry.setPromptText("Module 1");
			studName2Entry.setPromptText("Module 2");
			studName3Entry.setPromptText("Module 3");
			name4TextField.setPromptText("Module 4");
			studName4Entry.setPromptText("Module 5");
			studName5Entry.setPromptText("Module 6");

			// Date Selector for DOB
			DatePicker datePicker = new DatePicker();
			datePicker.setEditable(true);

			// Modules Drop Down Menu
			ComboBox<String> listOfStudents = new ComboBox<>();
			ObservableList<String> studentsNames = cont.dropDown();
			for (int i = 0; i < cont.studentList.size(); i++) {
				listOfStudents.setItems(studentsNames);
			}

			// Drop Down Menu - Tab 3 (Student Details)
			ComboBox<String> listOfStudentsForGrades = new ComboBox<>();
			for (int j = 0; j < cont.studentList.size(); j++) {
				listOfStudentsForGrades.setItems(studentsNames);
			}

			// Text Area
			TextArea studDetails = new TextArea();
			TextArea detailsTextArea = new TextArea();
			studDetails.setEditable(false);
			detailsTextArea.setEditable(false);
			detailsTextArea.setPromptText("Click a student from the dropdown and you'll see their information!");

			// VBox 1
			VBox.setSpacing(5);
			VBox.setPadding(new Insets(25));
			VBox.getChildren().addAll(HBox1, HBox2, HBox3, HBox4, HBox5, HBox6);

			/*
			 * Student Tab View
			 * 
			 */

			// Enter name - Hbox 1
			HBox1.getChildren().addAll(studNameLabel, nameTextField);
			HBox1.setPadding(new Insets(0, 0, 0, 0));

			// Enter Student ID - HBox2
			HBox2.getChildren().addAll(idLabel, idEntryField);

			// Enter DOB - HBox3
			HBox3.getChildren().addAll(dobLabel, datePicker);

			// The "Add", "Remove", and "List" buttons - HBox4
			HBox4.getChildren().addAll(addBTN, rmBTN, lsBTN);
//			rmBTN.setDisable(true); // disabling remove button from the start which will prevent any removing out of bounds

			// Text area that will populate with student details - HBox5
			HBox5.getChildren().addAll(studDetails);
			studDetails.setPromptText("Student details will print here.");
			studDetails.setEditable(false);
			studDetails.autosize();

			// "Load", "Save", "Exit" buttons - Hbox6
			HBox6.getChildren().addAll(loadBTN, saveBTN, exitBTN);

			// spacing for them
			HBox1.setSpacing(5);
			HBox2.setSpacing(5);
			HBox3.setSpacing(5);
			HBox4.setSpacing(5);
			HBox5.setSpacing(5);
			HBox6.setSpacing(10);
			HBox6.setAlignment(Pos.BASELINE_LEFT);

			// Tab Pane
			tabPane.getTabs().addAll(studentsTab, modulesTab, detailsTab);

			/*
			 * ------------------- Module Tab View ----------------------
			 */

			// Modules Layout
			moduleVBox.setSpacing(10);
			moduleVBox.setPadding(new Insets(30));
			moduleVBox.getChildren().addAll(moduleHBox1, moduleHBox2, moduleHBox3, moduleHBox4, moduleHBox5,
					moduleHBox6, moduleHBox7, moduleHBox8, moduleHBox9, moduleHBox10);

			moduleHBox1.setPadding(new Insets(0, 0, 20, 0));

			// module label for student, dropdown and update buttons
			moduleHBox1.getChildren().addAll(moduleStudentLabel, listOfStudents, modGradesUpdate);

			// module name label, module grade label

			moduleHBox2.getChildren().addAll(moduleNameLabel, moduleGradeLabel);

			// student details labels
			moduleHBox3.getChildren().addAll(studName1Entry, grade1Entry);
			moduleHBox4.getChildren().addAll(studName2Entry, grade2Entry);
			moduleHBox5.getChildren().addAll(studName3Entry, grade3Entry);
			moduleHBox7.getChildren().addAll(studName4Entry, grade4Entry);
			moduleHBox8.getChildren().addAll(studName5Entry, grade5Entry);
			moduleHBox9.getChildren().addAll(statusTextField);

			// buttons
			moduleHBox10.getChildren().addAll(modGradesAdd, modGradesSave, loadModulesBTN, modulesExitBTN);

			// spacing for them
			moduleHBox1.setSpacing(10);
			moduleHBox2.setSpacing(10);
			moduleHBox3.setSpacing(10);
			moduleHBox4.setSpacing(10);
			moduleHBox5.setSpacing(10);
			moduleHBox6.setSpacing(10);
			moduleHBox7.setSpacing(10);
			moduleHBox8.setSpacing(10);
			moduleHBox9.setSpacing(10);
			moduleHBox10.setSpacing(10);
			moduleHBox6.getChildren().addAll(name4TextField, grade4TextField);

			// Details Layout
			detailVBox.setSpacing(10);
			detailVBox.setPadding(new Insets(30));
			detailVBox.getChildren().addAll(detailHBox1, detailHBox2, detailHBox3);

			// HBox 1 - 3
			detailHBox1.setSpacing(10);
			detailHBox1.getChildren().addAll(studRecordLabel, listOfStudentsForGrades, studDetailsUpdate);
			detailHBox2.setSpacing(10);
			detailHBox2.getChildren().addAll(detailsTextArea);
			detailHBox3.setSpacing(10);
			detailHBox3.getChildren().addAll(detailsExitBTN);

			group.getChildren().addAll(tabPane);

			// Students Tab
			studentsTab.setContent(VBox);

			// Modules Tab
			modulesTab.setContent(moduleVBox);

			// Details Tab
			detailsTab.setContent(detailVBox);

			// Setting the scene
			Scene scene = new Scene(group, 600, 500);
			primaryStage.setScene(scene);

			/*
			 * All Button Handlers
			 */

			/**
			   *
			   * This handler gets the student name, ID and DOB and then
			   * does an error check using a flag to return messages
			   * that might warn of an error
			   *
			   *
			*/
			addBTN.setOnAction(e -> {

				String studentName = nameTextField.getText();
				String studentID = idEntryField.getText().toUpperCase();
				String studentDOB = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

				try {
					// handling error inputs
					int flag = cont.studDetailsErrorCheck(studentName, studentID, studentDOB);
					if (flag == 0) {
						studDetails.setPromptText("General Error");
					};

					if (flag == 1) {
						cont.addStudentInfo(studentName, studentID, studentDOB);
						studDetails.setPromptText("Submitted");
					};

					if (flag == 2) {
						studDetails.setPromptText("Input error. Names must be over 1 char long and ID must start with R");
					};

					if (flag == 3) {
						studDetails.setText("Blank input somewhere");
					};

				}

				catch (NullPointerException nullP) {
					studDetails.setText("General error");
				}
			});

			/**
			   *
			   * This handler removes the student ID
			   *
			   *
			*/			
			rmBTN.setOnAction(e -> {

				String studentID = idEntryField.getText().toUpperCase();
				studDetails.setText(cont.rmStudents(studentID));

			});

			/**
			   *
			   * This handler for the list button lists the student information
			   *
			   *
			*/				
			
			lsBTN.setOnAction(e -> {
				try {
					String tab = "\t\t\t";
					String addedStudents = cont.listStudents();
					String title = "Student Name" + tab + "Student ID" + tab + "Student DOB\n\n";
					studDetails.setText(title + addedStudents.toString());
				} catch (Exception e1) {
					System.out.println("List Error");
				}

			});

			/**
			   *
			   * This handler for the save button lists the student information
			   *
			   *
			*/		
			
			saveBTN.setOnAction(e -> {
				try {
					studDetails.setText(cont.saveFile());
				} catch (Exception e2) {
					System.out.println("Saving Error");
				}
			});

			/**
			   *
			   * This handler for the load button
			   *
			   *
			*/				
			
			loadBTN.setOnAction(e -> {
				cont.loadFile();
				studDetails.setPromptText("Loaded");

			});

			/**
			 * 
			 * Update button handler that is needed to refresh the student list in the dropdown in module tab
			 */
			
			modGradesUpdate.setOnAction(e -> {
				ObservableList<String> names = cont.dropDown();
				int x = 0;
				for (x = 0; x < cont.studentList.size(); x++) {
					listOfStudents.setItems(names);
				}
			});

			/**
			 * 
			 * Update button handler that is needed to refresh the student list in the dropdown in student tab
			 */
			studDetailsUpdate.setOnAction(e -> {
				ObservableList<String> names = cont.dropDown();
				int x = 0;
				for (x = 0; x < cont.studentList.size(); x++) {
					listOfStudentsForGrades.setItems(names);
				}
			});

			/**
			 * 
			 * Load button handler for module tab
			 */
			
			loadModulesBTN.setOnAction(e -> {
				try {
					cont.loadModulesFile();
					statusTextField.setText("Loaded Modules");
				} catch (Exception loadModuleError) {
					System.out.println("Load Error");

				}
			});
			/**
			 * 
			 * Load button handler for module tab
			 */
			modGradesAdd.setOnAction(e -> {

				int grade1 = Integer.parseInt(grade1Entry.getText());
				int mod1len = studName1Entry.getLength();
				String module1 = studName1Entry.getText();
				int grade2 = Integer.parseInt(grade2Entry.getText());
				int mod2len = studName2Entry.getLength();
				String module2 = studName2Entry.getText();
				int grade3 = Integer.parseInt(grade3Entry.getText());
				int mod3len = studName3Entry.getLength();
				String module3 = studName3Entry.getText();
				int mod4len = name4TextField.getLength();
				int grade4 = Integer.parseInt(grade4TextField.getText());
				String module4 = name4TextField.getText();
				int grade5 = Integer.parseInt(grade4Entry.getText());
				int mod5len = studName4Entry.getLength();
				String module5 = studName4Entry.getText();
				int mod6len = studName5Entry.getLength();
				int grade6 = Integer.parseInt(grade5Entry.getText());
				String module6 = studName5Entry.getText();
				String name = listOfStudents.getValue();

				if (mod1len != 0 && mod2len != 0 && mod3len != 0 && mod4len != 0 && mod5len != 0 && mod6len != 0) {
					if (grade1 >= 0 && grade1 <= 100 && grade2 >= 0 && grade2 <= 100 && grade3 >= 0 && grade3 <= 100
							&& grade4 >= 0 && grade4 <= 100 && grade5 >= 0 && grade5 <= 100 && grade6 >= 0
							&& grade6 <= 100) 
					{
						for (int i = 0; i < cont.studentList.size(); i++) {
							if (cont.studentList.get(i).getStudentName() == name) {
								String studentID = cont.studentList.get(i).getStudentID();

								cont.saveModules(studentID, module1, module2, module3, module4, module5, module6,
										grade1, grade2, grade3, grade4, grade5, grade6);

								statusTextField.setText("Updated");
							}
						}
					} else {
						statusTextField.setText("Bad grade input");
					}
				} else {
					statusTextField.setText("Please insert a module");
				}
			});

			
			/**
			 * 
			 * Student list for grades
			 * 
			 */				
			
			listOfStudentsForGrades.setOnAction((event) -> {
				for (int i = 0; i < cont.studentList.size(); i++) {
					if (cont.studentList.get(i).getStudentName() == listOfStudentsForGrades.getSelectionModel().getSelectedItem()) 
					{
						detailsTextArea.setText(cont.listModulesGrades(listOfStudentsForGrades.getSelectionModel().getSelectedIndex()).toString());
					}
				}

			});

			/**
			 * 
			 * Module save button handler
			 * 
			 */	
			
			modGradesSave.setOnAction(e -> {
				try {
					statusTextField.setText(cont.saveModulesFile());
				} catch (Exception saveE) {
					saveE.printStackTrace();
				}
			});

			/**
			 * 
			 * Exit button handler students tab
			 * 
			 */		
			
			exitBTN.setOnAction(e -> {
				try {
					Alert saveDialog = new Alert(AlertType.WARNING, "All unsaved progress will be lost!",
							ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
					saveDialog.setTitle("Exit Program");
					saveDialog.setHeaderText("Make sure to save before closing! Do you want to exit?");

					Optional<ButtonType> option = saveDialog.showAndWait();
					if (option.get() == ButtonType.YES) {
						cont.saveFile();
						System.exit(0);
					} else if (option.get() == ButtonType.NO) {
						System.exit(0);
					} else if (option.get() == ButtonType.CANCEL) {
						saveDialog.close();
					}
				} catch (Exception d) {
					System.out.println("What did you do?");
					d.printStackTrace();
				}
			});

			/**
			 * 
			 * Exit button handler modules tab
			 * 
			 */				
			
			modulesExitBTN.setOnAction(e -> {
				try {
					Alert saveDialog = new Alert(AlertType.WARNING, "All unsaved progress will be lost!",
							ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
					saveDialog.setTitle("Exit Program");
					saveDialog.setHeaderText("Make sure to save before closing! Do you want to exit?");

					Optional<ButtonType> option = saveDialog.showAndWait();
					if (option.get() == ButtonType.YES) {
						cont.saveFile();
						System.exit(0);
					} else if (option.get() == ButtonType.NO) {
						System.exit(0);
					} else if (option.get() == ButtonType.CANCEL) {
						saveDialog.close();
					}
				} catch (Exception a) {
					System.out.println("What did you do?");
					a.printStackTrace();
				}
			});
			
			/**
			 * 
			 * Exit button handler - student records tab
			 * 
			 */				
			
			detailsExitBTN.setOnAction(e -> {
				try {
					Alert saveDialog = new Alert(AlertType.WARNING, "All unsaved progress will be lost!",
							ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
					saveDialog.setTitle("Exit Program");
					saveDialog.setHeaderText("Make sure to save before closing! Do you want to exit?");

					Optional<ButtonType> option = saveDialog.showAndWait();
					if (option.get() == ButtonType.YES) {
						cont.saveFile();
						System.exit(0);
					} else if (option.get() == ButtonType.NO) {
						System.exit(0);
					} else if (option.get() == ButtonType.CANCEL) {
						saveDialog.close();
					}
				} catch (Exception z) {
					System.out.println("What did you do?");
					z.printStackTrace();
				}
			});

		} catch (Exception e) {
			System.out.println("Application Error");
			e.printStackTrace();
		}
	}


}
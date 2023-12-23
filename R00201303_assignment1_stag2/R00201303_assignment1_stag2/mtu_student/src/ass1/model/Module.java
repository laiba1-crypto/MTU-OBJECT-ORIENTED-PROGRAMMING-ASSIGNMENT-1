package ass1.model;

import java.io.Serializable;



public class Module implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String studentID, modName1, modName2, modName3, modName4, modName5, modName6;
	private int modGrade1, modGrade2, modGrade3, modGrade4, modGrade5, modGrade6;


	public Module(String studentID, 
			String moduleName1, 
			String moduleName2, 
			String moduleName3, 
			String moduleName4, 
			String moduleName5, 
			String moduleName6, 
			
			int moduleGrade1, 
			int moduleGrade2, 
			int moduleGrade3, 
			int moduleGrade4, 
			int moduleGrade5, 
			int moduleGrade6) 
	{
		this.studentID = studentID;
		this.modName1 = moduleName1;
		this.modName2 = moduleName2;
		this.modName3 = moduleName3;
		this.modName4 = moduleName4;
		this.modName5 = moduleName5;
		this.modName6 = moduleName6;
		this.modGrade1 = moduleGrade1;
		this.modGrade2 = moduleGrade2;
		this.modGrade3 = moduleGrade3;
		this.modGrade4 = moduleGrade4;
		this.modGrade5 = moduleGrade5;
		this.modGrade6 = moduleGrade6;
	}

	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}


	//Names
	public String getModule1() {
		return modName1;
	}
	public void setModuleName1(String moduleName1) {
		this.modName1 = moduleName1;
	}
	public String getmodule2() {
		return modName2;
	}
	public void setModuleName2(String moduleName2) {
		this.modName2 = moduleName2;
	}
	public String getModule3() {
		return modName3;
	}
	public void setModuleName3(String moduleName3) {
		this.modName3 = moduleName3;
	}
	public String getModule4() {
		return modName4;
	}
	public void setModuleName4(String moduleName4) {
		this.modName4 = moduleName4;
	}
	public String getModule5() {
		return modName5;
	}
	public void setModuleName5(String moduleName5) {
		this.modName5 = moduleName5;
	}
	public String getModule6() {
		return modName6;
	}
	public void setModuleName6(String moduleName6) {
		this.modName6 = moduleName6;
	}


	//Grades
	public int getGrade1() {
		return modGrade1;
	}
	public void setModuleGrade1(int moduleGrade1) {
		this.modGrade1 = moduleGrade1;
	}
	public int getGrade2() {
		return modGrade2;
	}
	public void setModuleGrade2(int moduleGrade2) {
		this.modGrade2 = moduleGrade2;
	}
	public int getGrade3() {
		return modGrade3;
	}
	public void setModuleGrade3(int moduleGrade3) {
		this.modGrade3 = moduleGrade3;
	}
	public int getGrade4() {
		return modGrade4;
	}
	public void setModuleGrade4(int moduleGrade4) {
		this.modGrade4 = moduleGrade4;
	}
	public int getGrade5() {
		return modGrade5;
	}
	public void setModuleGrade5(int moduleGrade5) {
		this.modGrade5 = moduleGrade5;
	}
	public int getGrade6() {
		return modGrade6;
	}
	public void setModuleGrade6(int moduleGrade6) {
		this.modGrade6 = moduleGrade6;
	}
	
	
}

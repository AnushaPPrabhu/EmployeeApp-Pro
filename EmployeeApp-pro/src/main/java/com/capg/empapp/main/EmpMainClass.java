package com.capg.empapp.main;

import java.util.Scanner;

import com.capg.empapp.db.EmployeeDB;
import com.capg.empapp.dto.Employee;
import com.capg.empapp.service.EmployeeServiceImpl;
import com.capg.empapp.service.IEmployeeService;

public class EmpMainClass {

	IEmployeeService empService = new EmployeeServiceImpl();

	public static void main(String[] args) {

		EmpMainClass app = new EmpMainClass();
		Scanner sc = new Scanner(System.in);

		Employee arr[] = new Employee[50];

		System.out.println(" === MENU ==== ");
		System.out.println("1. Add employee ");
		System.out.println("2. Edit Employee ");
		System.out.println("3. Display All Employee ");
		System.out.println("4. Display Employee based on salary ");
		System.out.println("5. Display Employee based on salary range");
		System.out.println("6. Display Employee based on Experience");
		System.out.println("7. Display Employee based on Experience range");
		System.out.println("0. EXIT");

		while (true) {
			System.out.println("Enter Option");
			int option = sc.nextInt();
			int n = 0;

			EmployeeDB e1 = new EmployeeDB();
			int count = e1.getCount();

			switch (option) {

			case 1:

				System.out.println("Enter the no of employee you want to add");
				n = sc.nextInt();

				count = n;
				// System.out.println("Count is " + n);
				for (int i = 0; i < n; i++) {
					arr[i] = new Employee();
					System.out.println("Enter id of employee");
					arr[i].setEmployeeId(sc.nextInt());
					System.out.println("Enter the name of the person");
					arr[i].setName(sc.next());
					System.out.println("Enter the exp");
					int exp = sc.nextInt();
					arr[i].setExp(exp);
					System.out.println("Enter the salary");
					int salary = sc.nextInt();
					arr[i].setSalary(salary);

					Employee e = new Employee(arr[i].getEmployeeId(), arr[i].getName(), arr[i].getExp(),
							arr[i].getSalary());

					try {
						boolean isInserted = app.empService.addEmployee(e);
						if (isInserted) {
							System.out.println("Employee Added.");
						} else {
							throw new Exception("Cannot add Employee.");
						}
					} catch (Exception ex) {
						System.out.println("Contact to Customer Care. " + ex);
					}

				}
				break;

			case 2:

				System.out.println("Enter the id of the employee");
				int id = sc.nextInt();
				// System.out.println("Id is" + id);
				// System.out.println("changing salary");
				for (int j = 0; j < count; j++) {

					// System.out.println("Inside for loop");
					int empid = arr[j].getEmployeeId();
					// System.out.println("Emp id is" + empid);
					if (empid == id) {
						System.out.println("Enter the new salary");
						arr[j].setSalary(sc.nextInt());
					}
				}

				for (int i = 0; i < count; i++) {
					int empid = arr[i].getEmployeeId();
					if (empid == id) {
						Employee e = new Employee(arr[i].getEmployeeId(), arr[i].getName(), arr[i].getExp(),
								arr[i].getSalary());
						try {
							boolean isInserted = app.empService.editSalaryByEmployeeId(e);
							if (isInserted) {
								System.out.println("Employee Details Edited.");
							} else {
								throw new Exception("Cannot edit Employee.");
							}
						} catch (Exception ex) {
							System.out.println(" Contact to Customer Care. " + ex);
						}

					}
				}

				break;

			case 3:

				System.out.println("Displaying all emp details");
				System.out.println("Name " + "\t" + "Salary" + "\t" + "Experience");
				// System.out.println(count);
				for (int k = 0; k < count; k++) {
					System.out.println("Name is " + arr[k].getName() + "\n Salary is " + arr[k].getSalary()
							+ "\n Experience is " + arr[k].getExp());
				}
				break;

			case 4:

				System.out.println("Enter the salary you want to refer");
				int sal = sc.nextInt();
				for (int t = 0; t < count; t++) {
					int c = arr[t].getSalary();
					if (c == sal) {
						System.out.println("Name- " + arr[t].getName() + " Salary- " + arr[t].getSalary());
					}
				}
				break;

			case 5:
				System.out.println("Enter the salary range");
				System.out.println("Enter the min sal");
				int a = sc.nextInt();
				System.out.println("Enter the max salary");
				int b = sc.nextInt();
				for (int i = 0; i < count; i++) {
					int t = arr[i].getSalary();
					if (t >= a && t <= b) {
						System.out.println("Name- " + arr[i].getName() + " Salary- " + arr[i].getSalary());
					}
				}
				break;

			case 6:

				System.out.println("Enter the experience you want to refer");
				int exp = sc.nextInt();
				// System.out.println(exp);
				// System.out.println(count);
				for (int t = 0; t < count; t++) {
					// System.out.println("Inside for loop");
					int expCheck = arr[t].getExp();
					// System.out.println(salCheck);
					if (expCheck == exp) {
						System.out.println(arr[t].getName() + "  " + arr[t].getExp() + "  " + arr[t].getSalary());
					}
				}
				break;

			case 7:
				System.out.println("Enter the experience range");
				System.out.println("Enter the min experience");
				a = sc.nextInt();
				System.out.println("Enter the max experience");
				b = sc.nextInt();
				for (int i = 0; i < count; i++) {
					int t = arr[i].getExp();
					if (t >= a && t <= b) {
						System.out.println(arr[i].getName() + " " + " " + arr[i].getExp() + " " + arr[i].getSalary());
					}
				}
				break;
			case 0:
				System.exit(0);

			}// end switch

		} // end while

	}// end main

}// end class
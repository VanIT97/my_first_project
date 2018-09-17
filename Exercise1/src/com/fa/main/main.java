package com.fa.main;

import java.util.Scanner;

import com.fa.service.ComputerService;
import com.fa.service.ManagerService;

/**
 * @author du du
 * this class contain gui interface of user
 */
public class main {
	private static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		ComputerService computerService=new ComputerService();
		ManagerService managerManagement=new ManagerService();
		System.out.println("Start program!");
		int select;
		do {
			System.out.println("1.Create a manager!");
			System.out.println("2.Add a computer!");
			System.out.println("3.Display all computer sort by Id!");
			System.out.println("4.Delete a Computer!");
			System.out.println("5.Add a computer into manager!");
			System.out.println("6.Display all computer by id !");
			select=sc.nextInt();
			switch (select) {
			case 1:
				managerManagement.inputManager();
				break;
			case 2:
				computerService.inputComputer();
				break;
			case 3:
				computerService.displayAllComputerSortById();
				break;
			case 4:
				int selectDelete;
				do {
					System.out.println("1.delete by IdComputer!");
					System.out.println("2.delete by name of manager!");
					selectDelete=sc.nextInt();
					if(selectDelete!=1 && selectDelete!=2) {
						System.out.println("please choose 1 or 2 to delete!");
					}
				} while (selectDelete!=1 && selectDelete!=2);
				if(selectDelete==1) {
					computerService.deleteComputerById();
				}else {
					computerService.deleteAllComputerOfManager();
				}
				break;
			case 5:
				computerService.addComputerInManager();
				break;
			case 6:
				computerService.displayAllComputerSortById();
				break;
			default:
				break;
			}
		} while (select>1 && select<7);
	}
}

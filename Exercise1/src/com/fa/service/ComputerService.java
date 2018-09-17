package com.fa.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.fa.dao.ComputerDao;
import com.fa.dao.ManagerDao;
import com.fa.entity.Computer;
import com.fa.entity.Manager;
import com.fa.utils.ValidationData;

/**
 * @author du du provide many bussiness logic funtions related Object computer
 */
public class ComputerService {
	private ComputerDao computerDao;
	private ManagerDao managerDao;
	Scanner sc = new Scanner(System.in);

	public ComputerService() {
		computerDao = new ComputerDao();
		managerDao = new ManagerDao();
	}

	/**
	 * create a computer and save into file
	 */
	public void inputComputer() {
		Computer computer = new Computer();
		int id;
		do {
			System.out.println("id:");
			id = sc.nextInt();
			computer.setId(id);
			if (!ValidationData.checkIdOfComputer(id)) {
				System.out.println("please input id follow the format!");
			}
			if (computerDao.findAllComputer().contains(computer)) {
				System.out.println("id already exist!");
			}
		} while (!ValidationData.checkIdOfComputer(id) || computerDao.findAllComputer().contains(computer));
		System.out.println("screen:");
		computer.setScreen(sc.nextLine());
		System.out.println("case:");
		computer.setCaseCdn(sc.nextLine());
		String location;
		do {
			System.out.println("location:");
			location = sc.nextLine();
			computer.setLocation(location);
			if (!ValidationData.checkLocationOfComputer(location)) {
				System.out.println("please input location follow the format!");
			}
		} while (!ValidationData.checkLocationOfComputer(location));
		System.out.println("note");
		computer.setNote(sc.nextLine());
		computerDao.saveComputer(computer);
	}

	/**
	 * display all computer from file sort by Id
	 */
	public void displayAllComputerSortById() {
		Collections.sort(computerDao.findAllComputer(), new Comparator<Computer>() {
			@Override
			public int compare(Computer o1, Computer o2) {
				return o1.getId() > o2.getId() ? 1 : -1;
			}
		});
		for (Computer computer : computerDao.findAllComputer()) {
			System.out.println(computer.toString());
		}
	}

	/**
	 * delete a computer from file
	 */
	public void deleteComputerById() {
		Computer computer = new Computer();
		int id;
		do {
			System.out.println("id:");
			id = sc.nextInt();
			computer.setId(id);
			if (!ValidationData.checkIdOfComputer(id)) {
				System.out.println("please input id follow the format!");
			}
			if (!computerDao.findAllComputer().contains(computer)) {
				System.out.println("id don't exist!");
			}
		} while (!ValidationData.checkIdOfComputer(id) || !computerDao.findAllComputer().contains(computer));
		computerDao.deleteComputerById(id);
	}

	/**
	 * delete a list computer by input name manager and update into file
	 */

	public void deleteAllComputerOfManager() {
		Manager manager = new Manager();
		String account;
		do {
			System.out.println("account of manager:");
			account = sc.nextLine();
			manager.setAccount(account);
			if (!this.managerDao.findAllManager().contains(manager)) {
				System.out.println("manager don't exist!");
			}
		} while (!this.managerDao.findAllManager().contains(manager));
		int index = managerDao.findAllManager().indexOf(manager);
		manager = managerDao.findAllManager().get(index);
		manager.setListComputer(new ArrayList<>());
		for (Computer computer : manager.getListComputer()) {
			this.computerDao.deleteComputerById(computer.getId());
		}
		managerDao.updateManager(manager);
	}

	/**
	 * display computer by input id from keyboard
	 */
	public void displayComputerById() {
		Computer computer = new Computer();
		int id;
		do {
			System.out.println("id:");
			id = sc.nextInt();
			computer.setId(id);
			if (!ValidationData.checkIdOfComputer(id)) {
				System.out.println("please input id follow the format!");
			}
			if (!computerDao.findAllComputer().contains(computer)) {
				System.out.println("id don't exist!");
			}
		} while (!ValidationData.checkIdOfComputer(id) || !computerDao.findAllComputer().contains(computer));
		computer = computerDao.findComputerById(id);
		System.out.println(computer.toString());
	}

	/**
	 * add a computer into a manager and update into file manager
	 */
	public void addComputerInManager() {
		Manager manager = new Manager();
		String account;
		do {
			System.out.println("account of manager:");
			account = sc.nextLine();
			manager.setAccount(account);
			if (!this.managerDao.findAllManager().contains(manager)) {
				System.out.println("manager don't exist!");
			}
		} while (!this.managerDao.findAllManager().contains(manager));
		int index = managerDao.findAllManager().indexOf(manager);
		manager = managerDao.findAllManager().get(index);
		Computer computer = new Computer();
		int id;
		List<Computer> listComputerOfManager = manager.getListComputer();
		do {
			System.out.println("id:");
			id = sc.nextInt();
			computer.setId(id);
			if (!ValidationData.checkIdOfComputer(id)) {
				System.out.println("please input id follow the format!");
			}
			if (!this.computerDao.findAllComputer().contains(computer)) {
				System.out.println("id don't exist!");
			}
			if (listComputerOfManager.contains(computer)) {
				System.out.println("id of computer aready exist in manager!");
			}
		} while (!ValidationData.checkIdOfComputer(id) || !this.computerDao.findAllComputer().contains(computer)
				|| listComputerOfManager.contains(computer));
		listComputerOfManager.remove(computer);
		manager.setListComputer(listComputerOfManager);
		managerDao.updateManager(manager);
		computerDao.deleteComputerById(id);
	}

}

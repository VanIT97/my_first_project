package com.fa.service;

import java.util.Scanner;

import com.fa.common.DataCommon;
import com.fa.dao.ManagerDao;
import com.fa.entity.Manager;
import com.fa.utils.ValidationData;

public class ManagerService {
	private ManagerDao managerDao;
	Scanner sc = new Scanner(System.in);

	public ManagerService() {
		managerDao=new ManagerDao();
	}

	/**
	 * create a manager and save into file manager.txt
	 */
	public void inputManager() {
		Manager manager = new Manager();
		System.out.println("account:");
		manager.setAccount(sc.nextLine());
		System.out.println("name:");
		manager.setName(sc.nextLine());
		System.out.println("choosen gender:");
		int index = 1;
		int select = 0;
		do {
			for (DataCommon.Gender gender : DataCommon.Gender.values()) {
				System.out.println((index++) + ":" + gender);
			}
			select = sc.nextInt();
		} while (select < 0 || select > DataCommon.Gender.values().length);
		manager.setGender(DataCommon.Gender.values()[select].toString());
		managerDao.createManager(manager);
	}
}

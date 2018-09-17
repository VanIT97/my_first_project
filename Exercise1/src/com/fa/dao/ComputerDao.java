package com.fa.dao;

import java.util.ArrayList;
import java.util.List;

import com.fa.data.FileIO;
import com.fa.entity.Computer;
import com.fa.entity.Manager;

public class ComputerDao {
	private List<Computer> listComputer = new ArrayList<>();

	@SuppressWarnings("unchecked")
	public ComputerDao() {
		if (FileIO.checkData(FileIO.FILE_COMPUTER)) {
			listComputer = (List<Computer>) FileIO.readFile(FileIO.FILE_COMPUTER);
		}
	}

	/**
	 * create a computer and save into file
	 */
	public void saveComputer(Computer computer) {
		listComputer.add(computer);
		FileIO.saveFile(listComputer, FileIO.FILE_COMPUTER);
	}

	/**
	 * find all computer from file
	 */
	public List<Computer> findAllComputer() {
		return listComputer;
	}

	/**
	 * delete a computer from file
	 */
	public void deleteComputerById(int id) {
		Computer computer = new Computer();
		computer.setId(id);
		listComputer.remove(computer);
		FileIO.saveFile(listComputer, FileIO.FILE_COMPUTER);
		Manager manager = (Manager) FileIO.readFile(FileIO.FILE_MANAGER);
		List<Computer> listComputerOfManager = manager.getListComputer();
		if (listComputerOfManager.contains(computer)) {
			int index = listComputerOfManager.indexOf(computer);
			listComputerOfManager.remove(index);
			manager.setListComputer(listComputerOfManager);
			FileIO.saveFile(manager, FileIO.FILE_MANAGER);
		}
	}

	/**
	 * find computer by id from file
	 */
	public Computer findComputerById(int id) {
		Computer computer = new Computer();
		computer.setId(id);
		computer = this.listComputer.get(this.listComputer.indexOf(computer));
		return computer;
	}

	/**
	 * update a computer
	 */
	public void updateComputer(Computer computer) {
		int index = this.listComputer.indexOf(computer);
		this.listComputer.set(index, computer);
		FileIO.saveFile(listComputer, FileIO.FILE_COMPUTER);
	}
}

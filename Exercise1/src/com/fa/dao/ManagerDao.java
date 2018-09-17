package com.fa.dao;

import java.util.ArrayList;
import java.util.List;

import com.fa.data.FileIO;
import com.fa.entity.Manager;

public class ManagerDao {
	private List<Manager> listManager=new ArrayList<>();
	@SuppressWarnings("unchecked")
	public ManagerDao() {
		if (FileIO.checkData(FileIO.FILE_MANAGER)) {
			listManager = (List<Manager>) FileIO.readFile(FileIO.FILE_MANAGER);
		}
	}
	public void createManager(Manager manager) {
		this.listManager.add(manager);
		FileIO.saveFile(this.listManager, FileIO.FILE_MANAGER);
	}
	public List<Manager> findAllManager() {
		return this.listManager;
	}
	public void updateManager(Manager manager) {
		int index=listManager.indexOf(manager);
		this.listManager.set(index, manager);
		FileIO.saveFile(this.listManager, FileIO.FILE_MANAGER);
	}
}

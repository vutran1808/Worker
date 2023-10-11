/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dataAccess.WorkerDao;
import java.util.List;
import java.util.Map;
import model.SalaryStatus;
import model.Worker;

/**
 *
 * @author ASUS
 */
public class WorkerRes implements IWorkerRes {

    @Override
    public void getInformationSalary(Map<Worker, List<SalaryStatus>> listChange) {
        WorkerDao.Instance().showAll(listChange);
    }

    @Override
    public void addWorker(List<Worker> workerList) {
        WorkerDao.Instance().addWorker(workerList);
    }

    @Override
    public void changeSalary(List<Worker> workerList, List<SalaryStatus> salaryList, Map<Worker, List<SalaryStatus>> listChange, int type) {
        WorkerDao.Instance().adjustSalary(workerList, salaryList, listChange, type);
    }

}

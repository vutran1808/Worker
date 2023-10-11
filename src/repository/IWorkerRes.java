/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import java.util.Map;
import model.SalaryStatus;
import model.Worker;

/**
 *
 * @author ASUS
 */
public interface IWorkerRes {

    void addWorker(List<Worker> workerList);

    void changeSalary(List<Worker> workerList, List<SalaryStatus> salaryList, Map<Worker, List<SalaryStatus>> listChange, int type);

    void getInformationSalary(Map<Worker, List<SalaryStatus>> workerList);

}

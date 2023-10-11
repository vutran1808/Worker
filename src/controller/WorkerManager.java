/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.SalaryStatus;
import model.Worker;
import repository.IWorkerRes;
import repository.WorkerRes;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class WorkerManager extends Menu {

    IWorkerRes mn;
    private List<Worker> workerList;
    private List<SalaryStatus> salaryHistory;
    private Map<Worker, List<SalaryStatus>> workerSalary;
    static String[] mc = {"Add worker", "Up salary", "Down salary", "Display information salary", "Exit"};

    public WorkerManager() {
        super("Worker Managerment", mc);
        mn = new WorkerRes();
        workerList = new ArrayList<>();
        salaryHistory = new ArrayList<>();
        workerSalary = new HashMap<>();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> mn.addWorker(workerList);
            case 2 -> mn.changeSalary(workerList, salaryHistory, workerSalary, 1);            
            case 3 -> mn.changeSalary(workerList, salaryHistory, workerSalary, 2);
            case 4 -> mn.getInformationSalary(workerSalary);
            case 5 -> System.exit(0);
        }
    }

}

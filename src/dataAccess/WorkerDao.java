/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;

import common.ScannerFactory;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import model.SalaryStatus;
import model.Worker;

/**
 *
 * @author ASUS
 */
public class WorkerDao {

    private static WorkerDao instance = null;
    ScannerFactory sc;

    public WorkerDao() {
        sc = new ScannerFactory();
    }

    public static WorkerDao Instance() {
        if (instance == null) {
            synchronized (WorkerDao.class) {
                if (instance == null) {
                    instance = new WorkerDao();
                }
            }
        }
        return instance;
    }

    public void addWorker(List<Worker> workerList) {
        String code = sc.getCode();
        String name = sc.getString("Enter Name: ");
        int age = sc.getAge();
        double salary = sc.getDouble("Enter Salary: ");
        String location = sc.getString("Enter Work Location: ");
        if (workerList.add(new Worker(code, name, age, salary, location))) {
            System.out.println("Added");
        }
    }

    public void adjustSalary(List<Worker> workerList, List<SalaryStatus> salaryList, Map<Worker, List<SalaryStatus>> listChange, int type) throws ParseException {
        System.out.println("Adjust Salary");
        Worker worker = searchWorker(workerList);
        if (worker != null) {
            double currentSalary;
            double adSalary = sc.getDouble("Enter amount of money: ");
            Date date = sc.getDate();
            switch (type) {
                case 1 -> {
                    currentSalary = worker.getSalary() + adSalary;
                    worker.setSalary(currentSalary);
                    salaryList.add(new SalaryStatus("UP", date));
                    listChange.put(worker, salaryList);
                }
                case 2 -> {
                    currentSalary = worker.getSalary() - adSalary;
                    worker.setSalary(currentSalary);
                    salaryList.add(new SalaryStatus("DOWN", date));
                    listChange.put(worker, salaryList);
                }
            }
        } else {
            System.out.println("id not found");
        }

    }

    public Worker searchWorker(List<Worker> workerList) {
        String id = sc.getCode();
        return workerList.stream().filter(worker -> worker.getId().equals(id)).findAny().orElse(null);
    }

    public void showAll(Map<Worker, List<SalaryStatus>> listChange) {
        for (Worker w : listChange.keySet()) {
            listChange.get(w).forEach(salary -> {
                System.out.println(w.toString() + " Salary History: " + salary.toString());
            });
        }
    }

}

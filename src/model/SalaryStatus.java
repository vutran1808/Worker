/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class SalaryStatus{
    
    private String status;
    private Date date;

    public SalaryStatus(String status, Date date) {
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String formatDate(Date date) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(date);
    }
    
    @Override
    public String toString() {
        return "status=" + status + ", date=" + formatDate(date);
    }
    
    
}

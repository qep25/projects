/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author hasif
 */
public class calculatorProcess {
    int year;
    int constraints;
    boolean showdivmul;
    
    
    public calculatorProcess(){
        
    }

    public calculatorProcess(int year, int constraints, boolean showdivmul) {
        this.year = year;
        this.constraints = constraints;
        this.showdivmul = showdivmul;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getConstraints() {
        return constraints;
    }

    public void setConstraints(int constraints) {
        this.constraints = constraints;
    }

    public boolean isShowdivmul() {
        return showdivmul;
    }

    public void setShowdivmul(boolean showdivmul) {
        this.showdivmul = showdivmul;
    }
    
    
    
    
 
    
}

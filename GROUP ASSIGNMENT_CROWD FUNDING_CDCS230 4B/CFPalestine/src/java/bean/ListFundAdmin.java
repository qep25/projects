/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.*;
/**
 *
 * @author Haikal
 */
public class ListFundAdmin {
    int projId;
    String projName;
    String dateline;
    String projDesc;

    public ListFundAdmin(int projId, String projName, String dateline, String projDesc) {
        this.projId = projId;
        this.projName = projName;
        this.dateline = dateline;
        this.projDesc = projDesc;
    }

    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getDateline() {
        return dateline;
    }

    public void setDateline(String dateline) {
        this.dateline = dateline;
    }

    public String getProjDesc() {
        return projDesc;
    }

    public void setProjDesc(String projDesc) {
        this.projDesc = projDesc;
    }

    
    

    
    
    
}

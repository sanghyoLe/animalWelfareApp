package com.example.animal_project.Result;

public class EvaInfoData {
    private String evaInfoId;
    private String farmName;
    private String repName;
    private String farmType;
    private String evaName;
    private String evaDay;


    public String getSearchCowKind() {
        return searchCowKind;
    }

    public void setSearchCowKind(String searchCowKind) {
        this.searchCowKind = searchCowKind;
    }

    private String searchCowKind;

    public String getEvaDay() {
        return evaDay;
    }
    public void setEvaDay(String evaDay) {
        this.evaDay = evaDay;
    }
    public String getEvaInfoId() {
        return evaInfoId;
    }
    public String getFarmName() {
        return farmName;
    }
    public String getRepName() {
        return repName;
    }
    public String getFarmType(){
        return farmType;
    }
    public String getEvaName(){
        return evaName;
    }

    public void setEvaInfoId(String evaInfoId){
        this.evaInfoId = evaInfoId;
    }
    public void setFarmName(String farmName){
        this.farmName = farmName;
    }
    public void setRepName(String repName){
        this.repName =repName;
    }
    public void setFarmType(String farmType){
        this.farmType = farmType;
    }
    public void setEvaName(String evaName){
        this.evaName = evaName;
    }

}

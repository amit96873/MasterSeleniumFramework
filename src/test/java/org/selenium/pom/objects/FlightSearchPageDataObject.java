package org.selenium.pom.objects;

public class FlightSearchPageDataObject {
    private String source;
    private String destination;
    private String date;
    private String monthYear;
    private String adults;
    private String childs;
    private String infants;
    private String preferredAirlines;
    private String returnDate;
    private String returnMonthYear;
    private String title;
    private long waitTime;

    public FlightSearchPageDataObject(){

    }
    public FlightSearchPageDataObject(String source,String destination,String date,String monthYear,String adults, String childs,
                                      String infants, String preferredAirlines, String returnDate,
                                      String returnMonthYear,String title,long waitTime){
        this.source=source;
        this.destination=destination;
        this.date=date;
        this.monthYear=monthYear;
        this.adults=adults;
        this.childs=childs;
        this.infants=infants;
        this.preferredAirlines=preferredAirlines;
        this.returnDate=returnDate;
        this.returnMonthYear=returnMonthYear;
        this.title=title;
        this.waitTime=waitTime;

    }




    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(String monthYear) {
        this.monthYear = monthYear;
    }


    public String getAdults() {
        return adults;
    }

    public void setAdults(String adults) {
        this.adults = adults;
    }

    public String getChilds() {
        return childs;
    }

    public void setChilds(String childs) {
        this.childs = childs;
    }

    public String getInfants() {
        return infants;
    }

    public void setInfants(String infants) {
        this.infants = infants;
    }

    public String getPreferredAirlines() {
        return preferredAirlines;
    }

    public void setPreferredAirlines(String preferredAirlines) {
        this.preferredAirlines = preferredAirlines;
    }
    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnMonthYear() {
        return returnMonthYear;
    }

    public void setReturnMonthYear(String returnMonthYear) {
        this.returnMonthYear = returnMonthYear;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public long getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(long waitTime) {
        this.waitTime = waitTime;
    }

}

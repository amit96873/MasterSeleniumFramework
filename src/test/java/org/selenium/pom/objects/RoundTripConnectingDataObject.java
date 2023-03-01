package org.selenium.pom.objects;


public class RoundTripConnectingDataObject {

    private String userId;
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
    private String firstAdultTitle;
    private String adult1FirstName;
    private String adult1LastName;
    private String firstChildTitle;
    private String child1FirstName;
    private String child1LastName;
    private String firstInfantTitle;
    private String infant1FirstName;
    private String infant1LastName;
    private String infant1DOB;
    private String mobileNumber;
    private String email;
    private String amendmentsType;
    private int paxCountToSelectForAmendments;
    private String remarks;
    private String notes;
    private String reason;
    private String bookingStatus;
    private long waitTime;




    public RoundTripConnectingDataObject(){

    }
    public RoundTripConnectingDataObject(String userId,
                                  String source,
                                  String destination,
                                  String date,
                                  String monthYear,
                                  String adults,
                                  String childs,
                                  String infants,
                                  String preferredAirlines,
                                  String returnDate,
                                  String returnMonthYear,
                                  String adult1FirstName,
                                  String adult1LastName,
                                  String child1FirstName,
                                  String child1LastName,
                                  String infant1FirstName,
                                  String infant1LastName,
                                  String infant1DOB,
                                  String mobileNumber,
                                  String email,
                                  String amendmentsType,
                                  int paxCountToSelectForAmendments,
                                  String remarks,
                                  String notes,
                                  String reason,
                                  String bookingStatus,
                                  long waitTime,
                                  String firstAdultTitle,
                                  String firstChildTitle,
                                  String firstInfantTitle){
        this.source=source;
        this.destination=destination;
        this.date=date;
        this.monthYear=monthYear;
        this.adults = adults;
        this.childs = childs;
        this.infants = infants;
        this.preferredAirlines = preferredAirlines;
        this.returnDate = returnDate;
        this.returnMonthYear = returnMonthYear;
        this.adult1FirstName = adult1FirstName;
        this.adult1LastName = adult1LastName;
        this.child1FirstName = child1FirstName;
        this.child1LastName = child1LastName;
        this.infant1FirstName = infant1FirstName;
        this.infant1LastName = infant1LastName;
        this.infant1DOB = infant1DOB;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.amendmentsType = amendmentsType;
        this.paxCountToSelectForAmendments = paxCountToSelectForAmendments;
        this.remarks = remarks;
        this.notes = notes;
        this.reason = reason;
        this.bookingStatus = bookingStatus;
        this.waitTime = waitTime;
        this.firstAdultTitle = firstAdultTitle;
        this.firstChildTitle = firstChildTitle;
        this.firstInfantTitle = firstInfantTitle;
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


    public String getAdult1FirstName() {
        return adult1FirstName;
    }

    public void setAdult1FirstName(String adult1FirstName) {
        this.adult1FirstName = adult1FirstName;
    }

    public String getAdult1LastName() {
        return adult1LastName;
    }

    public void setAdult1LastName(String adult1LastName) {
        this.adult1LastName = adult1LastName;
    }

    public String getChild1FirstName() {
        return child1FirstName;
    }

    public void setChild1FirstName(String child1FirstName) {
        this.child1FirstName = child1FirstName;
    }

    public String getChild1LastName() {
        return child1LastName;
    }

    public void setChild1LastName(String child1LastName) {
        this.child1LastName = child1LastName;
    }

    public String getInfant1FirstName() {
        return infant1FirstName;
    }

    public void setInfant1FirstName(String infant1FirstName) {
        this.infant1FirstName = infant1FirstName;
    }

    public String getInfant1LastName() {
        return infant1LastName;
    }

    public void setInfant1LastName(String infant1LastName) {
        this.infant1LastName = infant1LastName;
    }

    public String getInfant1DOB() {
        return infant1DOB;
    }

    public void setInfant1DOB(String infant1DOB) {
        this.infant1DOB = infant1DOB;
    }


    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAmendmentsType() {
        return amendmentsType;
    }

    public void setAmendmentsType(String amendmentsType) {
        this.amendmentsType = amendmentsType;
    }

    public int getPaxCountToSelectForAmendments() {
        return paxCountToSelectForAmendments;
    }

    public void setPaxCountToSelectForAmendments(int paxCountToSelectForAmendments) {
        this.paxCountToSelectForAmendments = paxCountToSelectForAmendments;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public long getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(long waitTime) {
        this.waitTime = waitTime;
    }
    public String getFirstAdultTitle() {
        return firstAdultTitle;
    }

    public void setFirstAdultTitle(String firstAdultTitle) {
        this.firstAdultTitle = firstAdultTitle;
    }

    public String getFirstChildTitle() {
        return firstChildTitle;
    }

    public void setFirstChildTitle(String firstChildTitle) {
        this.firstChildTitle = firstChildTitle;
    }

    public String getFirstInfantTitle() {
        return firstInfantTitle;
    }

    public void setFirstInfantTitle(String firstInfantTitle) {
        this.firstInfantTitle = firstInfantTitle;
    }


}





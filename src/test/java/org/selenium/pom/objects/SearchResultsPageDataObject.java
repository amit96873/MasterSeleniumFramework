package org.selenium.pom.objects;

public class SearchResultsPageDataObject {


    private String title;


    public SearchResultsPageDataObject(){

        }
    public SearchResultsPageDataObject(String title){
      this.title=title;
       }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

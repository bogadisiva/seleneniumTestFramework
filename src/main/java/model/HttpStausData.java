package model;


public class HttpStausData {
    private int statusCode;
    private String name;

    public HttpStausData(){

    }
    public int getStatusCode(){
        return statusCode;
    }
    public void setStatusCode(int statusCode){
        this.statusCode=statusCode;
    }
    public String getName(){
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
}

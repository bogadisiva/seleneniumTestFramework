package config;

public enum Environment {
    DEV,QA,UAT;
    public static Environment from(String value)
    {
        if(value==null || value.isBlank())
        {
            return DEV;
        }
        try {
            return Environment.valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unsupported Environment: "+value +".supported values are :Dev,Qa,Uat",e);
        }
    }
    public String fileName(){
        return "config/config-"+name().toLowerCase()+".properties";
    }
}

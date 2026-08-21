package config;

public final class SecretManager {
    private SecretManager(){
        throw new UnsupportedOperationException("SecretManager is a utility class");
    }
    public static String getuserName(){
        return getRequiredSecret( "WORKBENCH_USERNAME");
    }
    public static String getPassword(){
        return getRequiredSecret("WORKBENCH_PASSWORD");
    }
    private static String getRequiredSecret(String name)
    {
        String value=System.getenv(name);
        if(value==null || value.isBlank())
        {
            throw new IllegalStateException(
                    "Required environment variable "
                            + name
                            + " is not configured."
            );
        }
        return value;
    }
}

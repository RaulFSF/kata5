package kata5.model;

public class Person {
   private final String name;
   private final String address;
   private final String email;

    public Person(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public String getName() {return name;}

    public String getAddress() {return address;}

    public String getEmail() {return email;}
   
    public String getEmailDomain(){
        if(isValidEmail(this.getEmail())){
            return this.getEmail().substring(this.email.indexOf("@")+1);
        }
        return "";
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9.!#%&'*+/=?^ `[|]~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
    }
    
   @Override
    public String toString(){
        return "Person {"+" NAME: "+ name + " ADDRESS: "+ address +" EMAIL: "+ email + " }";
    }
}

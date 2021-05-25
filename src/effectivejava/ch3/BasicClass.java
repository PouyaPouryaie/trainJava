package effectivejava.ch3;

import java.util.Objects;

public class BasicClass implements Cloneable, Comparable<BasicClass>{

    private String name;
    private int age;
    private long nationalId;
    private double currency;
    private int hashCode;

    public BasicClass(String name, int age, long nationalId, double currency) {
        this.name = name;
        this.age = age;
        this.nationalId = nationalId;
        this.currency = currency;
    }

    @Override
    public int hashCode(){
        int result = hashCode;
        if(result == 0){
            result = Integer.hashCode(age);
            result += 31 * result + Objects.hashCode(name);
            result += 31 * result + Long.hashCode(nationalId);
            result += 31 * result + Double.hashCode(currency);
            hashCode = result;
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicClass that = (BasicClass) o;
        return age == that.age &&
                nationalId == that.nationalId &&
                Double.compare(that.currency, currency) == 0 &&
                Objects.equals(name, that.name);
    }

    @Override
    public BasicClass clone(){
        try{
            return (BasicClass) super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }

    @Override
    public int compareTo(BasicClass o) {
        int result = Integer.compare(this.getAge(), o.getAge());
        if(result ==0){
            result = Long.compare(this.getNationalId(), o.getNationalId());
            if(result == 0){
                result = Double.compare(this.getCurrency(), o.getCurrency());
                if(result == 0){
                    result = this.getName().compareTo(o.getName());
                }
            }
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getNationalId() {
        return nationalId;
    }

    public double getCurrency() {
        return currency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNationalId(long nationalId) {
        this.nationalId = nationalId;
    }

    public void setCurrency(double currency) {
        this.currency = currency;
    }

    public void writeData(String ...data){
        String[] a = data;
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    @Override
    public String toString() {
        return "BasicClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nationalId=" + nationalId +
                ", currency=" + currency +
                '}';
    }
}

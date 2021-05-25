package threadtrain;

import com.google.gson.Gson;

import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("[0-9]\\+");
        if(pattern.matcher("9+").matches()){
            System.out.println("match");
        }
        System.out.println("end");

        Wrapper<String> wrapperS = new Wrapper<>("ana");
        Wrapper<Integer> wrapperI = new Wrapper<>(12);
        Wrapper<Integer> wrapperL = new Wrapper<>(24);
        System.out.println(wrapperI.get());
        Wrapper<Object> wrapperO = new Wrapper<>(new Object());
        WrapperUtils.print(wrapperO);
        WrapperUtils.print(wrapperS);
        System.out.println(WrapperUtils.sum(wrapperI, wrapperL));

        String json = "{\"name\":\"Jeep\", \"message\": \"hello deer\"}";

        Gson gson = new Gson();

        Person p = gson.fromJson(json, Person.class);
        System.out.println(p.getMessage());
    }
}

class Person{
    String name;
    String message;

    public Person(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

class Wrapper<T>{
    T ref;

    public Wrapper(T ref){
        this.ref = ref;
    }

    public T get(){
        return ref;
    }

    public void set(T ref){
        this.ref =ref;
    }

    @Override
    public String toString() {
        return "threadtrain.Wrapper{" +
                "ref=" + ref +
                '}';
    }
}

class Test<V>{
    public <T> void testMethod(Wrapper<T> w1, Wrapper<T> w2, T c){
        System.out.println(w1 + "," + w2);
    }
}

class WrapperUtils{
    public static void print(Wrapper<?> wrapper){
        Object o = wrapper.get();
        String className = null;
        if(o != null){
            className = o.getClass().getName();
        }
        System.out.println("class: " + className + ", value is: " + o);

    }

    public static double sum(Wrapper<? extends Number> w1, Wrapper<? extends Number> w2){
        Number n1 = w1.get();
        Number n2 = w2.get();
        return n1.doubleValue() + n2.doubleValue();
    }

    public static <T> void copy(Wrapper<T> source, Wrapper<? super T> des){
        T value = source.get();
        des.set(value);
    }
}
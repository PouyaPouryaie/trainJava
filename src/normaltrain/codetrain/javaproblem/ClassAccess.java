package normaltrain.codetrain.javaproblem;

import java.io.*;
import java.lang.reflect.*;

public class ClassAccess {

    public static void main(String[] args) throws Exception {

        DoNotTerminate.forbidExit();

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine().trim());
            Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private

            /* first solution */
/*            Class<?> enclosingClass = Class.forName("normaltrain.codetrain.javaproblem.CanYouAccess$Inner");
            Object enclosingInstance = enclosingClass.newInstance();
            Class<?> innerClass = Class.forName("normaltrain.codetrain.javaproblem.CanYouAccess$Inner$Private");
            Constructor<?> ctor = innerClass.getDeclaredConstructor(enclosingClass);
            o = ctor.newInstance(enclosingInstance);
            Method powerof2 = innerClass.getDeclaredMethod("powerof2", int.class);
            powerof2.setAccessible(true);
            String invoke = (String)powerof2.invoke(o, num);*/

            /*second-solution*/
/*            Class<?> enclosingClass = Class.forName(Inner.class.getName());
            Object enclosingInstance = enclosingClass.newInstance();
            Class<?> innerClass = Class.forName(Inner.Private.class.getName());
            Constructor<?> ctor = innerClass.getDeclaredConstructor(enclosingClass);
            o = ctor.newInstance(enclosingInstance);
            Method powerof2 = innerClass.getDeclaredMethod("powerof2", int.class);
            powerof2.setAccessible(true);
            String invoke = (String)powerof2.invoke(o, num);*/

            /*third-solution*/
            Inner.Private aPrivate = new Inner().new Private();
            o = (Object) aPrivate;

            System.out.println(num + " is " + aPrivate.powerof2(num));
            System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

        }

        catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }

    static class Inner{
        private class Private{
            private String powerof2(int num){
                return ((num&num-1)==0)?"power of 2":"not a power of 2";
            }
        }
    }

}



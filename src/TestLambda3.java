import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestLambda3 {

    //Consumer<T>
    //   void accept(T t)

    // Supplier<T>
    //  T get();

    //Function<T,R>
    // R apply(T t);

    //Predicate<T>
    //   boolean test(T,t);

    @Test
    public void test(){
        cost(1000.0,(e)-> System.out.println("cost is"+e));
    }
    public void cost(Double money, Consumer<Double> con){
            con.accept(money);
    }

    @Test
    public void test2(){
        Integer res=RandomNumber(()->(int)(Math.random()*10));
        System.out.println(res);
    }



    public Integer RandomNumber(Supplier<Integer> supplier){
        return supplier.get();
    }

    @Test
    public void test3(){
        String res=ToUpper("abv",(s)->s.toUpperCase());
        System.out.println(res);
    }


    public String ToUpper(String s, Function<String,String> ft){
        return   ft.apply(s);
    }

    List<Employee> employees= Arrays.asList(
            new Employee("zhangsan",18,123),
            new Employee("lisi",28,1234),
            new Employee("wangwu",38,3423),
            new Employee("zhaoliu",48,9424)
    );

    @Test
    public void test4(){
        List<Employee> list=Getemployees(employees,(e)->e.getSalary()>5000);
        list.forEach(System.out::println);
    }


    public List<Employee> Getemployees(List<Employee> employees, Predicate<Employee> pre){
        List<Employee> list=new ArrayList<>();
        for(Employee e:employees){
            if(pre.test(e)){

                list.add(e);
            }


        }
        return list;
    }


    @Test
    public void test5(){

        Consumer<String> con1= (x)->System.out.println(x);

        //因为pritln方法是 只有一个参数，没有返回值  正好和Consumer 一样 所以可以这么写
       Consumer<String> con= System.out::println;




    }

}

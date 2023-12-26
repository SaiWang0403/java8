import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestStreamApi {

    List<Employee> employees= Arrays.asList(
            new Employee("zhangsan",18,123),
            new Employee("lisi",28,1234),
            new Employee("wangwu",38,3423),
            new Employee("zhaoliu",48,9424),
                        new Employee("zhaoliu",48,9424)

    );
    @Test
    public void test(){
//        Stream s=employees.stream().filter(e->e.getAge()>30);
//
//        s.forEach(e->System.out.println(e));

        //       因为println是 传一个参数无返回值 和foreach（是consumer） 一样 所以可以下面这么写
        //        s.forEach(System.out::println);


        //取前两个
//        employees.stream().filter(e->e.getAge()>30).limit(2).forEach(System.out::println);
//        //跳过前两个
//        employees.stream().filter(e->e.getAge()>30).skip(2).forEach(System.out::println);
        //去重  要重写Employee类中的hashcode和equals
        employees.stream().filter(e->e.getAge()>30).distinct().forEach(System.out::println);
    }

    @Test
    public void test2(){
        List<String> list=Arrays.asList("a","b","c");
        //做。stream操作就是在创建一个stream  这个stream是什么类型取决于toUpperCase()返回什么值  e就是这个steam《List》中的每一个元素  也就是string
        Stream<String> s=list.stream();
        s.map(e->e.toUpperCase()).forEach(System.out::println);


        employees.stream().map(Employee::getName).forEach(System.out::println);

        List<Integer> list1=Arrays.asList(1,2);
        Stream<Integer> s1=list1.stream();

    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list=new ArrayList<>();
        for (Character ch:str.toCharArray()){
            list.add(ch);
        }
        return list.stream();
    }

    @Test
    public void test3(){
        List<String> list=Arrays.asList("aa","bb","cc");
        //map是用function  给一个参数 返回一个值
        //filterCharacter 会出现很多stream 每个stream(例如一个aa stream)里都有一个stream《Character》 会把每一个大stream map过去
        //所以foreach时要从大stream里 把小stream拿出来
        Stream<Stream<Character>> stream=list.stream().map(TestStreamApi::filterCharacter);
        stream.forEach((sm)->{
            sm.forEach(System.out::println);
        });
    }

    @Test
    public void test4(){
        List<String> list=Arrays.asList("aa","bb","cc");
        //flatmap 就是找底层的数据 然后平铺开来
        list.stream().flatMap(TestStreamApi::filterCharacter).forEach(System.out::println);
    }

    @Test
    public void test5(){
        List<String> list=Arrays.asList("ee","aa","bb","cc");
        list.stream().sorted().forEach(System.out::println);

        employees.stream().sorted((e1,e2)->{
                if(e1.getAge()==e2.getAge()){
                    return e1.getName().compareTo(e2.getName());
                }
                return Integer.compare(e1.getAge(),e2.getAge());


        }).forEach(System.out::println);
    }



}

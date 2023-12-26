import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestStreamApi2 {
    List<Employee> employees= Arrays.asList(
            new Employee("zhangsan",18,123, Employee.Status.Free),
            new Employee("lisi",28,1234,Employee.Status.Busy),
            new Employee("wangwu",38,3423,Employee.Status.Vocation),
            new Employee("zhaoliu",48,9424,Employee.Status.Free),
            new Employee("zhaoliu",48,9424,Employee.Status.Busy),
            new Employee("liuzhao",48,9,Employee.Status.Busy)

    );
    @Test
    public void test(){
//       boolean res=employees.stream().allMatch(e->e.getAge()>50);
//        System.out.println(res);
//
//        boolean res1=employees.stream().anyMatch(e->e.getAge()>40);
//        System.out.println(res1);

//        boolean res2=employees.stream().noneMatch(e->e.getStatus().equals(Employee.Status.Busy));
//        System.out.println(res2);
//
//       Optional<Employee> op= employees.stream().sorted((e1,e2)->Double.compare(e1.getSalary(),e2.getSalary())).findFirst();
//        System.out.println(op.get());
//
//        Optional<Employee> op2= employees.stream().filter(e->e.getStatus().equals(Employee.Status.Free)).findFirst();
//        System.out.println(op2.get());

        Optional<Employee> op3=employees.stream().max((e1,e2)->Double.compare(e1.getSalary(),e2.getSalary()));
        System.out.println(op3.get());

        Optional<Double> op4=employees.stream().map(Employee::getSalary).min(Double::compare);
        System.out.println(op4.get());
    }

    @Test
    public void test2(){
        List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum=list.stream().reduce(0,(x,y)->x+y);
        System.out.println(sum);


        Optional<Double> op=employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(op.get());
    }

    @Test
    public void test3(){
//        List<String> list=employees.stream().map(Employee::getName).collect(Collectors.toList());
//        list.forEach(System.out::println);
//
//        Double avg=employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
//        System.out.println(avg);
//
//        Double sum=employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
//        System.out.println(sum);

        Optional<Employee> max=employees.stream().collect(Collectors.maxBy((e1,e2)->Double.compare(e1.getSalary(),e2.getSalary())));
        System.out.println(max.get());

        Optional<Double> min=employees.stream().map(Employee::getSalary).collect(Collectors.minBy(Double::compare));
        System.out.println(min.get());
    }
//分组和多重分组
    @Test
    public void test4(){
//        Map<Employee.Status,List<Employee>> map=employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
//        System.out.println(map);

        Map<Employee.Status,Map<String,List<Employee>>> map2= employees.stream().collect(Collectors.groupingBy(Employee::getStatus,Collectors.groupingBy((e)->{
            if(e.getAge()<30){
                return "young";
            }else if(e.getAge()<50){
                return "mid";
            }else {
                return "old";
            }
        })));
        System.out.println(map2);

    }
    //分区
    @Test
    public void test5(){
        Map<Boolean,List<Employee>> map=employees.stream().collect(Collectors.partitioningBy(e->e.getSalary()>5000));
        System.out.println(map);
    }

    @Test
    public void test6(){
        DoubleSummaryStatistics dss=employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getAverage());;
        System.out.println(dss.getMax());
    }
    @Test
    public void test7(){
        String str=employees.stream().map(Employee::getName).collect(Collectors.joining());
        System.out.println(str);
    }
}

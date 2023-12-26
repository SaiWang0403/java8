public class FilterEmployeeByAge implements myPredict<Employee> {
    @Override
    public boolean test(Employee t){
        return t.getAge()>35;
    }
}

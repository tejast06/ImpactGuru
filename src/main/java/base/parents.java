package base;

public class parents extends Child1 {


    public void parentsm1(){
        System.out.println("parent");
    }


    public static void main(String[] args) {

        parents parents = new parents();
        parents.m1();

        Child2 child2 = new Child2();
        child2.m2();

        Child3 child3 = new Child3();
        child3.m3();

    }


}

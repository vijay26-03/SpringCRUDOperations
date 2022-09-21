package com.example.springh2_sample;

public class Students {

    Students(String name,String age){
        this.name=name;
        this.age=age;
    }
    private Integer id;
    private String name;
    private String age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

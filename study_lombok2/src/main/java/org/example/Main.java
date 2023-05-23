package org.example;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

/*
class MyClass implements Serializable {

    public MyClass() {
    }

    private String value1;
    private Integer value2;

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public Integer getValue2() {
        return value2;
    }

    public void setValue2(Integer value2) {
        this.value2 = value2;
    }

}*/

//@Getter // getter
//@Setter // setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@EqualsAndHashCode
//class MyClass implements Serializable {
//    private String value1;
//    private Integer value2;
//    @ToString.Exclude private  String value3;
//}

//@Data
//class MyClass implements Serializable {
//    private String value1;
//    private Integer value2;
//    @ToString.Exclude private  String value3;
//}

@Builder
@Data
@NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor
class MyClass implements Serializable {
    private String value1;
    private Integer value2;
    private  String value3;
}

public class Main {
    public static void main(String[] args) {
        MyClass.builder()
                .value1("hello")
                .value2(1000)
                .value3("world")
                .build();


    }
}
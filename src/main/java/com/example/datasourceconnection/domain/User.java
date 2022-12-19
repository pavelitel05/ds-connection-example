package com.example.datasourceconnection.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name = "users")
@Getter
@Setter
@Component
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_sex")
    private String userSex;

    @Override
    public String toString(){
        return this.userName;
    }
}

package com.example.ksdproject.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"})
})
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "is_deleted is not true")
@SQLDelete(sql = "update users set is_deleted = true, email = email || now() where id = ?")
public class User extends BaseEntity {

        private String name;

        private String surName;

        private String email;

        private String password;

}

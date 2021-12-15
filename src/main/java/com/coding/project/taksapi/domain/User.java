package com.coding.project.taksapi.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)

    private List<Task> tasks;
    private String userName;
    private String password;
    @Column(unique = true)
    private String email;
    private int phoneNumber;
    @CreationTimestamp
    private Timestamp createdDated;
    @UpdateTimestamp
    private Timestamp lastModifiedDate;


}

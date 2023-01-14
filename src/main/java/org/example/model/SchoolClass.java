package org.example.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "school_class")
public class SchoolClass {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String className;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    Employee employee;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "schoolClass")
    private List<Presence> presences;
}

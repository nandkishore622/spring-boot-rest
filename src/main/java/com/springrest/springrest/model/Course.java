package com.springrest.springrest.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
/*@Setter
@Getter
@AllArgsConstructor*/
@Data
@NoArgsConstructor
@Table(name = "course")
public class Course {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;

    @NotNull
    private String courseTitle;

    @NotNull
    private String description;
}

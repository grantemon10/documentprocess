package com.training.documentprocess.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "candidate")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    private String title;

    @Enumerated(EnumType.STRING)
    private Level level;

    private Integer salary;

    @OneToMany(mappedBy = "candidate")
    private List<Skill> skills;

    private String description;

    @Enumerated(EnumType.STRING)
    private Reputation reputation;

}



package com.samsung.hakafon.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project")

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pjId;

    @Column(name = "pjname")
    private String pjname;

    @Column(name = "tlId")
    private Long tlId;

    @Column(name = "dev1Id")
    private Long dev1Id;

    @Column(name = "dev2Id")
    private Long dev2Id;

    @Column(name = "dev3Id")
    private Long dev3Id;

    @Column(name = "discript")
    private String dicsript;




}

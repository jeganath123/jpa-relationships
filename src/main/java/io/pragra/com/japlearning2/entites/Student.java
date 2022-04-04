package io.pragra.com.japlearning2.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 255, nullable=false)
    private String name;
    @Builder.Default
    private Instant creatDate=Instant.now();
    @Builder.Default
    private Instant updateDate=Instant.now();

    @Transient
    private String funnyName;

    @OneToOne(fetch= FetchType.LAZY,cascade = CascadeType.PERSIST, orphanRemoval = true)
    private StudentPermit permit;

    @OneToMany(mappedBy = "student")
    @Builder.Default
    private List<Reviews> reviews=new ArrayList<>();

    @ManyToMany
    @Builder.Default
    private List<Programs> programs=new ArrayList<>();
}

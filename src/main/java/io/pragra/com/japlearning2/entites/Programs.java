package io.pragra.com.japlearning2.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Programs {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Long duration;
    @ManyToMany
    @Builder.Default
    private List<Student> students=new ArrayList<>();
}

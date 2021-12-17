package by.pisetskiy.iquiz.model.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@SuperBuilder
public class Question extends BaseEntity {

    private String content;
    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "question_id")
    @ToString.Exclude
    @Builder.Default
    private List<Variant> variants = new ArrayList<>();

    public void addVariant(Variant variant) {
        this.variants.add(variant);
    }

    public void removeVariant(Variant variant) {
        this.variants.remove(variant);
    }
}

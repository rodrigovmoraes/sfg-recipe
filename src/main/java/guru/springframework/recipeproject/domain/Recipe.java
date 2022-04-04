package guru.springframework.recipeproject.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = {"categories", "ingredients", "notes"})
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    @Lob
    private String directions;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @Lob
    private Byte[] image;

    @ManyToMany
    @JoinTable(name="recipe_category",
               joinColumns = @JoinColumn(name = "recipe_id"),
               inverseJoinColumns = @JoinColumn(name="category_id")
    )
    private Set<Category> categories = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    public Recipe() {
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        ingredient.setRecipe(this);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Recipe;
    }

}

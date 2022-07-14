package guru.springframework.recipeproject.domain;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.HashSet;

public class CategoryTest {
    private Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() {
        Long id = 41L;
        category.setId(id);
        assertEquals(id, category.getId());
    }

    @Test
    public void getDescription() {
        String description = "Hello";
        category.setDescription(description);
        assertEquals(description, category.getDescription());
    }

    @Test
    public void getRecipes() {
        HashSet<Recipe> recipes = new HashSet<>();
        category.setRecipes(recipes);
        assertEquals(recipes, category.getRecipes());
    }
}
package guru.springframework.recipeproject.services;

import guru.springframework.recipeproject.domain.Recipe;
import guru.springframework.recipeproject.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {
    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipeById() throws Exception {
        Long OWNER_ID = 2L;
        Recipe returnRecipe = new Recipe();
        returnRecipe.setId( OWNER_ID );
        when( recipeRepository.findById(OWNER_ID) ).thenReturn( Optional.of(returnRecipe) );
        Recipe recipe = recipeService.getRecipeById(OWNER_ID);
        assertNotNull(recipe);
        assertEquals(OWNER_ID, recipe.getId());
        verify(recipeRepository, times(1)).findById( OWNER_ID );
    }

    @Test
    public void getRecipeByIdNull() throws Exception {
        Long OWNER_ID = 2L;
        Recipe returnRecipe = new Recipe();
        returnRecipe.setId( OWNER_ID );
        when( recipeRepository.findById(OWNER_ID) ).thenReturn( Optional.empty() );
        Recipe recipe = recipeService.getRecipeById(OWNER_ID);
        assertNull(recipe);
        verify(recipeRepository, times(1)).findById( OWNER_ID );
    }

    @Test
    public void getRecipes() throws Exception {
        Recipe recipe = new Recipe();
        HashSet recipesData = new HashSet();
        recipesData.add(recipe);
        when( recipeRepository.findAll() ).thenReturn( recipesData );
        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(1, recipes.size());
        verify( recipeRepository, times(1) ).findAll();
    }
}
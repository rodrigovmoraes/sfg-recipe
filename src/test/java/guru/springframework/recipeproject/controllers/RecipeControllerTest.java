package guru.springframework.recipeproject.controllers;

import guru.springframework.recipeproject.domain.Recipe;
import guru.springframework.recipeproject.services.RecipeService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RecipeControllerTest {
    @Mock
    RecipeService recipeService;
    RecipeController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = new RecipeController( recipeService );
    }

    @Test
    public void showById() throws Exception {
        Long OWNER_ID = 2L;
        Recipe recipe = new Recipe();
        recipe.setId(OWNER_ID);
        when( recipeService.getRecipeById(OWNER_ID) ).thenReturn(recipe);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(get("/recipe/show/" + OWNER_ID))
               .andExpect(status().isOk())
               .andExpect(view().name("recipe/show"))
               .andExpect( model().attribute("recipe", Matchers.sameInstance(recipe) ));

        verify( recipeService, times(1) ).getRecipeById(OWNER_ID);
    }
}
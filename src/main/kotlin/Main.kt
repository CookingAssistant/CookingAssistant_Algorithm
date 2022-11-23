import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    var cook1_recipe_list = ArrayList<Recipe>();
    var sampleDuration = TimeUnit.SECONDS.toSeconds(30);

    var cook1_recipe1 = Recipe(
        recipe_title = "Recipe_Title1",
        recipe_description = "Recipe_Description1",
        durationTime = sampleDuration,
        canMultitasking = false
    );
    var cook1_recipe2 = Recipe(
        recipe_title = "Recipe_Title2",
        recipe_description = "Recipe_Description2",
        durationTime = sampleDuration,
        canMultitasking = true
    );
    var cook1_recipe3 = Recipe(
        recipe_title = "Recipe_Title3",
        recipe_description = "Recipe_Description3",
        durationTime = sampleDuration,
        canMultitasking = true
    );

    cook1_recipe_list.add(cook1_recipe1);
    cook1_recipe_list.add(cook1_recipe2);
    cook1_recipe_list.add(cook1_recipe3);

    var cook1 = Cooking(cook_name = "Cook-1-요리이름", cook_recipe = cook1_recipe_list);

    for (recipe in cook1.cook_recipe) {
        println("Recipe Title: ${recipe.recipe_title}, Recipe_Description=${recipe.recipe_description}, durationTime=${recipe.durationTime}, canMultitasking=${recipe.canMultitasking}");

    }
}
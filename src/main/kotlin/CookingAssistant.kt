class CookingAssistant(var Cuisines: ArrayList<Cuisine>){
    var cookOrder :ArrayList<Recipe> = ArrayList<Recipe>()
    init{
        println("Hello this is CookingAssistant")
        println("We will make")
        for(cuisine in Cuisines){
            println("-${cuisine.name}")
        }
        println("=======================")
        println("Materials:")
        for(cuisine in Cuisines) {
            println(cuisine.material)
        }
        println("=======================")
        println("Recipes:")
        for(cuisine in Cuisines) {
            for(recipe in cuisine.recipe){
                println(recipe.description)
            }
        }


    }


}
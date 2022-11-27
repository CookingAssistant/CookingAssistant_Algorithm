import java.util.concurrent.TimeUnit

class CookingAssistant(var Cuisines: ArrayList<Cuisine>){
    // 흠,, 없어도 됨
    var cookOrder :ArrayList<Recipe> = ArrayList<Recipe>()
    // 흠...
    var cuisine = ArrayList<Cuisine>()
    // 총 해야하는 일의 갯수 ( 레시피의 갯수)
    var num_of_recipe: Int = 0
    init{
        println("Hello this is CookingAssistant")
        println("We will make")
        for(c in Cuisines){
            cuisine.add(c)
            println("-${c.name}")
        }

        println("=======================")
        println("Materials:")
        for(c in Cuisines) {
            println(c.material)
        }

        println("=======================")
        println("Recipes:")
        for(c in Cuisines) {
            for(r in c.recipe){
                num_of_recipe++
            }
//            for(recipe in c.recipe){
//                recipe.start()
//            }
        }
        println("number of todo = $num_of_recipe")

    }

    fun cook() {

        var did: Int = 0
        while (did < num_of_recipe) {
            for (c in Cuisines) {

                for (i in 0 until c.recipe.size) {


                    if (i == 0 && !c.recipe[i].isAlive && !c.recipe[i].done) {
                        println(c.recipe[i].description)
                        c.recipe[i].start()
                        did++


                    } else if (i > 0){
                        if(c.recipe[i - 1].done && !c.recipe[i].isAlive && !c.recipe[i].done){

                            println(c.recipe[i].description)
                            c.recipe[i].start()
                            did++
                        }

                    }




                }


            }

        }
        println("요리가 완성되었습니다 ~")
    }






}
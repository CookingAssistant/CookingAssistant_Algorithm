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

    fun Cook() {

        var did: Int = 0
        while (did < num_of_recipe) {
            for (c in Cuisines) {

                for (i in 0 until c.recipe.size) {
                    println("!!! ${c.recipe[i].description} ${c.recipe[i].done} ${did}")
                    if (i == 0) {
                        if (c.recipe[i].isAlive) { // 실행중이라면
                            break
                        } else {
                            c.recipe[i].start()
                            println(c.recipe[i].description)
                            did++
                        }
                    } else if (i != 0) {
                        if (!c.recipe[i - 1].done) { // 이전 작업이 안끝났다면
                            break
                        } else {
                            if (c.recipe[i].isAlive) { // 실행중이라면
                                break
                            } else {
                                c.recipe[i].start()
                                println(c.recipe[i].description)
                                did++
                            }
                        }
                    }



                    //Thread.sleep(TimeUnit.MINUTES.toMillis(1) / 1)
                }
                println("I'm Done")
            }

        }
    }
}
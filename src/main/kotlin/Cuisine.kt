class Cuisine(var name: String, var description: String, var recipe: ArrayList<Recipe>){

    // 생성자 어렵다.. 질문하자
    var material = ArrayList<String>();
    init {
        for (x in recipe){
           this.material.addAll(x.material)
        }
    }


    fun printRecipe(){
        println("***** To make ${name} [${description}]*****")
        print("You need ")
        for(x in material){
            print("$x ")
        }
        println("")


        for(x in recipe){
            println("<${x.title}> - ${x.description}, 소요시간 : ${x.duration}, do other : ${x.canDoOther}")
        }

    }





}


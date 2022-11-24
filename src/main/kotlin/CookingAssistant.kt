class CookingAssistant(var Cuisines: ArrayList<Cuisine>){
    var myList: ArrayList<String>


    fun asd(){
        for(cuisine in Cuisines){
            for(recipe in cuisine){
                if(recipe.canDoOther == 0){
                    myList.add(recipe.description)
                }
            }
        }


        println(myList)
    }


}
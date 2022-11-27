import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    var ramen_recipe = ArrayList<Recipe>();

    var ramen_recipe1 = Recipe(
        title = "물 끓이기",
        material = arrayListOf<String>("물500ml", "냄비"),
        description = "물 550ml를 냄비에 받은 후 4분동안 끓이세요",
        duration = TimeUnit.MINUTES.toMillis(4),
        canDoOther = true,
        done = false
    );

    var ramen_recipe2 = Recipe(
        title = "재료 넣기",
        material = arrayListOf<String>("라면 1봉지"),
        description = "면, 스프, 후레이크를 넣어주세요. 4분 더 끓이신 후 완성입니다.",
        duration = TimeUnit.MINUTES.toMillis(4),
        canDoOther = false,
        done = false
    );

    ramen_recipe1.left = null
    ramen_recipe1.right = ramen_recipe2

    ramen_recipe2.left = ramen_recipe1
    ramen_recipe1.right = null

    ramen_recipe.add(ramen_recipe1);
    ramen_recipe.add(ramen_recipe2);

    var ramen = Cuisine(name = "라면", description = "간편하게 먹는 라면입니다", recipe = ramen_recipe);


    var steak_recipe = ArrayList<Recipe>();

    var steak_recipe1 = Recipe(
        title = "후라이팬 예열하기",
        material = arrayListOf<String>("후라이펜", "소량의 기름"),
        description = "후라이팬에 기름을 두리고 1분간 예열하세요",
        duration = TimeUnit.MINUTES.toMillis(1),
        canDoOther = true,
        done = false
    );

    var steak_recipe2 = Recipe(
        title = "소고기 굽기",
        material = arrayListOf<String>("소고기 400g"),
        description = "후라이팬에 소고기를 올리고 취향에 맞게 (2분 - 레어, 3분 미디엄 레어, 4분 미디엄) 익혀주시면 완성입니다.",
        duration = TimeUnit.MINUTES.toMillis(4),
        canDoOther = false,
        done = false
    );

    steak_recipe1.left = null
    steak_recipe1.right = steak_recipe2

    steak_recipe2.left = steak_recipe1
    steak_recipe2.right = null


    steak_recipe.add(steak_recipe1);
    steak_recipe.add(steak_recipe2);

    var steak = Cuisine(name = "스테이크", description = "소고기 구이입니다", recipe = steak_recipe);


    var egg_fried_rice_recipe = ArrayList<Recipe>();

    var egg_fried_rice_recipe1 = Recipe(
        title = "후라이팬 예열하기",
        material = arrayListOf<String>("후라이펜", "소량의 기름"),
        description = "후라이팬에 기름을 두리고 1분간 예열하세요",
        duration = TimeUnit.MINUTES.toMillis(1),
        canDoOther = true,
        done = false
    );
    var egg_fried_rice_recipe2 = Recipe(
        title = "계란 익히기",
        material = arrayListOf<String>("계란 2알"),
        description = "후라이팬에서 계란을 튀기듯이 2분간 익혀주세요",
        duration = TimeUnit.MINUTES.toMillis(2),
        canDoOther = false,
        done = false
    );
    var egg_fried_rice_recipe3 = Recipe(
        title = "밥과 계란 볶기",
        material = arrayListOf<String>("밥 1공기"),
        description = "후라이팬에 밥을 넣고 계란과 함께 3분정도 볶아주시면 완성입니다.",
        duration = TimeUnit.MINUTES.toMillis(3),
        canDoOther = false,
        done = false
    );

    egg_fried_rice_recipe1.left = null
    egg_fried_rice_recipe1.right = egg_fried_rice_recipe2

    egg_fried_rice_recipe2.left = egg_fried_rice_recipe1
    egg_fried_rice_recipe2.right = egg_fried_rice_recipe3

    egg_fried_rice_recipe3.left = egg_fried_rice_recipe2
    egg_fried_rice_recipe3.right = null



    egg_fried_rice_recipe.add(egg_fried_rice_recipe1);
    egg_fried_rice_recipe.add(egg_fried_rice_recipe2);
    egg_fried_rice_recipe.add(egg_fried_rice_recipe3);


    var egg_fried_rice = Cuisine(name = "계란볶음밥", description = "계란과 밥을 볶은 요리입니다", recipe = egg_fried_rice_recipe);

    var recipe_list = ArrayList<Recipe>()
    var cuisine_list  = ArrayList<Cuisine>()


   cuisine_list.add(createCuisine())


    var cookList = ArrayList<Cuisine>()
    cookList.add(ramen)
    cookList.add(steak)
    cookList.add(egg_fried_rice)
    for (i in 0 until cuisine_list.size) {
        cookList.add(cuisine_list[i])
    }

    val ca = CookingAssistant(cookList)
    ca.cook()

}

fun addRecipe(recipe_list: ArrayList<Recipe>, title: String, material: ArrayList<String>, description: String, duration:Long, canDoOther: Boolean) {
        recipe_list.add(
            Recipe(
            title = title,
            material = material,
            description = description,
            duration = duration,
            canDoOther = canDoOther,
            done = false
        )
    )
}

fun createCuisine():Cuisine {
    var name: String = "파전" // 사용자 입력
    var description: String = "노릇노릇 파전" // 사용자 입력
    var recipe_list = ArrayList<Recipe>()  // 레시피 저장을 위한 임시 공간


    // 사용자 입력 시작
    addRecipe(recipe_list, "재료 준비", arrayListOf<String>("파 반단", "감자 1개", "양파 1개", "해산물(오징어 새우) 1컵", "고추 2개"),
        "재료를 모두 채썰어 준비해주세요", TimeUnit.MINUTES.toMillis(4), canDoOther = false)
    addRecipe(recipe_list, "반죽 만들기", arrayListOf<String>("물 한 컵", "부침가루 1컵 반", "튀김가구 반 컵", "설탕 1/2t", "소급  1/4t"),
        "재료를 큰 그릇에 넣고 뭉치지 않도록 잘 섞습니다.", TimeUnit.MINUTES.toMillis(3), canDoOther = false)
    addRecipe(recipe_list, "팬 예열", arrayListOf<String>("후라이펜", "식용유 3T"), "후라이팬에 기름을 두르고 걍불로 예열합니다.", TimeUnit.MINUTES.toMillis(1), canDoOther = true)
    addRecipe(recipe_list, "전 부치기(1)", arrayListOf<String>("반죽", "채썬 파"),
        "후라이팬에 반죽을 두르고 그 위에 파를 올립니다.", TimeUnit.MINUTES.toMillis(1), canDoOther = true)
    addRecipe(recipe_list, "전 부치기(2)", arrayListOf<String>("채썬 재료"),
        "반죽 위에 나머지 채료를 올립니다.", TimeUnit.MINUTES.toMillis(1), canDoOther = true)
    addRecipe(recipe_list, "전 부치기(3)", arrayListOf<String>(""),
        "전을 뒤집어 고루 익힙니다.", TimeUnit.MINUTES.toMillis(2), canDoOther = true)

    // 사용자 입력 끝

    return Cuisine(name, description, recipe_list); // Cuisine 반환
}

// 스레드 공부할 때 써놓은건데 없어도 됨

//class SimpleThread(rot: rotto) : Thread(){
//
//    var c = rot.get()
//    override fun run() {
//        while(true) {
//            println("${Thread.currentThread()} add...")
//            Thread.sleep(1000)
//        }
//    }
//}
//
//class SimpleRunnable: Runnable{
//    override fun run() {
//        println("${Thread.currentThread()} has run")
//    }
//}
//class rotto (var num: Int){
//    fun add() {num++}
//    fun get(): Int {return num}
//}
//class CountThread(rot: rotto) : Thread(){
//    var c = rot.get()
//    override fun run() {
//        while(true){
//            println("I'm counting ${c}")
//            Thread.sleep(500)
//
//
//        }
//    }
//}


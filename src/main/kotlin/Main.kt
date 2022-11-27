import com.google.gson.Gson
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
    );

    var ramen_recipe2 = Recipe(
        title = "재료 넣기",
        material = arrayListOf<String>("라면 1봉지"),
        description = "면, 스프, 후레이크를 넣어주세요. 4분 더 끓이신 후 완성입니다.",
        duration = TimeUnit.MINUTES.toMillis(4),
        canDoOther = false,
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
    );

    var steak_recipe2 = Recipe(
        title = "소고기 굽기",
        material = arrayListOf<String>("소고기 400g"),
        description = "후라이팬에 소고기를 올리고 취향에 맞게 (2분 - 레어, 3분 미디엄 레어, 4분 미디엄) 익혀주시면 완성입니다.",
        duration = TimeUnit.MINUTES.toMillis(4),
        canDoOther = false,
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
    );
    var egg_fried_rice_recipe2 = Recipe(
        title = "계란 익히기",
        material = arrayListOf<String>("계란 2알"),
        description = "후라이팬에서 계란을 튀기듯이 2분간 익혀주세요",
        duration = TimeUnit.MINUTES.toMillis(2),
        canDoOther = false,
    );
    var egg_fried_rice_recipe3 = Recipe(
        title = "밥과 계란 볶기",
        material = arrayListOf<String>("밥 1공기"),
        description = "후라이팬에 밥을 넣고 계란과 함께 3분정도 볶아주시면 완성입니다.",
        duration = TimeUnit.MINUTES.toMillis(3),
        canDoOther = false,
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


    var cookList = ArrayList<Cuisine>()
    cookList.add(egg_fried_rice)
    cookList.add(steak)






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


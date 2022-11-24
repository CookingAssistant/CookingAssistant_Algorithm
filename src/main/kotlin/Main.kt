import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    var ramen_recipe = ArrayList<Recipe>();

    //var sampleDuration = TimeUnit.SECONDS.toSeconds(30);


    var ramen_recipe1 = Recipe(
        title = "물 끓이기",
        material = arrayListOf<String>("물500ml", "냄비"),
        description = "물 550ml를 냄비에 받은 후 4분동안 끓이세요",
        duration = TimeUnit.SECONDS.toMinutes(4),
        canDoOther = true
    );
    var ramen_recipe2 = Recipe(
        title = "재료 넣기",
        material = arrayListOf<String>("라면 1봉지"),
        description = "면, 스프, 후레이크를 넣어주세요. 4분 더 끓이신 후 완성입니다.",
        duration = TimeUnit.SECONDS.toMinutes(4),
        canDoOther = false
    );

    ramen_recipe.add(ramen_recipe1);
    ramen_recipe.add(ramen_recipe2);

    var cook1 = Cuisine(name = "Cook-1-요리이름", description = "맛있는 요리1 입니다", recipe = ramen_recipe);
    // cook1.printRecipe();

//    var time = TimeUnit.SECONDS.toMillis(1)
//    println("asdasd $time")
//
//    var timer = 10
//    while(timer > 0){
//        println(timer--)
//
//        Thread.sleep(time);
//    };




    var rot = rotto(0)

    var counter = CountThread(rot)
    counter.start()

    var thread = SimpleThread(rot)
    thread.start()


    fun get(): Int{
        return rot.get()
    }





}

class SimpleThread(rot: rotto) : Thread(){

    var c = rot.get()
    override fun run() {
        while(true) {
            println("${Thread.currentThread()} add...")
            Thread.sleep(1000)
        }
    }
}

class SimpleRunnable: Runnable{
    override fun run() {
        println("${Thread.currentThread()} has run")
    }
}
class rotto (var num: Int){
    fun add() {num++}
    fun get(): Int {return num}
}
class CountThread(rot: rotto) : Thread(){
    var c = rot.get()
    override fun run() {
        while(true){
            println("I'm counting ${c}")
            Thread.sleep(500)


        }
    }
}


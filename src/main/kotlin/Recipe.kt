class Recipe(var title: String, var material: ArrayList<String>, var description: String, var duration:Long, var canDoOther: Boolean, var done: Boolean, var left: Recipe?, var right: Recipe?) : Thread(){
    constructor(title: String, material: ArrayList<String>, description: String, duration: Long, canDoOther: Boolean, done: Boolean) : this(title, material, description, duration, canDoOther, done, null, null){
        // 생성자
    }

    override fun run(){
        Thread.sleep(duration/10)
        this.done = true
        println("$title end !")
    }
}


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
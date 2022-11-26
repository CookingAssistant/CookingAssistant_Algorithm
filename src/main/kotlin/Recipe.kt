class Recipe(var title: String, var material: ArrayList<String>, var description: String, var duration:Long, var canDoOther: Boolean, var left: Recipe?, var right: Recipe?) {
    constructor(title: String, material: ArrayList<String>, description: String, duration: Long, canDoOther: Boolean) : this(title, material, description, duration, canDoOther, null, null){
        // 생성자
    }
}
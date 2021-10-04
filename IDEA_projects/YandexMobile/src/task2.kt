import java.util.*

fun main() {

    val sc = Scanner(System.`in`)
    val count = sc.nextLine().toInt()

    val lines = mutableListOf<String>()
    repeat(count) { lines.add(sc.nextLine()) }

    val rootView = parseViewHierarchy(lines)

    val point = sc.nextLine().split(" ")
    val x = point[0].toInt()
    val y = point[1].toInt()
    val hitView = hitTest(rootView, x, y)

    println(hitView?.name ?: "null")
}

fun parseViewHierarchy(lines: List<String>): ViewGroup {
    val rootLine = lines[0].split(" ")
    val root = ViewGroup(rootLine[0], rootLine[1].toInt(), rootLine[2].toInt()
    , rootLine[3].toInt(), rootLine[4].toInt(), rootLine[5])        // добавили новое поле - имя родителя, чтобы было

    if (lines.size > 2) {                    // если список имеет строки кроме Root и последней с touchEvent, то значит есть дети
    for (i in 1 until lines.size) {          // идем с 1 элемента, тк 0-ой это Root
            val str = lines[i].split(" ")
            root.addView(ViewGroup(str[0], str[1].toInt(), str[2].toInt(), str[3].toInt(), str[4].toInt(), str[5]))
        }
    }

    return root
}

fun hitTest(root: ViewGroup, x: Int, y: Int): View? {
    for (i in root.children.indices.reversed()) {       // бежим с конца, даже стек не пригодился
        if (isInsideBounds(root.children[i], x ,y))     // вспомогательный метод, проверяющий границы
            return root.children[i]                     // если попал, то вернули первого ребенка, иначе смотрим далее
    }
    return if (isInsideBounds(root, x ,y)) root else null   // вернем Root если точка попадает в его границы, если даже он не попал, то null
}

fun isInsideBounds(view: View, x: Int, y: Int): Boolean {       // просто проверка границ
    if (view.left <= x && view.right >= x && view.top <= y && view.bottom >= y)
        return true
    return false
}

open class View(val name: String, val left: Int, val top: Int, val right: Int, val bottom: Int, var parent: String)

class ViewGroup(name: String, left: Int, top: Int, right: Int, bottom: Int, parent: String) : View(name, left, top, right, bottom, parent) {

    val children = mutableListOf<View>()

    fun getChildCount() = children.size
    fun getChildAt(index: Int) = children[index]
    fun addView(child: View) = children.add(child)
}
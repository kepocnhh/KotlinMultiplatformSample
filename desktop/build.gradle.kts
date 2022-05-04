task<Delete>("clean") {
    delete = (subprojects.map { it.buildDir } + buildDir).toSet()
}

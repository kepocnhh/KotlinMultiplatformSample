
object Version {
    const val compose = "1.1.1"
    const val jvmTarget = "1.8"
//    const val jvmTarget = "11"
    const val kotlin = "1.6.10"

    class Android internal constructor(
        val compileSdk: Int,
        val targetSdk: Int,
        val minSdk: Int
    )

//    object Android {
//        const val compileSdk = 31
//        const val targetSdk = compileSdk
//        const val minSdk = 23
//    }

    private const val compileSdk = 31
    val android = Android(
        compileSdk = compileSdk,
        targetSdk = compileSdk,
        minSdk = 23
    )

    object Application {
        const val code = 2
        const val name = "0.0.$code"
    }
}
